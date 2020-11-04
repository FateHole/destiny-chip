package com.fatehole.destinychip.service.api;

import com.fatehole.destinychip.entity.po.MemberPO;

/**
 * @author FateCat
 * @version 1.0.0
 * @date Create in 2020/11/02/8:23
 */
public interface MemberService {

    /**
     * 通过登陆账号获取远程的MemberPO
     * @param loginAccount 登陆账号
     * @return 返回信息
     */
    MemberPO getMemberPoByLoginAccountRemote(String loginAccount);

    void saveMember(MemberPO memberPO);
}
