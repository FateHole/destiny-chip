package com.fatehole.destinychip.controller;

import com.fatehole.destinychip.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.TimeUnit;

/**
 * @author FateCat
 * @version 1.0.0
 * @date Create in 2020/11/02/14:08
 */
@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("/set/remote/redis/key/value")
    ResultEntity<String> setRemoteRedisKeyValue(@RequestParam("key") String key,
                                                @RequestParam("value") String value) {

        try {

            ValueOperations<String, String> operations = redisTemplate.opsForValue();

            operations.set(key, value);

            return ResultEntity.successWithOutData();

        } catch (Exception e) {

            e.printStackTrace();

            return ResultEntity.failed(e.getMessage());
        }

    }

    @RequestMapping("/set/remote/redis/key/value/timeout")
    ResultEntity<String> setRemoteRedisKeyValueWithTimeout(@RequestParam("key") String key,
                                                           @RequestParam("value") String value,
                                                           @RequestParam("time") long time,
                                                           @RequestParam("TimeUnit") TimeUnit timeUnit) {

        try {

            ValueOperations<String, String> operations = redisTemplate.opsForValue();

            operations.set(key, value, time, timeUnit);

            return ResultEntity.successWithOutData();

        } catch (Exception e) {

            e.printStackTrace();

            return ResultEntity.failed(e.getMessage());

        }

    }

    @RequestMapping("/get/redis/string/value/key")
    ResultEntity<String> getRedisStringValueByKey(@RequestParam("key") String key) {

        try {

            ValueOperations<String, String> operations = redisTemplate.opsForValue();

            String value = operations.get(key);

            return ResultEntity.successWithData(value);

        } catch (Exception e) {

            e.printStackTrace();

            return ResultEntity.failed(e.getMessage());

        }

    }

    @RequestMapping("/remove/remote/redis/key")
    ResultEntity<String> removeRemoteRedisKey(@RequestParam("key") String key) {

        try {

            redisTemplate.delete(key);

            return ResultEntity.successWithOutData();

        } catch (Exception e) {

            e.printStackTrace();

            return ResultEntity.failed(e.getMessage());

        }

    }

}
