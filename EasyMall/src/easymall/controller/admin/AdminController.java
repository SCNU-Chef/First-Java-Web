package easymall.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import easymall.POI.CreateExcel;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@RequestMapping("/manage")
	public String toManage() {
		return "admin/manage";
	}
	@RequestMapping("/login")
	public String toLogin() {
		return "admin/manage";
	}
	@RequestMapping("/man")
	public String toMan() {
		return "admin/man";
	}
	@RequestMapping("/print")
	public String toPrint(Model model) {
		model.addAttribute("print","打印报表成功!");
		CreateExcel ce=new CreateExcel();
		ce.print();
		return "admin/man";
	}
	
}
