package cn.tms.controller;

import cn.tms.entity.Privilege;
import cn.tms.entity.UserInfo;
import cn.tms.service.IUserInfoService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    /*注入service接口*/
    @Resource(name = "userInfoService")
    private IUserInfoService userInfoService;
    private static Logger logger = Logger.getLogger(UserController.class);
    /**
     * 登录的处理方法
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public Object doLogin(UserInfo info,HttpSession session){
        logger.info("用户登录...");
        UserInfo login = userInfoService.isLogin(info);
        System.out.println(login);
        if (login!=null&&login.getUsername()!=null){
            /*把登录信息放入session*/
            logger.info("用户登录成功！用户名："+login.getUsername());
            session.setAttribute("userinfo",login);
            return "y";
        }else {
            logger.info("用户登录失败！！！");
            return "n";
        }
    }

    /**
     * 登录成功后调用的方法
     */
    @RequestMapping("/doMain")
    public Object doMain(HttpSession session, Model model){
        logger.info("系统转到管理主页面...");
        logger.info("获取用户权限，展示页面...");
        //获取动态菜单数据
        UserInfo userinfo = (UserInfo) session.getAttribute("userinfo");
        //获取权限
        List<Privilege> privilegeList = userInfoService.findAllPrivilegesByUserId(userinfo.getUserid());

        //保存父子关系的权限
        List<Privilege> rootMenus = new ArrayList<Privilege>();
        //工具：转成有父子关系的权限
        for (Privilege item:privilegeList){
            Privilege childMenu = item;
            int pid = childMenu.getParent();
            if (pid==0){
                rootMenus.add(item);
            }else {
                for (Privilege innerMenu:privilegeList){
                    Integer id = innerMenu.getId();
                    if(id==pid){
                        Privilege parentMenu = innerMenu;
                        parentMenu.getChildren().add(childMenu);
                        break;
                    }
                }
            }
        }
        //2.放入Model
        model.addAttribute("list",rootMenus);
        //3.给出渲染数据的视图名称
        logger.info("渲染到主页面。。。");
        return "/main.jsp";
    }
}
