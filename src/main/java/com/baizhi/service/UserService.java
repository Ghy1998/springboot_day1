package com.baizhi.service;

import com.baizhi.entity.Emp;
import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    //登陆
    public User queryById(User user);

    //注册
    public void insert(User user);

    //查询所有员工
    public List<Emp> queryAll();

    //新增员工
    public void insertone(Emp emp);

    //修改员工
    public void updateone(Emp emp);

    //删除员工
    public void deleteone(String id);

    //根据id查询员工
    public Emp findone(String id);
}
