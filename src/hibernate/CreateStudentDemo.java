package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//session
		Session sesion=factory.getCurrentSession();
		
		try {
			//salvar el objecto
			//crear el objecto 
			Student student = new Student("Anderson","Marino","ajmo@hotmail.com");			
			
			//iniciar la transaccion//salvarl el objecto
			sesion.beginTransaction();
			sesion.save(student);
			
			//commit de la transacion
			sesion.getTransaction().commit();
		}finally {
			factory.close();
		}

	}

}
