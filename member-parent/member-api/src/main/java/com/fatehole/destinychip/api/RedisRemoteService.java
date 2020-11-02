package com.fatehole.destinychip.api;

import ch.qos.logback.core.util.TimeUtil;
import com.fatehole.destinychip.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.TimeUnit;

/**
 * @author FateCat
 * @version 1.0.0
 * @date Create in 2020/11/02/10:02
 */
@FeignClient("destiny-chip-redis")
public interface RedisRemoteService {

    @RequestMapping("/set/remote/redis/key/value")
    ResultEntity<String> setRemoteRedisKeyValue(@RequestParam("key") String key,
                                                @RequestParam("value") String value);

    @RequestMapping("/set/remote/redis/key/value/timeout")
    ResultEntity<String> setRemoteRedisKeyValueWithTimeout(@RequestParam("key") String key,
                                                           @RequestParam("value") String value,
                                                           @RequestParam("time") long time,
                                                           @RequestParam("timeUnit") TimeUnit timeUnit);

    @RequestMapping("/get/redis/string/value/key")
    ResultEntity<String> getRedisStringValueByKey(@RequestParam("key") String key);

    @RequestMapping("/remove/remote/redis/key")
    ResultEntity<String> removeRemoteRedisKey(@RequestParam("key") String key);
}
