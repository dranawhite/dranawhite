package com.dranawhite.common.date;

import com.dranawhite.common.text.StringUtil;
import com.dranawhite.common.validation.ArgumentValidator;

import org.joda.time.DateTime;
import org.springframework.format.datetime.DateFormatter;

import java.util.Date;
import java.util.Locale;

/**
 * 日期工具类
 *
 * <pre>
 *     Joda-Time jar包提供支持
 * </pre>
 *
 * @author dranawhite
 * @version [1.0, 2018/4/17 14:00]
 */
public final class DateUtil {

    private static DateFormatter formatter = new DateFormatter();

    public static class DateFormat {

        private String pattern;

        private DateFormat(String pattern) {
            this.pattern = pattern;
        }

        public static final DateFormat COMMON_MILL_SECOND = new DateFormat("yyyy-MM-dd HH:mm:ss_SSS");
        public static final DateFormat COMMON_SECOND = new DateFormat("yyyy-MM-dd HH:mm:ss");
        public static final DateFormat COMMON_DAY = new DateFormat("yyyy-MM-dd");
        public static final DateFormat COMMON_MONTH = new DateFormat("yyyy-MM");

        public static final DateFormat SERIAL_MILL_SECOND = new DateFormat("yyyyMMddHHmmssSSS");
        public static final DateFormat SERIAL_SECOND = new DateFormat("yyyyMMddHHmmss");
        public static final DateFormat SERIAL_DAY = new DateFormat("yyyyMMdd");
        public static final DateFormat SERIAL_MONTH = new DateFormat("yyyyMM");

        @Override
        public String toString() {
            return pattern == null ? StringUtil.EMPTY : pattern;
        }
    }

    /**
     * 格式化日期
     * <pre>
     *     序列格式，精确到秒
     * </pre>
     *
     * @param date 日期
     * @return string
     */
    public static String formatSerialSecond(Date date) {
        ArgumentValidator.assertNotNull(date);
        formatter.setPattern(DateFormat.SERIAL_SECOND.toString());
        return formatter.print(date, Locale.CHINESE);
    }

    /**
     * 格式化日期
     * <pre>
     *     精确到秒
     * </pre>
     *
     * @param date 日期
     * @return string
     */
    public static String formatSeconds(Date date) {
        ArgumentValidator.checkNotNull(date);
        formatter.setPattern(DateFormat.COMMON_SECOND.toString());
        return formatter.print(date, Locale.CHINESE);
    }

    /**
     * 格式化日期
     *
     * @param date       日期
     * @param dateFormat 日期格式
     * @return string
     */
    public static String format(Date date, DateFormat dateFormat) {
        ArgumentValidator.checkNotNull(date, dateFormat);
        formatter.setPattern(dateFormat.toString());
        return formatter.print(date, Locale.CHINESE);
    }

    /**
     * 返回day天后的日期
     *
     * @param day 天数
     * @return Date
     */
    public static Date dateAfterDay(int day) {
        DateTime dateTime = new DateTime();
        return dateTime.plusDays(day).toDate();
    }

    /**
     * 返回day天前的日期
     *
     * @param day 天数
     * @return Date
     */
    public static Date dateBeforeDay(int day) {
        DateTime dateTime = new DateTime();
        return dateTime.minusDays(day).toDate();
    }

    /**
     * 获取一周中的日期
     *
     * @param day 天数
     * @return Date
     */
    public static Date dateAtWeek(int day) {
        DateTime weekDay = DateTime.now()
                .withDayOfWeek(day)
                .withHourOfDay(0)
                .withMinuteOfHour(0)
                .withSecondOfMinute(0);
        return weekDay.toDate();
    }

    /**
     * 获取几周前的日期
     *
     * @param week 周数
     * @param day  天数
     * @return Date
     */
    public static Date dateBeforeWeek(int week, int day) {
        DateTime weekDay = DateTime.now()
                .minusWeeks(week)
                .withDayOfWeek(day)
                .withHourOfDay(0)
                .withMinuteOfHour(0)
                .withSecondOfMinute(0);
        return weekDay.toDate();
    }

    /**
     * 获取一月中的日期
     *
     * @param day 天数
     * @return Date
     */
    public static Date dateAtMonth(int day) {
        DateTime monthDay = DateTime.now()
                .withDayOfMonth(day)
                .withHourOfDay(0)
                .withMinuteOfHour(0)
                .withSecondOfMinute(0);
        return monthDay.toDate();
    }

    /**
     * 获取该月的最后一天
     *
     * @param month 月份
     * @return date
     */
    public static Date lastDayAtMonth(int month) {
        DateTime lastDayOfMonth = DateTime.now().withMonthOfYear(month).dayOfMonth().withMaximumValue();
        return lastDayOfMonth.toDate();
    }

    /**
     * 获取几个月前的日期
     *
     * @param month 月数
     * @param day   天数
     * @return Date
     */
    public static Date dateBeforeMonth(int month, int day) {
        DateTime monthDay = DateTime.now()
                .minusMonths(month)
                .withDayOfMonth(day)
                .withHourOfDay(0)
                .withMinuteOfHour(0)
                .withSecondOfMinute(0);
        return monthDay.toDate();
    }

    public static Date today() {
        return DateTime.now().toDate();
    }
}
