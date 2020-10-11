package com.fatehole.destinychip.util;

import com.fatehole.destinychip.constant.DestinyChipConstant;
import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 尚筹网项目通用的工具方法
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

    /**
     * 对字符串进行md5加密
     * @param source 明文密码字符串
     * @return 加密后的字符串
     */
    public static String md5(String source) {

        // 判断source是否为有效值
        if (source == null || source.length() == 0) {
            // 如果不是有效字符串就抛出异常
            throw new RuntimeException(DestinyChipConstant.MESSAGE_STRING_INVALIDATE);
        } else {
            try {
                String algorithm = "md5";
                // 获取MessageDigest对象
                MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
                // 获取明文密码要求的字符串
                byte[] input = source.getBytes();
                // 执行加密操作
                byte[] output = messageDigest.digest(input);
                // 创建BigInteger对象
                BigInteger integer = new BigInteger(1, output);
                // 将BigInteger对象转为十六进制，并返回
                return integer.toString(16).toUpperCase();

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
