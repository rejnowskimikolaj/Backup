package com.sda.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CascadeType;


@Entity
@Table(name = "message", uniqueConstraints = { @UniqueConstraint(columnNames = "id") })
public class Message {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name = "content")
	private String content;

	@Column(name = "timestamp")
	private String timestamp;

	@Column(name = "status")
	private int status;

	@Column(name = "sender_id")
	private int sender_id;

	@Column(name = "recipient_id")
	private int recipient_id;

	public Message() {
	}

	public Message(String content, int sender_id, int recipient_id) {
		this.content = content;
		this.timestamp = String.valueOf(System.currentTimeMillis());
		this.status = 0;
		this.sender_id = sender_id;
		this.recipient_id = recipient_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getSender_id() {
		return sender_id;
	}

	public void setSender_id(int sender_id) {
		this.sender_id = sender_id;
	}

	public int getRecipient_id() {
		return recipient_id;
	}

	public void setRecipient_id(int recipient_id) {
		this.recipient_id = recipient_id;
	}

}