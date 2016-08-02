package ro.ladentist.LaDentist.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserList {

	private static UserList instance;
	private Connection connection;

	private UserList() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/LaDentist");
			connection = ds.getConnection();// DriverManager.getConnection("jdbc:mysql://localhost:3306/ladentist",
											// "root", "orlando");
		} catch (SQLException | NamingException e) {
			throw new RuntimeException("Cannot connect to database", e);
		}
	}

	public static UserList getInstance() {
		if (instance == null) {
			instance = new UserList();
		}
		return instance;
	}

	public boolean checkCredentials(String username, String password) {

		try (PreparedStatement read = connection
				.prepareStatement("select * from user_list as u WHERE  u.username = '" + username + "'");) {
			ResultSet rs = read.executeQuery();
			if (!rs.next()) {
				System.out.println("fara rezultate");
				return false;
			}
			String corectPassword = rs.getString("password");
			System.out.println("parola   " + corectPassword);
			if (corectPassword.equals(password)) {
				return true;
			} else {
				System.out.println("parola incorecta ");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
