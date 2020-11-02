package com.fatehole.destinychip.controller;

import com.fatehole.destinychip.entity.po.MemberPO;
import com.fatehole.destinychip.service.api.MemberService;
import com.fatehole.destinychip.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FateCat
 * @version 1.0.0
 * @date Create in 2020/11/02/8:20
 */
@RestController
public class MemberProviderController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/get/memberpo/by/login/remote")
    public ResultEntity<MemberPO> getMemberPoByLoginAccountRemote(@RequestParam("loginAccount") String loginAccount) {

        try {
            // 调用本地方法查询
            MemberPO memberPo = memberService.getMemberPoByLoginAccountRemote(loginAccount);
            // 没有抛出异常
            return ResultEntity.successWithData(memberPo);
        } catch (Exception e) {
            e.printStackTrace();
            // 抛出异常
            return ResultEntity.failed(e.getMessage());
        }

    }
}
