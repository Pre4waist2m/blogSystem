package demo.controller;

import demo.pojo.blog;
import demo.pojo.userClass;
import demo.service.IService.IBlogService;
import demo.service.IService.IUserClassService;
import demo.service.IService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class blogController{
// @RequestMapping("/")
// public String index(){
//         return "mc";
//         }
//         }

@RestController
public class blogController {
        @Autowired
        private IUserService iUserService;
        @Autowired
        private IBlogService iBlogService;
        @Autowired
        private IUserClassService iUserClassService;

        /*
        登录模块开发
        */
        @RequestMapping(value = "/login", method = RequestMethod.POST)
        public String login(@RequestParam(value = "userName") String userName,@RequestParam(value = "password") String password, Model model) {
                if (userName.isEmpty() == false) {
                        if (password.isEmpty() == false) {
                                if (iUserService.login(userName, password).getStatus() == 1) {
                                        model.addAttribute("failMsg", iUserService.login(userName, password).getMsg());
                                        return "登陆";
                                        // todo
                                }
                                model.addAttribute("successMsg", iUserService.login(userName, password).getMsg());
                                model.addAttribute("data", iUserService.login(userName, password).getData());
                                return "首页";
                                // todo
                        } else {
                                model.addAttribute("failMsg", "密码不能为空");
                                return "登陆界面";
                        }
                } else {
                        model.addAttribute("failMsg", "用户名不能为空");
                        return "登陆界面2";
                }
        }

        /*
        注册模块
        */
        @RequestMapping(value = "/register",method = RequestMethod.POST)
        public String register(@RequestParam(value = "userName") String userName,@RequestParam(value = "password") String password, Model model) {
                if (userName.isEmpty() == false) {
                        if (password.isEmpty() == false) {
                                if (iUserService.regiester(userName, password).getStatus() == 1) {
                                        model.addAttribute("failMsg", iUserService.regiester(userName, password).getMsg());
                                        return "register.html";
                                }
                                model.addAttribute("successMsg", iUserService.regiester(userName, password).getMsg());
                                return "login.html";
                        } else {
                                model.addAttribute("failMsg", "密码不能为空");
                                return "register.html密码空";
                        }
                } else {
                        model.addAttribute("failMsg", "用户名不能为空");
                        return "register.html用户名空";
                }
        }

        /*
        * 博客模块开发
        * */
        @RequestMapping(value = "/writeBlog",method = RequestMethod.POST)
        public String writeBlog(@RequestParam(value = "userId") int userId,@RequestParam("classContent") String classContent,@RequestParam("blogTitle") String blogTitle,@RequestParam("blogContent") String blogContent,@RequestParam("blogLabel") String blogLabel){
                if(blogTitle.isEmpty()==false&&blogContent.isEmpty()==false&&classContent.isEmpty()==false){
                        if(iBlogService.selectBlogIdByContent(classContent).getStatus()==0){
                                int classId=(Integer)iBlogService.selectBlogIdByContent(classContent).getData();
                                blog blog1=new blog();
                                blog1.setUserId(userId);
                                blog1.setClassId(classId);
                                blog1.setBlogTitle(blogTitle);
                                blog1.setBlogContent(blogContent);
                                blog1.setBlogLabel(blogLabel);
                                blog1.setViewTimes(null);
                                blog1.setCreateTime(null);

                                userClass user_class=new userClass(userId,classId,1);
                                if(iBlogService.insertBlog(blog1).getStatus()==0){
                                        if(iUserClassService.insertOrUpdateNumber(user_class).getStatus()==0){
                                                return "文章写入成功";
                                        }else{
                                                return "文章写入失败";
                                        }
                                }else {
                                        System.out.println("1");
                                        return "插入文章失败";
                                }

                        }else{
                                return "获取classId失败";
                        }
                }else{
                        return "writeBlog.html(文章不能为空)";
                }
        }

        /*
        * 查看个人分类及文章内容
        * */
        @RequestMapping(value = "/lookBlog",method = RequestMethod.POST)
        public String lookBlog(@RequestParam("userId") int userId,Model model){
                if(iUserClassService.getClassAndNumberByUserId(userId).getStatus()==0){
                        model.addAttribute("TheClass",iUserClassService.getClassAndNumberByUserId(userId).getData());
                        if(iUserClassService.getBlog(userId).getStatus()==0){
                                model.addAttribute("TheBlog",iUserClassService.getBlog(userId).getData());
                                return "查看博文成功";
                        }else{
                                return "查看博文失败";
                        }
                }else{
                        return "返回分类失败";
                }
        }
}


