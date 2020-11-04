package com.fatehole.destinychip.controller;

import com.fatehole.destinychip.api.RedisRemoteService;
import com.fatehole.destinychip.config.ShortMessageProperties;
import com.fatehole.destinychip.constant.DestinyChipConstant;
import com.fatehole.destinychip.util.DestinyChipUtil;
import com.fatehole.destinychip.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

/**
 * @author FateCat
 * @version 1.0.0
 * @date Create in 2020/11/04/12:15
 */
@Controller
public class MemberController {

    @Autowired
    private ShortMessageProperties shortMessageProperties;

    @Autowired(required = false)
    private RedisRemoteService redisRemoteService;

    @ResponseBody
    @RequestMapping("/auth/member/send/short/message")
    public ResultEntity<String> sendMessage(@RequestParam("phoneNum") String phoneNum) {

        // 发送验证码
        ResultEntity<String> stringMessageResultEntity = DestinyChipUtil.sendShortMessage(
                shortMessageProperties.getHost(),
                shortMessageProperties.getPath(),
                shortMessageProperties.getMethod(),
                phoneNum,
                shortMessageProperties.getAppCode(),
                shortMessageProperties.getSmsSignId(),
                shortMessageProperties.getTemplateId());

        // 判断发送的结果
        if (ResultEntity.SUCCESS.equals(stringMessageResultEntity.getResult())) {

            // 成功返回，验证码存入redis
            String code = stringMessageResultEntity.getData();

            String key = DestinyChipConstant.REDIS_CODE_PREFIX + phoneNum;

            ResultEntity<String> stringResultEntity = redisRemoteService.setRemoteRedisKeyValueWithTimeout(key, code, 15, TimeUnit.MINUTES);

            if (ResultEntity.SUCCESS.equals(stringResultEntity.getResult())) {
                return ResultEntity.successWithOutData();
            } else {
                return stringResultEntity;
            }
        } else {
            return stringMessageResultEntity;
        }
    }
}
