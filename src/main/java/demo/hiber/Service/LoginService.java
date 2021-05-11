package demo.hiber.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import demo.hiber.Model.SignUpUser;
import demo.hiber.Model.User;
import demo.hiber.util.HiberUtil;

public class LoginService {
	static SessionFactory sf;
	static Session session;
	static Transaction trans;
	static Configuration config;

	public static boolean authenticateUser(String userid, String password) {
		// TODO Auto-generated method stub
		User user = getUserbyId(userid);
		if (user != null && userid.equals(user.getUserid()) && password.equals(user.getPass())) {
			return true;
		} else {
			return false;

		}
	}

	private static User getUserbyId(String userid) {
		// TODO Auto-generated method stub
		Session session = HiberUtil.openSession();
		Transaction trans = null;
		User user = null;
		trans = session.beginTransaction();
		user = (User) session.get(User.class, userid);
		trans.commit();
		return user;
	}

	public static Session getSession() {
		sf = new Configuration().configure().buildSessionFactory();
		return sf.openSession();
	}

	public static int UserInsertion(SignUpUser customer) {

		System.out.println("Validating..............");
		session=getSession();
		trans=session.beginTransaction();
		session.save(customer);
		trans.commit();
		System.out.println("User added successfully");
		return 1;
	}

}
