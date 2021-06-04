package easymall.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import easymall.mail.SendJMail;
import easymall.po.User;
import easymall.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	@RequestMapping("/user/login")
	public String login(User user,HttpSession session,Model model) {
		System.out.println("进入login:"+user.getUsername());
		User muser=userService.login(user);
		if(muser!=null) {
			session.setAttribute("user", muser);
			return "redirect:/index.jsp";
		}else {
			model.addAttribute("message","用户名密码错误,或账号未激活!");
			return "login";
		}
	}
	
	@RequestMapping("/user/checkUser")
	public void check(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String username=request.getParameter("username");//jsp标签中,name属性的值
		if(userService.checkUsername(username))
			response.getWriter().print("用户名"+username+"已被注册!");	
		else
			response.getWriter().print("恭喜您 "+username+"可以使用!");	
	}
	
	@RequestMapping("/user/regist")
	public String regist(User user,String valistr,HttpSession session,Model model) {
		if(user.getUsername()==null||user.getUsername()=="") {
			model.addAttribute("msg","用户名不能为空!");
			return "regist";
		}
		if(user.getPassword()==null||user.getPassword()=="") {
			model.addAttribute("msg","密码不能为空!");
			return "regist";
		}
		if(!valistr.equalsIgnoreCase(session.getAttribute("code").toString())) {
			model.addAttribute("msg","密码不能为空!");
			return "regist";
		}
		if(userService.regist(user)>0) {
			model.addAttribute("msg","注册成功!请注意查看邮箱并激活账号");
			SendJMail.sendMail(user.getEmail(), "去此链接完成激活:  http://localhost:8080/EasyMall/user/activation?username="+user.getUsername());
			return "regist";
		}else {
			model.addAttribute("msg","注册失败");
			return "regist";
		}
	}
	
	@RequestMapping("/user/activation")
	public String activation(String username,Model model) {
		userService.activation(username);
		model.addAttribute("activation", "激活成功");
		return "login";
	}
}
