package com.ojas.RegistrationForm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {

	Connection con;

	static Connection getConnection() {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java200", "root", "root");

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	// crearte person
	public static boolean addPreson(Person per) {
		boolean b = false;
		try {
			Connection con = getConnection();
			PreparedStatement pmt = con
					.prepareStatement("insert into persons(ename,connectno,email,gender,address)values(?,?,?,?,?)");
			// pmt.setInt(1, per.getPid());
			pmt.setString(1, per.getEname());
			pmt.setString(2, per.getConnectno());
			pmt.setString(3, per.getEmail());
			pmt.setString(4, per.getGender());
			pmt.setString(5, per.getAddress());

			int res = pmt.executeUpdate();
			if (res > 0) {
				b = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}
 // list persons details
	public List<Person> listPersons() {
		List<Person> list = new ArrayList<Person>();
		try {
			Connection con = getConnection();
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery("select * from persons");
			while (res.next()) {
				Person p = new Person(res.getInt(1), res.getString(2), res.getString(3), res.getString(4),
						res.getString(5), res.getString(6));
				list.add(p);
			}
			res.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	// Validation
	public static boolean validate(String uname,String upass) {
		boolean b = false;
		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("select * from persons where ename =? and connectno=?");
			pst.setString(1, uname);
			pst.setString(2, upass);
			ResultSet res = pst.executeQuery();
			if(res.next()) {
				b=true;
			}
		}catch (Exception e) {
System.out.println(e);		
}
		return b;
	}

	// Delete Operation
	public boolean delPerson(int num) {
        boolean b = false;
          try {
              Connection con = getConnection();
              PreparedStatement pst = con.prepareStatement("delete from persons where pid =?");
              pst.setInt(1,num);
              int res = pst.executeUpdate();
              if(res>0) {
                  b = true;
              }
          }
              catch(Exception e) {
                  System.out.println(e);
              }
              return b;
          }
	// Upadte Operation
	 public static boolean updatePerson(Person person) {
	        boolean b = false;
	        try {
	            Connection con = getConnection();
	            PreparedStatement pst = con
	                    .prepareStatement("update persons set ename=?,connectno=?,email=?,gender=?,address=? where pid=?");
	            pst.setString(1, person.getEname());
	            pst.setString(2, person.getConnectno());
	            pst.setString(3, person.getEmail());
	            pst.setString(4, person.getGender());
	            pst.setString(5, person.getAddress());
	            pst.setInt(6, person.getPid());
	            int res = pst.executeUpdate();
	            if (res > 0) {
	                b = true;
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return b;
	    }

}
