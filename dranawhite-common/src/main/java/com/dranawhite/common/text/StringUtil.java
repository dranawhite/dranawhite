package com.dranawhite.common.text;

import com.dranawhite.common.constants.Separator;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 *
 * @author dranawhite
 * @version [1.0, 2018/4/24 18:09]
 */
public final class StringUtil {

    public static final String EMPTY = "";
    public static final String NULL = "null";

    /**
     * 填充字符串，前面补0
     *
     * @param val 待填充的字符串
     * @param len 字符串完整长度
     * @return 填充后的字符串
     */
    public static String fillStringWithZero(String val, int len) {
        StringBuilder originStr = new StringBuilder();
        for (int i = 0; i < len; i++) {
            originStr.append("0");
        }
        if (StringUtils.isEmpty(val)) {
            return originStr.toString();
        }
        if (val.length() >= len) {
            return val.substring(0, len);
        }
        return originStr.append(val).substring(val.length(), originStr.length());
    }

    /**
     * 统计字符串中符合规则的短语个数
     *
     * @param content 字符串值
     * @param regex   规则值
     * @return num
     */
    public static int countRegularMatches(String content, String regex) {
        return getRegularNameList(content, regex).size();
    }

    /**
     * 获取字符串中符合规则的短语名称
     *
     * @param content 字符串值
     * @param regex   规则值
     * @return list
     */
    public static List<String> getRegularNameList(String content, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        List<String> regularNameList = new ArrayList<>();
        while (matcher.find()) {
            regularNameList.add(matcher.group());
        }
        return regularNameList;
    }

    /**
     * 匹配字符串是否符合格式
     *
     * @param content 文本
     * @param regex   表达式
     * @return true or false
     */
    public static boolean isMatch(String content, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        return matcher.matches();
    }

    /**
     * 字符串去空格
     *
     * @param str 字符串
     * @return string
     */
    public static String removeSpace(String str) {
        char[] paramArr = str.toCharArray();
        StringBuilder paramSb = new StringBuilder();
        for (char param : paramArr) {
            if (param == Separator.CH_SPACE) {
                continue;
            }
            paramSb.append(param);
        }
        return paramSb.toString();
    }
}
