package ejbs;

import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Stateless
public class EmailBean {

    @Resource(name = "mail/dae")
    private Session mailSession;
    
    public void send(String to, String subject, String text) throws MessagingException {
        System.out.println("ENTREI!!");
        Message message = new MimeMessage(mailSession);
        System.out.println("mail session" + mailSession);

        try {
            // Adjust the recipients. Here we have only one recipient.
            // The recipient's address must be an object of the InternetAddress class.
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            System.out.println("Passou o TO");
            // Set the message's subject
            message.setSubject(subject);
            System.out.println("Tem subject");

            // Insert the message's body
            message.setText(text);

            System.out.println("Tem text");
            // Adjust the date of sending the message
            Date timeStamp = new Date();
            message.setSentDate(timeStamp);
            System.out.println("vai enviar");
            // Use the 'send' static method of the Transport class to send the message
            Transport.send(message);
            System.out.println("enviou");

        } catch (MessagingException e) {
            throw e;
        }
    }
}