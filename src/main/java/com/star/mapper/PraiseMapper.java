package com.star.mapper;

import org.apache.ibatis.annotations.Param;

public interface PraiseMapper {
    /**
     * 点赞
     * @return lai
     */
    public int addPraise(@Param("userId") int userId, @Param("infoId") int infoId);

    /**
     * 检查是否点赞
     * @param userId
     * @param infoId
     * @return lai
     */
    public int checkPraise(@Param("userId") int userId, @Param("infoId") int infoId);

    /**
     * 取消点赞
     * @param userId
     * @param infoId
     * @return lai
     */
    public int delPraise(@Param("userId") int userId, @Param("infoId") int infoId);
}


