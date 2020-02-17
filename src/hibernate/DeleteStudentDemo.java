package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//session
		Session sesion=factory.getCurrentSession();
		
		try {
			int id=1;
			
			//buscando el estudiante
			
		    sesion=factory.getCurrentSession();
			sesion.beginTransaction();
			
			Student findStudent = (Student) sesion.get(Student.class,id);
			sesion.delete(findStudent);			
			sesion.getTransaction().commit();
			
			sesion=factory.getCurrentSession();
			sesion.beginTransaction();
			
			sesion.createQuery("delete from Student s where s.id=2").executeUpdate();
			
			sesion.getTransaction().commit();
		}finally {
			factory.close();
		}

	}

}
