package com.star.service.impl;

import com.star.mapper.PraiseMapper;
import com.star.service.PraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PraiseServiceImpl implements PraiseService{
    @Autowired
    private PraiseMapper praiseMapper;

    /**
     * 点赞
     *
     * @param userId
     * @param infoId
     * @return lai
     */
    @Override
    public int addPraise(int userId, int infoId) {
        return praiseMapper.addPraise(userId,infoId);
    }

    /**
     * 检查是否点赞
     *
     * @param userId
     * @param infoId
     * @return lai
     */
    @Override
    public int checkPraise(int userId, int infoId) {
        return praiseMapper.checkPraise(userId,infoId);
    }

    /**
     * 取消点赞
     *
     * @param userId
     * @param infoId
     * @return lai
     */
    @Override
    public int delPraise(int userId, int infoId) {
        return praiseMapper.delPraise(userId,infoId);
    }
}
