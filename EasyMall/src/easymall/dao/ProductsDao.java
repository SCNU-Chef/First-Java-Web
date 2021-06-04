package easymall.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import easymall.po.Category;
import easymall.po.Products;

@Repository
@Mapper
public interface ProductsDao {
	//查找商品类别
	public List<Category> allcategorys();
	//查找商品
	public List<Products> prodlist(Map<String,Object> map);
	//根据pid查找单个商品
	public Products oneProduct(String pid);
	//根据分类查找商品
	public List<Products> proclass(Integer category);
	//存入一件新的商品
	public void save(Products products);
	//根据图片url查找
	public Object findByImgurl(String imgurl);
	
	public int delprod(String pid);
	
	public int addcate(String name);
	
	public int delcate(String name);
}
