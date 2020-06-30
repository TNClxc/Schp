package com.star.service.impl;

import com.star.mapper.PersonMapper;
import com.star.pojo.User;
import com.star.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<User> getPersonage(int id) {
        return personMapper.getPersonage(id);
    }

    @Override
    public int delPerson(int id) {
        return personMapper.delPerson(id);
    }

    @Override
    public int upPerson(User upUser) {
        return personMapper.upPerson(upUser);
    }
}
