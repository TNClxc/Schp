package com.star.service;

import org.apache.ibatis.annotations.Param;

public interface PraiseService {
    /**
     * 点赞
     * @return lai
     */
    public int addPraise( int userId,  int infoId);

    /**
     * 检查是否点赞
     * @param userId
     * @param infoId
     * @return lai
     */
    public int checkPraise(int userId, int infoId);

    /**
     * 取消点赞
     * @param userId
     * @param infoId
     * @return lai
     */
    public int delPraise( int userId, int infoId);
}
