package Database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import User.mails;


public class LoadData {

	
	public void InsertUser(String mailId,String password,String name) {

		
		
		try {
			PreparedStatement pt = DBconnection.getDbConnection().prepareStatement("insert into users values(?,?,?)");
			pt.setString(1, mailId );
			pt.setString(2, name );
			pt.setString(3, password );
			
			pt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public String getPassword(String mailId) {
		
		try {
			PreparedStatement pt = DBconnection.getDbConnection().prepareStatement("select password from users where email_id = ? ");
			pt.setString(1, mailId);
			ResultSet st =  pt.executeQuery();
			System.out.println(pt);
			if(st.next()) {
				
				return st.getString(1);
			}
			
			
		} catch (SQLException e) {
		 
			System.out.println(e.getMessage());
			
		}
		
		return "";
		
	}
	
	public ArrayList<String[]> LoadMails() {

		try {
			File file = new File("mails.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			ArrayList<String[]> mailsList = new ArrayList<>();
			while ((line = br.readLine()) != null) {
				mailsList.add(line.split("!"));
			}
			br.close();
			System.out.println(Arrays.toString( mailsList.get(0)));
			return mailsList;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public void StoreMail(mails mail) {

		BufferedWriter bw = null;
		try {

			File file = new File("mails.txt");

			if (!file.exists()) {
				
				file.createNewFile();
			}

			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			bw = new BufferedWriter(new FileWriter(file, true));

			bw.write(mail.getSender() + "!" + formatter.format(mail.getDateRecieved()) + "!"
					+ mail.getSubject() + "!" + mail.getMail() + "!" + mail.getReciever() + "!"
					+ mail.getStatus() + "\n");
			System.out.println("Msg Sent Successfully");

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error in closing the BufferedWriter" + ex);
			}
		}

	}
	
	
}
