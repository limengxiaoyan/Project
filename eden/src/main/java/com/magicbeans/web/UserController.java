package com.magicbeans.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.magicbeans.entity.User;
import com.magicbeans.service.IUserService;
import com.magicbeans.util.PrintUtil;
import com.magicbeans.util.QiNiuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

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
    @Autowired
    private QiNiuUtil qiNiuUpload;

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

    /**
     * 多文件上传支持
     * @param upfile
     * @return
     * @throws Exception
     */
    @PostMapping(value = "uploadfile")
    public List uploadfile(@RequestParam(value = "files", required = false) MultipartFile[] upfile,String content) throws Exception{

        List<Map<String,String>> list = new ArrayList<>();
        if (upfile != null && upfile.length > 0){
            //循环获取file数组中得文件
            for(int i = 0;i<upfile.length;i++){
                Map<String,String> map = new HashMap<String, String>();
                MultipartFile file = upfile[i];
                String fileName = "image/"+IdWorker.get32UUID();
                String name = file.getName();
                byte[] fileByte = file.getBytes();
                //返回对象
                System.out.println("上传文件"+fileName);
                try {
                    qiNiuUpload.uploadFile(fileByte,fileName);
                    map.put("url",name);
                    map.put("name",fileName);
                    map.put("state","SUCCESS");
                }catch (Exception e){
                    e.printStackTrace();
                    map.put("state","上传失败!");
                }
                list.add(map);
            }
        }
        return list;
    }

    @GetMapping("download")
    public String download(String filePath){
        return qiNiuUpload.download(filePath);
    }
	
}
