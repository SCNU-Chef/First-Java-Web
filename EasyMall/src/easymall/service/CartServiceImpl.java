package easymall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import easymall.dao.CartDao;
import easymall.po.Cart;
import easymall.pojo.MyCart;

@Service("cartService")
public class CartServiceImpl implements CartService{
	@Autowired
	private CartDao cartDao;
	
	public int addCart(Cart cart) {
		return cartDao.addCart(cart);
	}

	public Cart findCart(Cart cart) {
		return cartDao.findCart(cart);
	}

	public int updateCart(Cart cart) {
		return cartDao.updateCart(cart);
	}

	public List<MyCart> showcart(int user_id) {
		return cartDao.showcart(user_id);
	}

	public void updateBuyNum(Cart cart) {
		cartDao.updateBuyNum(cart);
	}

	public void delCart(Integer cartID) {
		cartDao.delCart(cartID);
	}

	public MyCart findByCartID(Integer cartID) {
		return cartDao.findByCartID(cartID);
	}
}
