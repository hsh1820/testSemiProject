package com.kh.searchfree.message.model.vo;

import java.sql.Date;

public class Message {

	private int messageNo;
	private char messageDeleteYN;
	private Date messageCreateDT;
	private int senderNo;
	private int receiverNo;
	
	public Message() {
		super();
	}
	public Message(int messageNo, char messageDeleteYN, Date messageCreateDT, int senderNo, int receiverNo) {
		super();
		this.messageNo = messageNo;
		this.messageDeleteYN = messageDeleteYN;
		this.messageCreateDT = messageCreateDT;
		this.senderNo = senderNo;
		this.receiverNo = receiverNo;
	}
	
	public int getMessageNo() {
		return messageNo;
	}
	public void setMessageNo(int messageNo) {
		this.messageNo = messageNo;
	}
	public char getMessageDeleteYN() {
		return messageDeleteYN;
	}
	public void setMessageDeleteYN(char messageDeleteYN) {
		this.messageDeleteYN = messageDeleteYN;
	}
	public Date getMessageCreateDT() {
		return messageCreateDT;
	}
	public void setMessageCreateDT(Date messageCreateDT) {
		this.messageCreateDT = messageCreateDT;
	}
	public int getSenderNo() {
		return senderNo;
	}
	public void setSenderNo(int senderNo) {
		this.senderNo = senderNo;
	}
	public int getReceiverNo() {
		return receiverNo;
	}
	public void setReceiverNo(int receiverNo) {
		this.receiverNo = receiverNo;
	}
	
	@Override
	public String toString() {
		return "Message [messageNo=" + messageNo + ", messageDeleteYN=" + messageDeleteYN + ", messageCreateDT="
				+ messageCreateDT + ", senderNo=" + senderNo + ", receiverNo=" + receiverNo + "]";
	}
	
}
