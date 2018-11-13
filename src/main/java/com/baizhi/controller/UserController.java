package com.baizhi.controller;

import com.baizhi.entity.Emp;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;

    /*注册*/
    @RequestMapping("register")
    public String register(User user) {
        userService.insert(user);
        return "redirect:/login.jsp";
    }

    /*登陆*/
    @RequestMapping("login")
    public String login(HttpServletRequest request, User user) {
        User user1 = userService.queryById(user);
        if (user1 != null) {
            //存user
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            //存name
            session.setAttribute("name", user.getUsername());
            return "redirect:/user/showAll";
        } else {
            return "redirect:/login.jsp";
        }
    }

    /*展示所有员工*/
    @RequestMapping("showAll")
    public String showAll(HttpServletRequest request) {
        List<Emp> emps = userService.queryAll();
        request.setAttribute("emp", emps);
        return "emplist";
    }

    /*删除员工*/
    @RequestMapping("deleteEmp")
    public String deleteEmp(String id) {
        userService.deleteone(id);
        return "redirect:/user/showAll";
    }

    /*修改员工*/
    @RequestMapping("updateEmp")
    public String updateEmp(Emp emp) {
        userService.updateone(emp);
        return "redirect:/user/showAll";
    }

    /*添加员工*/
    @RequestMapping("insertEmp")
    public String insertEmp(Emp emp) {
        userService.insertone(emp);
        return "redirect:/user/showAll";
    }
}
