package com.star.service.impl;

import com.star.mapper.InfoMapper;
import com.star.pojo.Info;
import com.star.pojo.User;
import com.star.pojo.InfoType;
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
     * @param currentPage
     * @param totalCount
     * @return
     */
    @Override
    public List<Info> getInfoList(int currentPage, int totalCount) {
        return infoMapper.getInfoList(currentPage,totalCount);
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
    /**
     * 删除用户
     *
     * @param infoId
     * @return lai
     */
    @Override
    public int delInfo(int infoId) {
        return infoMapper.delInfo(infoId);
    }

    /**
     * 查询文章分类
     *
     * @return lai
     */
    @Override
    public List<InfoType> getInfoTypeList() {
        return infoMapper.getInfoTypeList();
    }

    /**
     * 新增发布信息
     *
     * @param info
     * @return lai
     */
    @Override
    public int infoAdd(Info info) {
        return infoMapper.infoAdd(info);
    }

    /**
     * 修改发布信息
     *
     * @param info
     * @return lai
     */
    @Override
    public int upInfo(Info info) {
        return infoMapper.upInfo(info);
    }

    /**
     * 按ID查询info信息
     *
     * @param id
     * @return
     */
    @Override
    public Info getInfoById(int id) {
        return infoMapper.getInfoById(id);
    }


}
