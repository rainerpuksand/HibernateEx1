import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateMagic {
    public static void main(String[] args) {

        //session factory from config
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(MyCar.class)
                .buildSessionFactory();

        //session from its factory
        Session session = factory.getCurrentSession();

        try {
            //make java object
            System.out.println("Creating new Car Java object...");
            MyCar obj = new MyCar("Chevrolette", 500, false);

            //transaction
            session.beginTransaction();

            // INSERT/create record into Table via the java object
            System.out.println("Inserting into table...");
            session.save(obj);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("End  --x x x x x x x x x-- ");

        }
        catch(HibernateException e){
            System.out.println(e.getMessage()); //call rollback in catch block
        }
        finally {
            factory.close();
        }
    }
}
//https://stackoverflow.com/questions/8046662/hibernate-opensession-vs-getcurrentsession#:~:text=openSession()%20always%20opens%20a,t%20need%20to%20close%20this.