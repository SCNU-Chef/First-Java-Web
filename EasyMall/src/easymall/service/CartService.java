package easymall.service;

import java.util.List;
import easymall.po.Cart;
import easymall.pojo.MyCart;

public interface CartService {
	//如果指定用户的购物车没有该商品,则添加该商品到购物车中
	public int addCart(Cart cart);
	//查找指定用户的购物车是否存在该商品
	public Cart findCart(Cart cart);
	//如果指定用户的购物车有该商品,则修改购物车中该商品的数量
	public int updateCart(Cart cart);
	//显示购物车
	public List<MyCart> showcart(int user_id);
	//修改购物车商品数量
	public void updateBuyNum(Cart cart);
	//删除购物车中的商品
	public void delCart(Integer cartID);
	//根据cartID查找购物车
	public MyCart findByCartID(Integer cartID);
}
