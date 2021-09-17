package com.hocken.Hockenv4.recovery.service;

import com.hocken.Hockenv4.recovery.dto.MailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService {
    @Autowired
    JavaMailSender mailSender;
    @Autowired
    TemplateEngine templateEngine;
    @Value("${mail.urlFront}")
    private String url;
    public void sendMail(MailDTO dto){
        MimeMessage message =mailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            Context context = new Context();
            HashMap<String,Object> modelo = new HashMap();
            modelo.put("nombre",dto.getNombre());
            modelo.put("url",url + dto.getToken());
            context.setVariables(modelo);
            String htmltext = templateEngine.process("email-template",context);
            helper.setFrom(dto.getMailFrom());
            helper.setTo(dto.getMailTo());
            helper.setSubject(dto.getMailSubject());
            helper.setText(htmltext, true);
            mailSender.send(message);
        }catch(MessagingException e){
            e.printStackTrace();
        }
    }

}
