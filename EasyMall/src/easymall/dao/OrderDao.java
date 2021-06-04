package easymall.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import easymall.po.Orders;

@Repository
@Mapper
public interface OrderDao {
	//添加订单
	void addOrder(Orders myOrder);
	//显示订单
	List<Orders> findOrderByUserId(Integer user_id);
	//删除订单
	public void delorder(String id);
	//订单支付
	public void payorder(String id);
}
