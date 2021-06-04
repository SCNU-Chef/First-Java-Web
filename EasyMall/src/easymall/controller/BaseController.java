package easymall.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import easymall.exception.UserLoginNoException;

@Controller
public class BaseController {
	//加了这个注解后,控制器每次被调用方法前,都会执行被注解的方法
	@ModelAttribute
	public void isLogin(HttpSession session,HttpServletRequest request) throws UserLoginNoException{
		if(session.getAttribute("user")==null) {
			throw new UserLoginNoException("没有登陆,请先登陆");
		}
	}
}
