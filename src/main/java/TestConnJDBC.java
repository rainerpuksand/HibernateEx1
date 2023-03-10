import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnJDBC {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/forHibernateex", "root", "Ozzy1401");

            System.out.println("CONNECTED!!!");

        } catch (SQLException e) {
            System.out.println("Not Connectedxxxxxxxxxxxxxxxx");
            e.printStackTrace();
        }

    }
}
