package com.fatehole.destinychip.service.impl;

import com.fatehole.destinychip.entity.po.MemberPO;
import com.fatehole.destinychip.entity.po.MemberPOExample;
import com.fatehole.destinychip.mapper.MemberPOMapper;
import com.fatehole.destinychip.service.api.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author FateCat
 * @version 1.0.0
 * @date Create in 2020/11/02/8:24
 */
@Transactional(readOnly = true)
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberPOMapper memberPOMapper;

    @Override
    public MemberPO getMemberPoByLoginAccountRemote(String loginAccount) {

        // 创建Example对象
        MemberPOExample example = new MemberPOExample();

        // 创建Criteria对象
        MemberPOExample.Criteria criteria = example.createCriteria();

        // 添加查询条件
        criteria.andLoginAccountEqualTo(loginAccount);

        // 执行
        List<MemberPO> memberPos = memberPOMapper.selectByExample(example);

        // 返回结果
        return memberPos.get(0);
    }

    // @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class,readOnly = false)
    @Override
    public void saveMember(MemberPO memberPO) {
        memberPOMapper.insertSelective(memberPO);
    }
}
