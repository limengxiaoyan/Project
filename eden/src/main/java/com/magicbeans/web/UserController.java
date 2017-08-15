package com.magicbeans.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.magicbeans.entity.User;
import com.magicbeans.service.IUserService;
import com.magicbeans.util.PrintUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author magic-beans
 * @since 2017-07-28
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("page")
    public ModelAndView findPage(ModelAndView model){
        Page<User> userPage = userService.selectPage(new Page<User>());
        model.addObject("userPage",userPage);
        model.setViewName("index");
        PrintUtil.println(userPage);
        return model;
    }

    @GetMapping("update")
    public void update(){
      User user =   userService.selectById("1");
      userService.updateById(user);
    }

    @GetMapping("save")
    public void save(){
        User user = new User();
        user.setName("admin");
        user.setPassword("123456");
        userService.insert(user);
    }
    @GetMapping("indexPage")
    public ModelAndView uploadPage(ModelAndView model){
        model.setViewName("upload");
        model.addObject("username","zhangsan");
        PrintUtil.println("model:"+model);
        return model;
    }

	
}
