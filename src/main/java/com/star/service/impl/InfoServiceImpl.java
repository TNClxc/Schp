package com.star.service.impl;

import com.star.mapper.InfoMapper;
import com.star.pojo.Info;
import com.star.pojo.User;
import com.star.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Spliterator;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoMapper infoMapper;

    /**
     * 分页 传入当前页数 和 页面容量
     *
     * @param currentPage
     * @param tatalCount
     * @return
     */
    @Override
    public List<Info> getInfoList(int currentPage, int tatalCount) {
        return infoMapper.getInfoList(currentPage,tatalCount);
    }

    /**
     * 查询记录数
     *
     * @return
     */
    @Override
    public int getTotalCount() {
        return infoMapper.getTotalCount();
    }

    @Override
    public List<User> getPersonage(int id) {
        return infoMapper.getPersonage(id);
    }

    @Override
    public int delPerson(int id) {
        return infoMapper.delPerson(id);
    }

    @Override
    public int upPerson(User upUser) {
        return infoMapper.upPerson(upUser);
    }
}
