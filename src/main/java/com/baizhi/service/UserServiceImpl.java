package com.baizhi.service;

import com.baizhi.aspect.Log;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.Emp;
import com.baizhi.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /*登陆*/
    @Transactional(propagation = Propagation.SUPPORTS)
    public User queryById(User user) {
        return userDao.queryById(user);
    }

    /*注册*/
    @Log(name = "insert") //只切这一个方法
    public void insert(User user) {
        user.setId(UUID.randomUUID().toString());
        userDao.insert(user);
    }

    /*查所有*/
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Emp> queryAll() {
        return userDao.queryAll();
    }

    /*添加*/
    public void insertone(Emp emp) {
        emp.setId(UUID.randomUUID().toString());
        userDao.insertone(emp);
    }

    /*修改*/
    public void updateone(Emp emp) {
        userDao.updateone(emp);
    }

    /*删除*/
    public void deleteone(String id) {
        userDao.deleteone(id);
    }

    /*查一个*/
    @Transactional(propagation = Propagation.SUPPORTS)
    public Emp findone(String id) {
        return userDao.findone(id);
    }
}
