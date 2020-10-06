package com.fatehole.destinychip.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author FateCat
 * @version 2020-10-06-18:49
 */
public class DestinyChipUtil {

    /**
     * 判断当前的请求是否为Ajax请求
     * @param request 请求对象
     * @return true: 是Ajax请求;
     *         false: 不是Ajax请求
     */
    public static boolean judgementRequestType(HttpServletRequest request) {

        // 获取请求头
        String acceptHeader = request.getHeader("accept");
        String xRequestHeader = request.getHeader("x-requested-with");

        return acceptHeader != null && acceptHeader.contains("application/json") || "XMLHttpRequest".equals(xRequestHeader);
    }
}
