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

package edu.wright.cs.fa15.ceg3120.concon.common.net.data;

import edu.wright.cs.fa15.ceg3120.concon.common.net.ConConClient;
import edu.wright.cs.fa15.ceg3120.concon.common.net.MessageHolder;
import edu.wright.cs.fa15.ceg3120.concon.common.net.NetworkHandler;
import edu.wright.cs.fa15.ceg3120.concon.common.net.NetworkManager;

import java.io.Serializable;

/**
 * Holds data needed to send a chat message to another user.
 * @author NathanJent
 *
 */
public class ChatData implements Serializable {

	private static final long serialVersionUID = -5939310825171066784L;
	private String text;
	private String from;
	private String to;

	/**
	 * Default Constructor required for Java bean.
	 */
	public ChatData() { }

	/**
	 * Holds data needed to send a chat message to another user.
	 */
	public ChatData(String messageText, String from, String to) {
		this.text = messageText;
		this.from = from;
		this.to = to;
	}
	
	/**
	 * Constructor used when receiving the chat log.
	 * @param chatLog the chat log\\
	 */
	public ChatData(String chatLog) {
		this.text = chatLog;
	}

	/**
	 * Posts a chat message to the server.
	 * @return The message
	 */
	@NetworkHandler(channel = "chatPost")
	public static MessageHolder postChatMessage(ChatData message) {
		// TODO log chat messages to database
		return new MessageHolder("chatPostConfirmation", message);
	}
	
	/**
	 * Receives a chat message, and updates the user's chat panel.
	 * @return The message
	 */
	@NetworkHandler(channel = "chatPostConfirmation")
	public static MessageHolder receiveChatMessage(ChatData message) {
		ConConClient client = NetworkManager.getClient();
		String text = message.to  + ": " + message.text + "\n";
		client.appendToChatLog(text);
		return new MessageHolder("end", null);
	}
	
	/**
	 * Fetches messages from the chat log for the user.
	 * @return The message
	 */
	@NetworkHandler(channel = "fetchMessages")
	public static MessageHolder fetchChatMessages(ChatData message) {
		// TODO fetch messages from database
		String chatLog = "this is the chatlog";
		ChatData chatLogReply = new ChatData(chatLog);
		return new MessageHolder("receiveMessages", chatLogReply);
	}
	
	/**
	 * Receive messages from the chat log for the user.
	 * @return The message
	 */
	@NetworkHandler(channel = "receiveMessages")
	public static MessageHolder recieveChatMessages(ChatData message) {
		ConConClient client = NetworkManager.getClient();
		client.appendToChatLog(message.text);
		return new MessageHolder("end", null);
	}
	
	/**
	 * Get text.
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Set text.
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Get from.
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * Set from.
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * Get to.
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * Set to.
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChatMessage [text=" + text + ", from=" + from + ", to=" + to + "]";
	}

}
