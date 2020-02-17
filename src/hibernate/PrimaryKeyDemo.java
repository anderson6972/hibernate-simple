package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Student;

public class PrimaryKeyDemo {

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
					Student student2 = new Student("Ander","Marin","aewro@hotmail.com");
					Student student3= new Student("Jose","Ortega","ajmoww@hotmail.com");
					
					//iniciar la transaccion//salvarl el objecto
					sesion.beginTransaction();
					sesion.save(student);
					sesion.save(student2);
					sesion.save(student3);
					
					//commit de la transacion
					sesion.getTransaction().commit();
				}finally {
					factory.close();
				}

			}


	

}
