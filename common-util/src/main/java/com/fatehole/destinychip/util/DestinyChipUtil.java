package com.fatehole.destinychip.util;

import com.aliyun.api.gateway.demo.util.HttpUtils;
import com.fatehole.destinychip.constant.DestinyChipConstant;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

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

    /**
     * 给第三方短信接口发送请求
     * @param host         短信接口调用的url地址
     * @param path         具体发送短信功能的地址
     * @param method       请求方式
     * @param phoneNum     发送对象的手机号
     * @param appCode      调用第三方ApiCode
     * @param smsSignId    签名的编号
     * @param templateId   模板的编号
     * @return 信息
     */
    public static ResultEntity<String> sendShortMessage(String host,
                                                        String path,
                                                        String method,
                                                        String phoneNum,
                                                        String appCode,
                                                        String smsSignId,
                                                        String templateId) {

        // // 短信接口调用的url地址
        // String host = "https://gyytz.market.alicloudapi.com";
        //
        // // 具体发送短信功能的地址
        // String path = "/sms/smsSend";
        //
        // // 请求方式
        // String method = "POST";
        //
        // // 登录到阿里云控制态找到购买的短信接口的appCode
        // String appcode = "c39653b25b44475eb390fea4234e23fc";

        Map<String, String> headers = new HashMap<>();

        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appCode);

        // 封装的其他参数
        Map<String, String> querys = new HashMap<>();

        // 生成验证码
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            int random = (int) (Math.random() * 10);
            builder.append(random);
        }

        String code = builder.toString();


        // 需要发送的手机号
        querys.put("mobile", phoneNum);

        // 发送的验证码： 模板中变量参数名,参数值,有多个时使用英文","隔开,例如:**验证码**:123455,**姓名**:张三
        querys.put("param", code);

        // 签名ID，联系客服人员申请成功的签名ID。【测试请用：2e65b1bb3d054466b82f0c9d125465e2】
        querys.put("smsSignId", smsSignId);

        // 模板ID，联系客服人员申请成功的模板ID。【测试请用：f5e68c3ad6b6474faa8cd178b21d3377】
        querys.put("templateId", templateId);

        Map<String, String> bodys = new HashMap<>();

        try {
            /*
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);

            StatusLine statusLine = response.getStatusLine();

            int statusCode = statusLine.getStatusCode();

            String reasonPhrase = statusLine.getReasonPhrase();

            if (statusCode == 0) {
                // 操作成功将生成的验证码返回
                return ResultEntity.successWithData(code);
            }

            return ResultEntity.failed(reasonPhrase);

        } catch (Exception e) {

            e.printStackTrace();

            return ResultEntity.failed(e.getMessage());
        }
    }
}
