/*
 * Copyright (C) 2015
 * 
 * 
 * 
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package edu.wright.cs.fa15.ceg3120.concon.server;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;

import javax.mail.Session;

/**
 * Handles email sent by the server to notify users of status changes and mail
 * messages from other users.
 * 
 * @author NathanJent
 *
 */
public class EmailManager {
	
    private static final Logger LOG = LoggerFactory.getLogger(EmailManager.class);
	private Queue<Email> mailQueue = new LinkedList<>();
	private Properties props;

	/**
	 * Javadoc needed.
	 *
	 */
	public EmailManager(Properties props) {
		this.props = props;
	}

	/**
	 * Add an outgoing email to the queue.
	 * @param to Array of email addresses.
	 * @param subject Header
	 * @param body Content
	 * @param attachmentFile Attachment
	 */
	public void addEmail(String[] to, String subject, String body, File attachmentFile) {
		HtmlEmail mail = new HtmlEmail();
		Properties sysProps = System.getProperties();

		// Setup mail server
		sysProps.setProperty("mail.smtp.host", props.getProperty("mail_server_hostname"));
		Session session = Session.getDefaultInstance(sysProps);

		try {
			mail.setMailSession(session);
			mail.setFrom(props.getProperty("server_email_addr"), 
							props.getProperty("server_title"));
			mail.addTo(to);
			mail.setSubject(subject);
			mail.setTextMsg(body);
			mail.setHtmlMsg(composeAsHtml(mail, body));
			if (attachmentFile.exists()) {
				EmailAttachment attachment = new EmailAttachment();
				attachment.setPath(attachmentFile.getPath());
				mail.attach(attachment);
			}
		} catch (EmailException e) {
			LOG.warn("Email was not added. ", e);
		}
		mailQueue.add(mail);
	}
	
	/**
	 * Composes the message using the body inside of an HTML template with a logo image.
	 * @param mail The outgoing email to compose.
	 * @param body The body text to add.
	 * @return The HTML output.
	 * @throws EmailException Exception from embedding image into message.
	 */
	private String composeAsHtml(HtmlEmail mail, String body) throws EmailException {
		StringBuffer msg = new StringBuffer();
		File logoImage = new File(props.getProperty("logo_image_location"));
		msg.append("<html><body>");
		msg.append("<img src=cid:").append(mail.embed(logoImage)).append(">");
		msg.append("<br>");
		msg.append(body);
		msg.append("</body></html>");
		return msg.toString();
	}

	/**
	 * Sends an email message from the server. Used to notify users of status
	 * updates, internal messages, and system news items.
	 */
	public void sendEmail() {

		try {
			while (!mailQueue.isEmpty()) {
				mailQueue.remove().send();
				LOG.info("Sent message successfully....");
			}
		} catch (EmailException e) {
			LOG.warn("Email was not sent. ", e);
		}
	}
}
