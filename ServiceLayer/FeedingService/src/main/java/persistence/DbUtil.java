package persistence;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public class DbUtil{
    public static Connection getDatabaseConnection()
    {
        Connection con = null;

        try {
            InitialContext initialContext = new InitialContext();
            DataSource datasource = (DataSource) initialContext.lookup("jdbc/postgrespool");
            if (datasource != null) con = datasource.getConnection();
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return con;
    }
}


/*import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DbUtil {
    @Resource(name = "jdbc/postgrespool")
    DataSource ds;

    public Connection getCon() {
        try {
            Connection connection = ds.getConnection();
            return connection;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}*/

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static Connection dbConnection = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String dbUrl = System.getenv("dbUrl");
        String dbUser = System.getenv("dbUser");
        String dbPassword = System.getenv("dbPassword");

        dbConnection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        return dbConnection;

    }//getConnection
}*/
