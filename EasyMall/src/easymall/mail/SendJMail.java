package easymall.mail;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendJMail {
	// @param to �ռ��������˺�
	// @param emailMsg �ʼ�����
	public static boolean sendMail(String to, String emailMsg) {
		try {
			String emailUser = "1185990870@qq.com";
			String emailPwd = "iwmarhgsjzdajadh";
			String emailHost = "smtp.qq.com";
			String emailAuth = "true";
			String emailProtocol = "smtp";
			int emailPort = 25;

			// ��ȡϵͳ������Ϣ
			Properties props = System.getProperties();
			// �����ʼ�������
			props.setProperty("mail.smtp.host", emailHost);
			// ����������֤
			props.setProperty("mail.smtp.auth", emailAuth);
			// ���ô���Э��
			props.setProperty("mail.transport.protocol", emailProtocol);
			// ����session����
			Session session = Session.getInstance(props);
			// ���������־
			session.setDebug(true);

			// �ʼ����Ͷ���
			MimeMessage message = new MimeMessage(session);
			// ���÷�����
			message.setFrom(new InternetAddress(emailUser));
			// �����ʼ�����
			message.setSubject("�����˺�");
			// �����ʼ�����
			message.setText(emailMsg);
			// �������ҳ����ʹ��Content����
			// message.setContent((emailMsg),"text/html;charset=utf-8");

			// ��ȡ�ʼ����͹ܵ�
			Transport transport = session.getTransport();
			// ���ӹܵ�
			transport.connect(emailHost, emailPort, emailUser, emailPwd);
			// �����ʼ�
			transport.sendMessage(message, new Address[] { new InternetAddress(to) });
			// �رչܵ�
			transport.close();
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}
}