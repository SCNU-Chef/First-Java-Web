package easymall.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import easymall.po.Category;
import easymall.po.Products;
import easymall.pojo.MyProducts;
import easymall.service.ProductsService;

@Controller
@RequestMapping("/admin")
public class ProductsControllerAdmin {
	@Autowired
	private ProductsService productsService;
	@RequestMapping("addprod")
	public String addprod(Model model) {
		//������Ʒ�������е���Ʒ���
		List<Category> categorys=productsService.allcategorys();
		model.addAttribute("categorys",categorys);
		model.addAttribute("myproducts",new MyProducts());
		return "admin/add_prod";
	}
	@RequestMapping("/save")
	public String save(@Valid @ModelAttribute MyProducts myproducts,HttpServletRequest request,Model model) {
		String msg=productsService.save(myproducts, request);
		model.addAttribute("msg",msg);
		return "redirect:/admin/addprod";
	}
	@RequestMapping("/delprod")
	public String delprod(String name,Integer category,String minprice,String maxprice,Model model,String pid) {
		
		productsService.delprod(pid);
		
		List<Category> categorys = productsService.allcategorys();
		model.addAttribute("categorys", categorys);
				
		//Ϊ������������Ĭ��ֵ������������Ƿ�Ϸ�
		double _minPrice = 0;//Ĭ�ϴ�0�����ֵ
		Double _maxPrice = Double.MAX_VALUE;
				
		String reg = "^\\d+$";  //ֻ����������
		if(minprice != null && !"".equals(minprice.trim())&& minprice.matches(reg)) {
			_minPrice = Double.parseDouble(minprice);
		}
		if(maxprice != null && !"".equals(maxprice.trim())&& maxprice.matches(reg)) {
			//��߼۸�������ڵ�����ͼ۸�
			if(Double.parseDouble(maxprice) >= _minPrice) {
				_maxPrice = Double.parseDouble(maxprice);
			}
		}

		//����map�����ڴ�Ų�ѯ����
		Map<String,Object> map = new HashMap<>();
		map.put("name", name);
		map.put("category", category);
		map.put("minPrice", _minPrice);
		map.put("maxPrice", _maxPrice);
		//����������ѯ������������Ʒ��Ϣ
		List<Products> products = productsService.prodlist(map);
		//�����ѯ����
		model.addAttribute("name",name);
		model.addAttribute("minPrice",_minPrice);
		model.addAttribute("maxPrice",_maxPrice);
		//��ѯ�����¶��ǰ��
		model.addAttribute("products",products);
		
		return "admin/del_prod";
	}
	@RequestMapping("addcate")
	public String addcate(String n) {
		if(n!=null) {
			productsService.addcate(n);
		}
		return "admin/add_category";
	}
	@RequestMapping("delcate")
	public String delcate(String n) {
		
		if(n!=null) {
			productsService.delcate(n);
		}
		return "admin/del_category";
	}
}
