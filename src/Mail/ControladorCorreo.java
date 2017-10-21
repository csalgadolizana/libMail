package Mail;


import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Cristopher Salgado csalgadolizana@gmail.com
 * @version 21-10-2017
 */
public class ControladorCorreo {

    /**
     *
     * @return boolean
     * @since 221-10-2017
     * @param Correo correo
     * @see Correo
     */
    public boolean enviarCorreo(Correo correo) {
        try {
            Properties p = new Properties();
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.setProperty("mail.smtp.starttls.port", "587");
            p.setProperty("mail.smtp.starttls.user", correo.getUsername());
            p.setProperty("mail.smtp.starttls.auth", "true");
            
            
            Session s = Session.getDefaultInstance(p, null);
            
            
            BodyPart texto = new MimeBodyPart();
//            texto.setContent(correo.getMensaje(),"text/html");
            texto.setText(correo.getMensaje());
            BodyPart adjunto = new MimeBodyPart();
            if (!correo.getRutaArchivo().trim().equals("")) {
                adjunto.setDataHandler(new DataHandler(new FileDataSource(correo.getRutaArchivo())));
                adjunto.setFileName(correo.getRutaArchivo().trim());
            }
            MimeMultipart m = new MimeMultipart();
            m.addBodyPart(texto);
            if (!correo.getRutaArchivo().trim().equals("")) {
                m.addBodyPart(adjunto);
            }
            MimeMessage mensaje = new MimeMessage(s);
            mensaje.setFrom(new InternetAddress(correo.getUsername()));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correo.getCorroDestino()));
            mensaje.setContent("<h1>Hola mundo</h1>", "text-html; charset=utf-8");
            mensaje.setSubject(correo.getAsunto());

            Transport t = s.getTransport("smtp");
            t.connect(correo.getUsername(), correo.getContrasenia());
            t.sendMessage(mensaje, mensaje.getAllRecipients());
//            mensaje.setContent(correo.getMensaje(), "text/html; charset=utf-8");
            mensaje.saveChanges();
            return true;
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return false;
    }
}
