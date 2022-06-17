package services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.text.SimpleDateFormat;

import Beans.User;
import Beans.UserType;

public class UserService {
	
	private HashMap<String,User> users = new HashMap<String, User>();
	
    public UserService(){
        BufferedReader in = null;
		try {
			File file = new File("static\\users.txt");
			System.out.println(file.getCanonicalPath());
			in = new BufferedReader(new FileReader(file));
			readUsers(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if ( in != null ) {
				try {
					in.close();
				}
				catch (Exception e) { }
			}
		}
    }


    private void readUsers(BufferedReader in) {
		String line, username = "", password = "", name = "", surname = "", gender = "",date = "",type="";
		StringTokenizer st;
		try {
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
				    username = st.nextToken().trim();
					password = st.nextToken().trim();
					name = st.nextToken().trim();
                    surname = st.nextToken().trim();
                    gender = st.nextToken().trim();
                    date = st.nextToken().trim();
                    type = st.nextToken().trim();
				}
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				User user = new User(username,password, name,surname,gender,sdf.parse(date),StringToUserType(type));
				users.put(username, user);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

    private UserType StringToUserType(String s){
		switch(s){
			case "Customer": return UserType.Customer;
			case "Administrator": return UserType.Administrator;
			case "Manager": return UserType.Manager;
			case "Trainer": return UserType.Trainer;
            default: return UserType.Customer;
		}
	}

    public Collection<User> getUsers() {
		return users.values();
	}

	/** Vraca proizvod na osnovu njegovog id-a. */
	public User getUser(String username) {
		return users.get(username);
	}

	public void addUser(User user) {
		this.users.put(user.getUsername(), user);
	}

	public void editUser(String username, User user) {
		this.users.put(username, user);
	}

	public void deleteUser(String username) {
		this.users.remove(username);
	}

}
