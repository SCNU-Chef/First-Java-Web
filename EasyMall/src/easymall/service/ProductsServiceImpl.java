package easymall.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import easymall.dao.ProductsDao;
import easymall.po.Category;
import easymall.po.Products;
import easymall.pojo.MyProducts;

@Service("productsService")
public class ProductsServiceImpl implements ProductsService{
	@Autowired
	private ProductsDao productsDao;
	
	public List<Category> allcategorys() {
		return productsDao.allcategorys();
	}

	public List<Products> prodlist(Map<String, Object> map) {
		return productsDao.prodlist(map);
	}

	public Products oneProduct(String pid) {
		return productsDao.oneProduct(pid);
	}

	public List<Products> proclass(Integer proclass) {
		return productsDao.proclass(proclass);
	}

	public String save(MyProducts myProducts, HttpServletRequest request) {
		//1.判断后缀是否合法
		//获取图名称,后缀名称
		String originName=myProducts.getImgurl().getOriginalFilename();
		//截取后缀substring split (".png" ".jpg")
		String extName=originName.substring(originName.lastIndexOf("."));
		if(!(extName.equalsIgnoreCase(".jpg")||extName.equalsIgnoreCase(".png")||extName.equalsIgnoreCase(".gif"))) {
			return "图片后缀不合法!";
		}
		//判断木马(java的类判断是否是图片属性,也可以引入第三方jar包判断)
		try {
			BufferedImage bufImg=ImageIO.read(myProducts.getImgurl().getInputStream());
			bufImg.getHeight();
			bufImg.getWidth();
		} catch (Exception e) {
			return "该文件不是图片";
		}
		
		//2.创建upload开始的一个路径
		//生成多级路径
		String imgurl="";
		// /a/2/e/a/2/3/j/p
		for(int i=0;i<8;i++) {
			imgurl+="/"+Integer.toHexString(new Random().nextInt(16));
		}
		String realpath=request.getServletContext().getRealPath("/WEB-INF");
		realpath+="/upload";
		System.out.println(realpath+imgurl);
		File file=new File(realpath+imgurl,originName);
		if(!file.exists()) {
			file.mkdirs();
		}
		//上传文件
		try {
			myProducts.getImgurl().transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//拼接图片存入数据库的路径
		imgurl="/upload"+imgurl+"/"+originName;
		String id=UUID.randomUUID().toString();
		Products products=new Products();
		products.setId(id);
		products.setName(myProducts.getName());
		products.setCategory(myProducts.getCategory());
		products.setPrice(myProducts.getPrice());
		products.setPnum(myProducts.getPnum());
		products.setImgurl(imgurl);
		products.setDescription(myProducts.getDescription());
		if(productsDao.findByImgurl(products.getImgurl())==null) {
			productsDao.save(products);
		}else {
			String fname=imgurl.substring(0,imgurl.lastIndexOf("."));
			imgurl=fname+System.currentTimeMillis()+extName;
			products.setImgurl(imgurl);
			System.out.println(products.getImgurl());
			productsDao.save(products);
		}
		return "商品添加成功";
	}

	public int delprod(String pid) {
		return productsDao.delprod(pid);
	}

	public int addcate(String name) {
		return productsDao.addcate(name);
	}
	
	public int delcate(String name) {
		return productsDao.delcate(name);
	}
}
