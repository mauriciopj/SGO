/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.aplicacao;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


/**
 *
 * @author mauricio
 */
public class Email {
    private String destinatario;
    private Usuario usuario;

    public Email() {
        
    }

    public Email(String destinatario, Usuario usuario) {
        this.destinatario = destinatario;
        this.usuario = usuario;
    }
            
    public void sendEmail() throws EmailException {
        SimpleEmail email = new SimpleEmail();
        //Utilize o hostname do seu provedor de email
        System.out.println("alterando hostname...");
        email.setHostName("smtp.live.com");
        //Quando a porta utilizada não é a padrão (gmail = 465)
        email.setSmtpPort(465);
        //Adicione os destinatários
        email.addTo("xxx@xxx.com", "Jose");
        //Configure o seu email do qual enviará
        email.setFrom("seuemail@seuprovedor.com", "Seu nome");
        //Adicione um assunto
        email.setSubject("Test message");
        //Adicione a mensagem do email
        email.setMsg("This is a simple test of commons-email");
        //Para autenticar no servidor é necessário chamar os dois métodos abaixo
        System.out.println("autenticando...");
        email.setSSL(true);
        email.setAuthentication("username", "senha");
        System.out.println("enviando...");
        email.send();
        System.out.println("Email enviado!");
    }
}