import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Jack on 28.12.2016.
 */
public class ConTest {

    public static void main(String[] args) throws SQLException, NamingException {

        System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
                "org.apache.naming.java.javaURLContextFactory");

        Context initContext = new InitialContext();
        Context envContext  = (Context)initContext.lookup("java:comp/env");
        DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
        Connection conn = ds.getConnection();
    }
}
