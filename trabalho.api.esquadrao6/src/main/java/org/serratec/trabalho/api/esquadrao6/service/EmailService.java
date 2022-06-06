package org.serratec.trabalho.api.esquadrao6.service;

import org.serratec.trabalho.api.esquadrao6.dto.MovimentacaoItemDTO;
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
import java.time.LocalDate;
import java.util.Properties;

@Component
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;

	// Variáveis puxadas do application.properties
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

	// NÁO MODIFICAR ESSES MÉTODOS
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
		prop.put("mail.imap.auth.mechanisms", "XOAUTH2");
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

	// Modelo de método
	public void emailTeste() throws MessagingException, EmailException {
		this.emailSender = javaMailSender();
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		try {
			helper.setFrom(userName);
			helper.setTo(emailDestinatario);
			helper.setSubject("Email teste");

			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("<html>\r\n" + "<body>\r\n" + "<div>\r\n" + "Email teste" + "<br></br>" + "</div>\r\n"
					+ "</body>\r\n" + "</html>\r\n");

			helper.setText(stringBuilder.toString(), true);
			emailSender.send(message);

		} catch (Exception exception) {
			throw new EmailException("Houve erro ao enviar o email: " + exception.getMessage());
		}
	}

	public void emailVendaConcluida(MovimentacaoItemDTO movDTO) throws MessagingException, EmailException {
		this.emailSender = javaMailSender();
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		LocalDate prevEntrega = movDTO.getMovimentacaoData().plusDays(14);
		Double valorTotal = movDTO.getMovimentacaoQuantidade() * movDTO.getMovimentacaoValorUnitario();
		try {
			helper.setFrom(userName);
			helper.setTo(emailDestinatario);
			helper.setSubject("Parabéns pela sua compra na Loja do APIcultor!");

			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("<html>\n" + "\n" + "<body>\n" + "    <h3 id='-olá-nomedocliente-'>\uD83D\uDC1D Olá, "
					+ movDTO.getClienteNome() + "\uD83D\uDC1D</h3>\n" + "    <p>&nbsp;</p>\n"
					+ "    <p>Obrigado por comprar conosco!!</p>\n" + "    <p> Previsão de entrega: <strong>"
					+ prevEntrega + "</strong></p>\n"
					+ "    <h4 id='seu-pedido-está-em-rota-de-entrega'>Seu pedido está em rota de entrega</h4>\n"
					+ "    <p>&nbsp;</p>\n" + "    <h5 id='resumo-do-pedido'>Resumo do pedido</h5>\n" + "    <ul>\n"
					+ "        <li>Número do Pedido: <strong>" + movDTO.getMovimentacaoNumeroDocumento()
					+ "</strong></li>\n" + "        <li>Data da Compra: <strong>" + movDTO.getMovimentacaoData()
					+ "</strong></li>\n" + "\n" + "    </ul>\n" + "    <h5 id='itens-do-pedido'>Itens do pedido</h5>\n"
					+ "    <figure>\n" + "        <table>\n" + "            <thead>\n" + "                <tr>\n"
					+ "                    <th>Produto</th>\n" + "                    <th>Quantidade</th>\n"
					+ "                    <th>Valor Unitário</th>\n" + "                    <th>Valor Total</th>\n"
					+ "                </tr>\n" + "            </thead>\n" + "            <tbody>\n"
					+ "                <tr>\n" + "                    <td>" + movDTO.getProdutoNome() + "</td>\n"
					+ "                    <td>" + movDTO.getMovimentacaoQuantidade() + "</td>\n"
					+ "                    <td>" + movDTO.getMovimentacaoValorUnitario() + "</td>\n"
					+ "                    <td>" + valorTotal + "</td>\n" + "                </tr>\n"
					+ "            </tbody>\n" + "        </table>\n" + "    </figure>\n" + "    <p>&nbsp;</p>\n"
					+ "    <h6 id='dúvidas'>Dúvidas?</h6>\n" + "    <p>Não entre em contato conosco!!!</p>\n"
					+ "    <p>&nbsp;</p>\n" + "    <p>©️ Squad Team 6</p>\n" + "    <p>&nbsp;</p>\n" + "</body>\n"
					+ "\n" + "</html>");

			helper.setText(stringBuilder.toString(), true);
			emailSender.send(message);

		} catch (Exception exception) {
			throw new EmailException("Houve erro ao enviar o email: " + exception.getMessage());
		}
	}

	public void emailFaltaEstoque(MovimentacaoItemDTO movDTO) throws MessagingException, EmailException {
		this.emailSender = javaMailSender();
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		LocalDate prevEntrega = movDTO.getMovimentacaoData().plusDays(14);
		Double valorTotal = movDTO.getMovimentacaoQuantidade() * movDTO.getMovimentacaoValorUnitario();
		try {
			helper.setFrom(userName);
			helper.setTo(emailDestinatario);
			helper.setSubject("Notificação de falta de Estoque!!!");

			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("<html>\n" + "<head>\n"
					+ "<meta charset='UTF-8'><meta name='viewport' content='width=device-width initial-scale=1'>\n"
					+ "<title></title>\n" + "</head>\n"
					+ "<body><h1 id='-notificação-de-falta-de-estoque-'>\uD83D\uDC1D Notificação de falta de estoque \uD83D\uDC1D</h1>\n"
					+ "<h2 id='atenção'>Atenção!!!</h2>\n" + "<p>O produto <strong> " + movDTO.getProdutoNome()
					+ "</strong> está com estoque menor ou igual a 5!!!</p>\n" + "<p>&nbsp;</p>\n" + "</body>\n"
					+ "</html>");

			helper.setText(stringBuilder.toString(), true);
			emailSender.send(message);

		} catch (Exception exception) {
			throw new EmailException("Houve erro ao enviar o email: " + exception.getMessage());
		}
	}

}
