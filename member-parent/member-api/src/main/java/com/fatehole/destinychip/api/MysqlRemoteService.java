package com.fatehole.destinychip.api;

import com.fatehole.destinychip.entity.po.MemberPO;
import com.fatehole.destinychip.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author FateCat
 * @version 1.0.0
 * @date Create in 2020/11/02/8:03
 */
@FeignClient("destiny-chip-mysql")
public interface MysqlRemoteService {

    /**
     * 通过登陆账号获取远程的MemberPO
     * @param loginAccount 登陆账号
     * @return 返回信息
     */
    @RequestMapping("/get/memberpo/by/login/remote")
    ResultEntity<MemberPO> getMemberPoByLoginAccountRemote(@RequestParam("loginAccount") String loginAccount);

    @RequestMapping("/save/member/remote")
    ResultEntity<MemberPO> saveMember(@RequestBody MemberPO memberPO);
}
