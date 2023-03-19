package User;

import java.util.ArrayList;



public class user {

	private String mailId;
	private String userName;

	private String password;

	private ArrayList<mails> inbox = new ArrayList<>();

	private ArrayList<mails> sent = new ArrayList<>();
	
	

	public user(String mailId, String userName, String password, ArrayList<mails> inbox, ArrayList<mails> trash) {
		super();
		this.mailId = mailId;
		this.userName = userName;
		this.password = password;
		this.inbox = inbox;
		sent = trash;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<mails> getInbox() {
		return inbox;
	}

	public void setInbox(ArrayList<mails> inbox) {
		this.inbox = inbox;
	}

	public ArrayList<mails> getTrash() {
		return sent;
	}

	public void setTrash(ArrayList<mails> trash) {
		sent = trash;
	}

	
	public String toString() {
		return "Client [mailId=" + mailId + ", userName=" + userName + ", password=" + password +  "]";
	}
	
	
}
