package easymall.service;

import java.util.List;
import easymall.po.Cart;
import easymall.pojo.MyCart;

public interface CartService {
	//���ָ���û��Ĺ��ﳵû�и���Ʒ,����Ӹ���Ʒ�����ﳵ��
	public int addCart(Cart cart);
	//����ָ���û��Ĺ��ﳵ�Ƿ���ڸ���Ʒ
	public Cart findCart(Cart cart);
	//���ָ���û��Ĺ��ﳵ�и���Ʒ,���޸Ĺ��ﳵ�и���Ʒ������
	public int updateCart(Cart cart);
	//��ʾ���ﳵ
	public List<MyCart> showcart(int user_id);
	//�޸Ĺ��ﳵ��Ʒ����
	public void updateBuyNum(Cart cart);
	//ɾ�����ﳵ�е���Ʒ
	public void delCart(Integer cartID);
	//����cartID���ҹ��ﳵ
	public MyCart findByCartID(Integer cartID);
}
