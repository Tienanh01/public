package com.java.EverydayProject.Services;

import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
@Service
public class SendMail {

    public String send_SimpleMail(){


        // Địa chỉ email của người gửi
        String fromEmail = "hackme2k@gmail.com";
        // Mật khẩu ứng dụng
        String password = "wbyhevbfjuxtitjv";
        // Địa chỉ email của người nhận
        String toEmail = "vuanhact@gmail.com";
        // Tiêu đề email
        String subject = "Mail gửi nhận văn bản";
        // Nội dung email
        String body = "This is a test email sent using JavaMail API.";
        // Cấu hình thông tin SMTP server
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        // Tạo đối tượng Authenticator để xác thực tài khoản người gửi
        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        // Tạo đối tượng Session để kết nối đến SMTP server
        Session session = Session.getInstance(props, auth);
        try {
            // Tạo đối tượng MimeMessage để tạo email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
//            message.setText(body);
            String htmlContent = "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\">\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "\n" +
                    "  <div class=\"container mt-5\">\n" +
                    "    <div class=\"title\">\n" +
                    "        <p>Kính gửi anh chị :</p>\n" +
                    "    </div>\n" +
                    "    <div class=\"content\">\n" +
                    "        <p>Từ ngày [02/04/2023] đến ngày [hiện tai] trung tâm [Trung tâm liên thông Tỉnh Tây Ninh] có tổng [1] văn bản chưa nhận về : Yêu cầu đơn vị nhận văn bản.</p>\n" +
                    "    </div>\n" +
                    "    <div class=\"header\">\n" +
                    "        <p>Danh sách văn bản chưa nhận về từ trục:</p>\n" +
                    "    </div>\n" +
                    "    <div class=\"table-content\">\n" +
                    "        <table class=\"table table-bordered\">\n" +
                    "            <thead>\n" +
                    "              <tr>\n" +
                    "                <th>Firstname</th>\n" +
                    "                <th>Lastname</th>\n" +
                    "                <th>Email</th>\n" +
                    "              </tr>\n" +
                    "            </thead>\n" +
                    "            <tbody>\n" +
                    "              <tr>\n" +
                    "                <td>John</td>\n" +
                    "                <td>Doe</td>\n" +
                    "                <td>john@example.com</td>\n" +
                    "              </tr>\n" +
                    "              <tr>\n" +
                    "                <td>Mary</td>\n" +
                    "                <td>Moe</td>\n" +
                    "                <td>mary@example.com</td>\n" +
                    "              </tr>\n" +
                    "              <tr>\n" +
                    "                <td>July</td>\n" +
                    "                <td>Dooley</td>\n" +
                    "                <td>july@example.com</td>\n" +
                    "              </tr>\n" +
                    "            </tbody>\n" +
                    "          </table>\n" +
                    "    </div>\n" +
                    "  </div>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>";
            message.setContent(htmlContent, "text/html; charset=UTF-8");
            // Gửi email
            Transport.send(message);

            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            System.out.println("Error sending email: " + e.getMessage());
        }
        return "false";
    }

}
