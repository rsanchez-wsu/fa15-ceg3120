///*
// * Copyright (C) 2015
// * 
// * 
// * 
// *
// * This program is free software: you can redistribute it and/or modify
// * it under the terms of the GNU General Public License as published by
// * the Free Software Foundation, either version 3 of the License, or
// * (at your option) any later version.
// *
// * This program is distributed in the hope that it will be useful,
// * but WITHOUT ANY WARRANTY; without even the implied warranty of
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// * GNU General Public License for more details.
// *
// * You should have received a copy of the GNU General Public License
// * along with this program.  If not, see <http://www.gnu.org/licenses/>.
// *
// */
//
//package edu.wright.cs.fa15.ceg3120.concon.server;
//
//import org.apache.commons.mail.EmailAttachment;
//import org.apache.commons.mail.EmailException;
//import org.apache.commons.mail.MultiPartEmail;
//
//import java.io.File;
//import java.util.Properties;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//
//
///**
// * Handles email sent by the server to notify users of status changes and mail messages from other
// * users.
// * 
// * @author NathanJent
// *
// */
//public class MailManager {
//
//        private final String sysHostProp = "mail.smtp.host";
//        
//        @SuppressWarnings("unused")
//		private Properties props;
//        
//        private String from;
//        private String host;
//        //private String fromName;
//        /**
//         * CheckStyle is cancer	.
//         * @param CheckStyleisCancer.
//         */
//        public Properties mailManager(Properties props) {
//                this.props = props;
//                this.from = props.getProperty("server_email_addr");
//                this.host = props.getProperty("mail_server_hostname");
//                return props;
//        }
//
//        /**
//         * Sends an email message from the server. Used to notify users of status updates, internal
//         * messages, and system news items.
//         * 
//         * @param to
//         *                Address of the receiving user.
//         * @param fromName
//         *                Specify the name of the email sender.
//         */
//        public void sendEmail(String[] to, String fromName, String subject, String body,
//                        File attachmentFile) {
//
//                // Get system properties
//                Properties sysProps = System.getProperties();
//
//                // Setup mail server
//                sysProps.setProperty(sysHostProp, host);
//
//                // Get the default Session object.
//                Session session = Session.getDefaultInstance(sysProps);
//
//                try {
//
//                        if (attachmentFile.exists()) {
//                                MultiPartEmail message = new MultiPartEmail();
//                                message.setFrom(from, fromName);
//                                message.setMailSession(session);
//                                message.addTo(to);
//                                message.setSubject(subject);
//                                message.setMsg(body);
//
//                                EmailAttachment attachment = new EmailAttachment();
//                                attachment.setPath(attachmentFile.getPath());
//                                message.attach(attachment);
//                                message.send();
//                        } else {
//                                MimeMessage message = new MimeMessage(session);
//                                message.setFrom(new InternetAddress(from));
//                                for (String toAddr : to) {
//                                        message.addRecipient(Message.RecipientType.TO,
//                                                        new InternetAddress(toAddr));
//                                }
//                                message.setSubject(subject);
//                                message.setText(body);
//                                Transport.send(message);
//                        }
//                        Logger.getLogger(this.getClass().getName())
//                                        .info("Sent message successfully....");
//                } catch (MessagingException | EmailException mex) {
//                        Logger.getLogger(this.getClass().getName()).log(Level.WARNING,
//                                        "Email was not sent. ", mex);
//                }
//        }
//        /**
//         * CheckStyle is cancer	.
//         * @param CheckStyleisCancer.
//         */
//        public void receiveEmail() {
//                // Get system properties
//                Properties sysProps = System.getProperties();
//
//                // Setup mail server
//                sysProps.setProperty(sysHostProp, host);
//
//                // Get the default Session object.
//                @SuppressWarnings("unused")
//				Session session = Session.getDefaultInstance(sysProps);
//
//        }
//}
