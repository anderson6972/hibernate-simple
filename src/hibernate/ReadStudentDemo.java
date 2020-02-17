package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Student;

public class ReadStudentDemo {

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
			Student student = new Student("Daffy","Duck","duck@hotmail.com");			
			
			//iniciar la transaccion//salvarl el objecto
			sesion.beginTransaction();
			sesion.save(student);
			sesion.getTransaction().commit();
			//
			System.out.println("Estudiante guardado id:"+student.getId());
			
			//buscando el estudiante
			
		    sesion=factory.getCurrentSession();
			sesion.beginTransaction();
			
			Student findStudent = (Student) sesion.get(Student.class, student.getId());
			
			System.out.println(findStudent.toString());
			
			
			//commit de la transacion
			sesion.getTransaction().commit();
		}finally {
			factory.close();
		}

	}

}
