package easymall.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import easymall.dao.CartDao;
import easymall.dao.OrderDao;
import easymall.dao.OrderItemDao;
import easymall.po.OrderItem;
import easymall.po.Orders;
import easymall.pojo.MyCart;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private CartDao cartDao;
	@Autowired
	private OrderItemDao orderItemDao;
	@Autowired
	private OrderDao orderDao;
	
	public void addOrder(String cartIds, Orders myOrder) {
		String[] arrCartIds=cartIds.split(",");
		Double sum=0.0;
		for(String cartID:arrCartIds) {
			Integer cid=Integer.parseInt(cartID);
			MyCart mycart=cartDao.findByCartID(cid);
			String pid=mycart.getPid();
			int buynum=mycart.getNum();
			Double price=mycart.getPrice();
			sum=sum+buynum*price;
			OrderItem orderItem=new OrderItem();
			orderItem.setOrder_id(myOrder.getId());
			orderItem.setProduct_id(pid);
			orderItem.setBuynum(buynum);
			orderItemDao.addOrderItem(orderItem);
			cartDao.delCart(cid);
		}
		myOrder.setMoney(sum);
		orderDao.addOrder(myOrder);
	}

	public List<Orders> findOrderByUserId(Integer user_id) {
		return orderDao.findOrderByUserId(user_id);
	}

	public List<OrderItem> orderitem(String order_id) {
		return orderItemDao.orderitem(order_id);
	}

	public void delorder(String id) {
		orderDao.delorder(id);
		orderItemDao.delorderitem(id);
	}

	public void payorder(String id) {
		orderDao.payorder(id);
	}
}
