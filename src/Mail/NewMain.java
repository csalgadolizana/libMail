package Mail;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author PC-Cristopher
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Correo c = new Correo();
//        c.setContrasenia("qbcymakunmleqiqq");
//        c.setUsername("misofertasretail@gmail.com");
//        c.setAsunto("Asunto test");
//        c.setMensaje("<h1>Test de envio de correo</h1><br>"
//                + "<img src='http://fdtool.free.fr/forms-pjc-bean/javamail/javamail.jpg'></img>"
//                + "<br>"
//                + "<h3>Adios</h3>");
//        c.setCorroDestino("misofertasretail@gmail.com");
//        c.setRutaArchivo("C:\\Users\\PC-Cristopher\\Pictures\\CU Listar Alumnos.jpg");
//        ControladorCorreo cc = new ControladorCorreo();
//        System.out.println("Envio correo " + cc.enviarCorreo(c));

// SMTP server information

        String mailTo = "misofertasretail@gmail.com";
        String subject = "Visita nuestra oferta haciendo click en la imagen";

        // message contains HTML markups
        String message = "<i>Wena Ñejoso!</i><br>";
        message += "<b>¿Como esta quedando esta wea?</b><br>";
        message += "<font color=red>shut up vieja culia</font>";
        message = "<center>"
                + "<h1>Holi!!!</h1>"
                + "<a "
                + "href='http://localhost:17225/MisOfertasWebService/ValoracionService?Tester'>"
                + "<img width='300px'"
                + "<img heigth='300px'"
                + "src='https://image.prntscr.com/image/87fd134dd8e14debadcb6e2daf473121.png'>"
                + "</a>"
                + "</img>"
                + message + "</center>";

        sendHtmlEmail mailer = new sendHtmlEmail();

        try {
            mailer.sendHtmlEmail("smtp.gmail.com", "587", "misofertasretail@gmail.com", "qbcymakunmleqiqq", mailTo,
                    subject, message);
            System.out.println("Email sent.");
            System.err.println("chinga");
        } catch (Exception ex) {
            System.out.println("Failed to sent email.");
            ex.printStackTrace();
        }
    }

}
