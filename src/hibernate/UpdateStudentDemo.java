package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//session
		Session sesion=factory.getCurrentSession();
		int id=1;
		try {
			//salvar el objecto
			//crear el objecto
			sesion.beginTransaction();
			Student student = (Student) sesion.get(Student.class, id);
			student.setFirstName("Canseco");								
			
			//commit de la transacion
			sesion.getTransaction().commit();
			
			sesion=factory.getCurrentSession();
			sesion.beginTransaction();
			sesion.createQuery("update Student set email='demco@com.es'").executeUpdate();							
			
			//commit de la transacion
			sesion.getTransaction().commit();
			
			
		}finally {
			factory.close();
		}

	}

}
