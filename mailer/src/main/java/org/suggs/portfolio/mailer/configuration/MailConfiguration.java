package org.suggs.portfolio.mailer.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@PropertySource("classpath:mail.properties")
public class MailConfiguration {
    @Value("${mail.protocol}")
    private String protocol;
    @Value("${mail.host}")
    private String host;
    @Value("${mail.port}")
    private int port;
    @Value("${mail.smtp.auth}")
    private boolean auth;
    @Value("${mail.smtp.starttls.enable}")
    private boolean starttls;
    @Value("${mail.from}")
    private String from;
    @Value("${mail.username}")
    private String username;
    @Value("${mail.password}")
    private String password;

    @Bean
    public JavaMailSender mailSender(){
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setJavaMailProperties(buildJavaMailProperties());
        sender.setHost(host);
        sender.setPort(port);
        sender.setProtocol(protocol);
        sender.setUsername(username);
        sender.setPassword(password);
        return sender;
    }

    private Properties buildJavaMailProperties(){
        Properties properties  = new Properties();
        properties.put("mail.smtp.auth", auth);
        properties.put("mail.smtp.starttls.enable", starttls);
        return properties;
    }
}
