package tn.esprit.spring.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	
	@Value("smtp.gmail.com")
	private String host;
	
	@Value("587")
	private Integer port;
	
	 @Bean
	public JavaMailSender  javaMailService(){
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		javaMailSenderImpl.setHost(host);
		javaMailSenderImpl.setPort(port);
		//user be664dc045f477 pass fa3533dbafecab
	
		javaMailSenderImpl.setJavaMailProperties(getMailProperties());
		javaMailSenderImpl.setUsername("kindergartenes@gmail.com");
		javaMailSenderImpl.setPassword("123456AB");
		javaMailSenderImpl.setProtocol("smtp");
		
		return javaMailSenderImpl;
	}

	private Properties getMailProperties() {
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "false");
		properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.setProperty("mail.debug", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");

		
		return properties;
	}

}
