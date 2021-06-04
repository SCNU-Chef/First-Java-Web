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
		//1.�жϺ�׺�Ƿ�Ϸ�
		//��ȡͼ����,��׺����
		String originName=myProducts.getImgurl().getOriginalFilename();
		//��ȡ��׺substring split (".png" ".jpg")
		String extName=originName.substring(originName.lastIndexOf("."));
		if(!(extName.equalsIgnoreCase(".jpg")||extName.equalsIgnoreCase(".png")||extName.equalsIgnoreCase(".gif"))) {
			return "ͼƬ��׺���Ϸ�!";
		}
		//�ж�ľ��(java�����ж��Ƿ���ͼƬ����,Ҳ�������������jar���ж�)
		try {
			BufferedImage bufImg=ImageIO.read(myProducts.getImgurl().getInputStream());
			bufImg.getHeight();
			bufImg.getWidth();
		} catch (Exception e) {
			return "���ļ�����ͼƬ";
		}
		
		//2.����upload��ʼ��һ��·��
		//���ɶ༶·��
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
		//�ϴ��ļ�
		try {
			myProducts.getImgurl().transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//ƴ��ͼƬ�������ݿ��·��
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
		return "��Ʒ��ӳɹ�";
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
