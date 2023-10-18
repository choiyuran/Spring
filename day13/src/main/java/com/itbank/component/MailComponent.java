package com.itbank.component;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.itbank.model.Ex01DTO;
import com.itbank.model.Ex02DTO;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Component
public class MailComponent {
	
	private final String host = "smtp.naver.com";
	private final int port = 465;
	private String serverId = "dywjd3355v";		// 메일 계정 아이디
	private String serverPw = "alskdj14680";		// 메일 계정 비밀번호
	
	private Properties props;
	
	// classpath 에서 특정 파일 불러오기
	// src/main/java
	// src/main/resources
	@Value("classpath:mailForm.html")
	private Resource mailForm;
	
	private String tag="";
	
	public MailComponent() {		
		props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", host);
	}
	
	public int sendSimpleMail(Ex01DTO dto) {
		Session mailSession = Session.getDefaultInstance(props, new Authenticator() {
			String un = serverId;
			String pw = serverPw;
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(un, pw);
			}
		});

		mailSession.setDebug(true);			// 메일 발송 시 진행 상황을 콘솔창에 출력하도록 설정한다
		
		Message message = new MimeMessage(mailSession);
		try {
//			InternetAddress[] arr = {
//				new InternetAddress("1@2.com"),
//				new InternetAddress("1@3.com"),	
//				new InternetAddress("1@4.com")	
//			};
			message.setFrom(new InternetAddress(serverId + "@naver.com"));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(dto.getReceiver()));
//			message.setRecipients(Message.RecipientType.TO, arr);			// 단체 메일
			
			message.setSubject("테스트 메일 제목입니다");
			message.setText(dto.getBody());			// 단순 텍스트를 보낼 때는 setText()
			Transport.send(message);
			return 1;
			
		} catch (MessagingException e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	public int sendMimeMessage(Ex02DTO dto) {
		Session mailSession = Session.getDefaultInstance(props, new Authenticator() {
			String un = serverId;
			String pw = serverPw;
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(un, pw);
			}
		});
		mailSession.setDebug(true);			// 메일 발송 시 진행 상황을 콘솔창에 출력하도록 설정한다
		
		Message message = new MimeMessage(mailSession);
	
		try {
			// 파일 내용 불러와서 태그에 넣어두기
			Scanner sc = new Scanner(mailForm.getFile());
			while(sc.hasNextLine()) {
				tag += sc.nextLine();
			}
			sc.close();
			
			message.setFrom(new InternetAddress(serverId + "@naver.com"));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(dto.getReceiver()));
			message.setSubject(dto.getSubject());
			message.setContent(
					String.format(tag, dto.getContent()),
					"text/html;charset=utf-8");
			Transport.send(message);
			return 1;
			
		} catch (MessagingException | IOException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
