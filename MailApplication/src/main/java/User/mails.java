package User;

import java.util.Date;





public class mails {
	
	private String sender;
	private Date dateRecieved;
	private String mail;
	private String Reciever;
	
	public mails(String sender, Date dateRecieved, String mail, String reciever, String status, String subject) {
		super();
		this.sender = sender;
		this.dateRecieved = dateRecieved;
		this.mail = mail;
		Reciever = reciever;
		Status = status;
		Subject = subject;
	}
	private String Status;
	private String Subject;
	
	
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public Date getDateRecieved() {
		return dateRecieved;
	}
	public void setDateRecieved(Date dateRecieved) {
		this.dateRecieved = dateRecieved;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getReciever() {
		return Reciever;
	}
	public void setReciever(String reciever) {
		Reciever = reciever;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}

	
	
	
	
}