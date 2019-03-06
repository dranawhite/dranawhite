package com.dranawhite.common.date;

import com.dranawhite.common.constants.Separator;
import com.dranawhite.common.exception.ResultCodeEnum;
import com.dranawhite.common.exception.file.DranaParserException;
import com.dranawhite.common.exception.request.DranaIllegalArgumentException;
import com.dranawhite.common.exception.request.DranaRequestException;
import com.dranawhite.common.text.StringUtil;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 时间计算器
 *
 * @author dranawhite
 * @version $Id: DateTimeCalculator.java, v 0.1 2019-02-21 18:52 dranawhite Exp $$
 */
public final class DateTimeCalculator {

    private static List<Expression> expressionList;

    /**
     * 计算表达式的日期
     * <pre>
     *     样例DAY(-1).
     * </pre>
     */
    public static String calculate(final String expression, final String format) {
        validateExpression(expression);
        try {
            Calculator calculator = new Calculator(new DateTime());
            Class calculatorClass = calculator.getClass();
            for (Expression expressionObj : expressionList) {
                Method method = calculatorClass.getDeclaredMethod(expressionObj.method, int.class);
                calculator = (Calculator) method.invoke(calculator, expressionObj.param);
            }
            return calculator.toFormattedDate(format);
        } catch (Exception ex) {
            throw new DranaParserException("解析日期失败", ResultCodeEnum.SERVICE_UNAVAILABLE, ex);
        }
    }

    enum DateTimeKeyEnum {

        DAY("DAY"),
        WEEK("WEEK"),
        MONTH("MONTH"),
        YEAR("YEAR"),

        YEAR_MONTH("YEAR[MONTH]"),
        YEAR_WEEK("YEAR[WEEK]"),
        YEAR_DAY("YEAR[DAY]"),
        MONTH_DAY("MONTH[DAY]"),
        WEEK_DAY("WEEK[DAY]");

        private String key;

        private volatile static Set<String> keySet;

        DateTimeKeyEnum(String key) {
            this.key = key;
        }

        public String value() {
            return this.key;
        }

        public static DateTimeKeyEnum findDateTimeKeyEnum(String key) {
            for (DateTimeKeyEnum dateTimeKeyEnum : DateTimeKeyEnum.values()) {
                if (StringUtils.equals(dateTimeKeyEnum.key, key)) {
                    return dateTimeKeyEnum;
                }
            }
            throw new DranaIllegalArgumentException("无效的枚举值[{}]", ResultCodeEnum.ILLEGAL_REQUEST, key);
        }

        public static Set<String> keySet() {
            if (keySet == null) {
                synchronized (DateTimeCalculator.class) {
                    if (keySet == null) {
                        keySet = new HashSet<>();
                        for (DateTimeKeyEnum dateTimeKeyEnum : DateTimeKeyEnum.values()) {
                            keySet.add(dateTimeKeyEnum.key);
                        }
                    }
                }
            }
            return keySet;
        }
    }

    enum DateTimeFormatEnum {

        NUMBER_TO_YEAR("yyyy"),
        NUMBER_TO_MONTH("yyyyMM"),
        NUMBER_TO_WEEK("yyyyww"),
        NUMBER_TO_DAY("yyyyMMdd");

        private String format;

        DateTimeFormatEnum(String format) {
            this.format = format;
        }

        public String format() {
            return this.format;
        }
    }

    private static class Calculator {

        private DateTime dateTime;

        Calculator(DateTime dateTime) {
            this.dateTime = dateTime;
        }

        Calculator plusDay(int day) {
            return new Calculator(dateTime.plusDays(day));
        }

        Calculator plusWeek(int week) {
            return new Calculator(dateTime.plusWeeks(week));
        }

        Calculator plusMonth(int month) {
            return new Calculator(dateTime.plusMonths(month));
        }

        Calculator plusYear(int year) {
            return new Calculator(dateTime.plusYears(year));
        }

        Calculator dayOfWeek(int dayOfWeek) {
            return new Calculator(dateTime.withDayOfWeek(dayOfWeek));
        }

        Calculator dayOfMonth(int dayOfMonth) {
            return new Calculator(dateTime.withDayOfMonth(dayOfMonth));
        }

        Calculator dayOfYear(int dayOfYear) {
            return new Calculator(dateTime.withDayOfYear(dayOfYear));
        }

        Calculator weekOfYear(int weekOfYear) {
            return new Calculator(dateTime.withWeekOfWeekyear(weekOfYear));
        }

        Calculator monthOfYear(int monthOfYear) {
            return new Calculator(dateTime.withMonthOfYear(monthOfYear));
        }

        Date toDate() {
            return dateTime.toDate();
        }

        String toFormattedDate(String format) {
            return dateTime.toString(format);
        }
    }

    private static class Expression {

        String method;

        int param;

        Expression(String method, int param) {
            this.method = method;
            this.param = param;
        }
    }

    private static String transferToMethodName(String method) {
        DateTimeKeyEnum dateTimeKeyEnum = DateTimeKeyEnum.findDateTimeKeyEnum(method);
        switch (dateTimeKeyEnum) {
            case DAY:
                return "plusDay";
            case WEEK:
                return "plusWeek";
            case MONTH:
                return "plusMonth";
            case YEAR:
                return "plusYear";
            case WEEK_DAY:
                return "dayOfWeek";
            case MONTH_DAY:
                return "dayOfMonth";
            case YEAR_DAY:
                return "dayOfYear";
            case YEAR_WEEK:
                return "weekOfYear";
            case YEAR_MONTH:
                return "monthOfYear";
            default:
                return null;
        }

    }

    /**
     * <pre>
     *     格式:DAY(-1).WEEK[DAY](1)
     *          DAY(-1).WEEK(-3).WEEK[DAY](1)
     *          YEAR[MONTH](2).MONTH[DAY](15)
     * </pre>
     */
    private static boolean validateExpression(final String expression) {
        if (StringUtils.isBlank(expression)) {
            throw new DranaRequestException("表达式不能为空", ResultCodeEnum.ILLEGAL_REQUEST);
        }
        String[] wordArr = StringUtils.split(expression, Separator.POINT);
        expressionList = new ArrayList<>(wordArr.length);
        String keyWord;
        for (String word : wordArr) {
            char[] wordChArr = word.toCharArray();
            char[] keyWordChArr = new char[20];
            int index = 0;
            for (int i = 0, len = wordChArr.length; i < len; i++) {
                if (wordChArr[i] == Separator.CH_LEFT_PARENTHESES) {
                    break;
                }
                keyWordChArr[index++] = wordChArr[i];
            }
            keyWord = new String(keyWordChArr, 0, index);
            if (!DateTimeKeyEnum.keySet().contains(keyWord)) {
                throw new DranaRequestException("表达式错误，未识别的关键字[{}]", ResultCodeEnum.ILLEGAL_REQUEST, keyWord);
            }
            String wordParam = new String(wordChArr, index + 1, wordChArr.length - index - 2);
            if (!StringUtil.isMatch(wordParam, "(-?\\d)+")) {
                throw new DranaRequestException("表达式错误，参数应该是整数[{}]", ResultCodeEnum.ILLEGAL_REQUEST, wordParam);
            }
            Expression expressionObj = new Expression(transferToMethodName(keyWord), Integer.parseInt(wordParam));
            expressionList.add(expressionObj);
        }
        return true;
    }

}