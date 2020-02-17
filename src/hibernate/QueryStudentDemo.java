package hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//session
		Session sesion=factory.getCurrentSession();
		
		try {
			sesion.beginTransaction();
			
			List<Student> lstStudent= sesion.createQuery("from Student").list();
			
			System.out.println("Tamaño de la lista recuparado-> "+lstStudent.size());
//			
//			displayStudent(lstStudent);
//			sesion.getTransaction().commit();
//			
//			sesion=factory.getCurrentSession();
//			sesion.beginTransaction();
			
			lstStudent= sesion.createQuery("from Student s where s.lastName='Marin'").list();
			System.out.println("Tamaño de la lista recuparado-> "+lstStudent.size());
			
			displayStudent(lstStudent);
			lstStudent= sesion.createQuery("from Student s where s.lastName='Marino' or s.lastName='Duck'").list();
			System.out.println("Tamaño de la lista recuparado-> "+lstStudent.size());
			
			displayStudent(lstStudent);
			
			
			lstStudent= sesion.createQuery("from Student s where s.email LIKE '%@hotmail.com'").list();
			System.out.println("Tamaño de la lista recuparado-> "+lstStudent.size());
			
			displayStudent(lstStudent);
			sesion.getTransaction().commit();
		}finally {
			factory.close();
		}

	}

	private static void displayStudent(List<Student> lstStudent) {
		for(Student entity:lstStudent) {
			System.out.println(entity);
		}
	}

}
