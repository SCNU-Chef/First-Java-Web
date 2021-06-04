package easymall.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import easymall.po.Category;
import easymall.po.Products;
import easymall.pojo.MyProducts;

public interface ProductsService {
	//������Ʒ���
	public List<Category> allcategorys();
	//������Ʒ
	public List<Products> prodlist(Map<String,Object> map);
	//����pid���ҵ�����Ʒ
	public Products oneProduct(String pid);
	//���ݷ��������Ʒ
	public List<Products> proclass(Integer category);
	//�����Ʒ
	public String save(MyProducts myProducts,HttpServletRequest request);
	
	public int delprod(String pid);
	
	public int addcate(String name);
	
	public int delcate(String name);
}
