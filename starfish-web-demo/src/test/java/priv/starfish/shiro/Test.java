package priv.starfish.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * @author: jiahaixin
 * @date: 2019/10/15 10:13
 * @description:
 */
public class Test {


    public static void main(String[] args) {

        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();


        if (subject.hasRole("admin")){
            //有权限
        }else{
            //无权限
        }




    }

    @RequiresRoles("admin")
    public void hello(){
        //有权限
    }






}
