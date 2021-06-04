package easymall.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import easymall.po.Orders;

@Repository
@Mapper
public interface OrderDao {
	//��Ӷ���
	void addOrder(Orders myOrder);
	//��ʾ����
	List<Orders> findOrderByUserId(Integer user_id);
	//ɾ������
	public void delorder(String id);
	//����֧��
	public void payorder(String id);
}
