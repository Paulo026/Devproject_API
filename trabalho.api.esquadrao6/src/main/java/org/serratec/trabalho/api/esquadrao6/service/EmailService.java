package org.serratec.trabalho.api.esquadrao6.service;

import org.serratec.trabalho.api.esquadrao6.exception.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    //Variáveis puxadas do application.properties
    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.port}")
    private int port;
    @Value("${spring.mail.username}")
    private String userName;
    @Value("${spring.mail.password}")
    private String senha;
    @Value("${spring.mail.protocol}")
    private String protocol;
    @Value("${spring.mail.default-encoding}")
    private String defaultEncoding;
    @Value("${spring.mail.destinatario}")
    private String emailDestinatario;

    //NÁO MODIFICAR ESSES MÉTODOS
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl enviarEmail = new JavaMailSenderImpl();
        Properties prop = new Properties();

        enviarEmail.setHost(host);
        enviarEmail.setPort(port);
        enviarEmail.setUsername(userName);
        enviarEmail.setPassword(senha);
        enviarEmail.setProtocol("smtp");
        enviarEmail.setDefaultEncoding("UTF-8");
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.ssl.enable", true);
        enviarEmail.setJavaMailProperties(prop);

        return enviarEmail;
    }

    public void sendMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(userName);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    //Modelo de método
    public void emailTeste() throws MessagingException, EmailException {
        this.emailSender = javaMailSender();
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        try {
            helper.setFrom(userName);
            helper.setTo(emailDestinatario);
            helper.setSubject("Email teste");

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(
                    "<html>\r\n"
                            + "<body>\r\n"
                            + "<div>\r\n"
                            + "Email teste"
                            + "<br></br>"
                            + "</div>\r\n"
                            + "</body>\r\n"
                            + "</html>\r\n"
            );

            helper.setText(stringBuilder.toString(), true);
            emailSender.send(message);

        } catch (Exception exception) {
            throw new EmailException("Houve erro ao enviar o email: " + exception.getMessage());
        }
    }

    //Envio de e-mails
    public void emailVendaConcluida(Integer numeroPedido, String nomeProduto, Integer qtProduto, Double valorUnitário, Double valorTotal) throws MessagingException, EmailException {
        this.emailSender = javaMailSender();
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        try {
            helper.setFrom(userName);
            helper.setTo(emailDestinatario);
            helper.setSubject("Parabéns pela sua compra na Loja do APIcultor!");

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(
                    "<html>\r\n"
                            + "<body>\r\n"
                            + "<h2> Parabéns por sua compra na Loja do APIcultor!!!</h2>\r\n"
                            + "<h6>Segue um resumo de sua compra " + numeroPedido + ": </h6>\r\n"
                            + "<div>\r\n"
                            + "<p>&nbsp&nbsp&nbsp Produto: " + nomeProduto + "</p>\r\n"
                            + "<p>&nbsp&nbsp&nbsp Quantidade: " + qtProduto + "</p>\r\n"
                            + "<p>&nbsp&nbsp&nbsp Valor Unitário: " + valorUnitário + "</p>\r\n"
                            + "<p>&nbsp&nbsp&nbsp Valor Total: " + valorTotal + "</p>\r\n"
                            + "</div>"
                            + "</body>\r\n"
                            + "</html>\r\n"
            );

            helper.setText(stringBuilder.toString(), true);
            emailSender.send(message);

        } catch (Exception exception) {
            throw new EmailException("Houve erro ao enviar o email: " + exception.getMessage());
        }
    }


}
