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
		System.out.println("����login:"+user.getUsername());
		User muser=userService.login(user);
		if(muser!=null) {
			session.setAttribute("user", muser);
			return "redirect:/index.jsp";
		}else {
			model.addAttribute("message","�û����������,���˺�δ����!");
			return "login";
		}
	}
	
	@RequestMapping("/user/checkUser")
	public void check(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String username=request.getParameter("username");//jsp��ǩ��,name���Ե�ֵ
		if(userService.checkUsername(username))
			response.getWriter().print("�û���"+username+"�ѱ�ע��!");	
		else
			response.getWriter().print("��ϲ�� "+username+"����ʹ��!");	
	}
	
	@RequestMapping("/user/regist")
	public String regist(User user,String valistr,HttpSession session,Model model) {
		if(user.getUsername()==null||user.getUsername()=="") {
			model.addAttribute("msg","�û�������Ϊ��!");
			return "regist";
		}
		if(user.getPassword()==null||user.getPassword()=="") {
			model.addAttribute("msg","���벻��Ϊ��!");
			return "regist";
		}
		if(!valistr.equalsIgnoreCase(session.getAttribute("code").toString())) {
			model.addAttribute("msg","���벻��Ϊ��!");
			return "regist";
		}
		if(userService.regist(user)>0) {
			model.addAttribute("msg","ע��ɹ�!��ע��鿴���䲢�����˺�");
			SendJMail.sendMail(user.getEmail(), "ȥ��������ɼ���:  http://localhost:8080/EasyMall/user/activation?username="+user.getUsername());
			return "regist";
		}else {
			model.addAttribute("msg","ע��ʧ��");
			return "regist";
		}
	}
	
	@RequestMapping("/user/activation")
	public String activation(String username,Model model) {
		userService.activation(username);
		model.addAttribute("activation", "����ɹ�");
		return "login";
	}
}
