package com.fatehole.destinychip.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author FateCat
 * @version 1.0.0
 * @date Create in 2020/11/04/13:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "short.message")
public class ShortMessageProperties {

    private String host;
    private String path;
    private String method;
    private String phoneNum;
    private String appCode;
    private String smsSignId;
    private String templateId;

}
