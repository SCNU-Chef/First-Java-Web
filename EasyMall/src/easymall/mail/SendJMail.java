package easymall.mail;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendJMail {
	// @param to 收件人邮箱账号
	// @param emailMsg 邮件内容
	public static boolean sendMail(String to, String emailMsg) {
		try {
			String emailUser = "1185990870@qq.com";
			String emailPwd = "iwmarhgsjzdajadh";
			String emailHost = "smtp.qq.com";
			String emailAuth = "true";
			String emailProtocol = "smtp";
			int emailPort = 25;

			// 获取系统环境信息
			Properties props = System.getProperties();
			// 设置邮件服务器
			props.setProperty("mail.smtp.host", emailHost);
			// 设置密码认证
			props.setProperty("mail.smtp.auth", emailAuth);
			// 设置传输协议
			props.setProperty("mail.transport.protocol", emailProtocol);
			// 创建session对象
			Session session = Session.getInstance(props);
			// 设置输出日志
			session.setDebug(true);

			// 邮件发送对象
			MimeMessage message = new MimeMessage(session);
			// 设置发件人
			message.setFrom(new InternetAddress(emailUser));
			// 设置邮件主题
			message.setSubject("激活账号");
			// 设置邮件内容
			message.setText(emailMsg);
			// 如果带网页内容使用Content发送
			// message.setContent((emailMsg),"text/html;charset=utf-8");

			// 获取邮件发送管道
			Transport transport = session.getTransport();
			// 连接管道
			transport.connect(emailHost, emailPort, emailUser, emailPwd);
			// 发送邮件
			transport.sendMessage(message, new Address[] { new InternetAddress(to) });
			// 关闭管道
			transport.close();
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}
}