package DataAccesLayer;

import java.sql.*;
import java.util.logging.Logger;

public class ConnectionFactory {
    private static final Logger LOGGER=Logger.getLogger(ConnectionFactory.class.getName());
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    private static Connection connection;
    private static String URL = "jdbc:mysql://localhost:3306/schooldb1";
    private static String DB_NAME = "schooldb1";
    private static String USER = "root";
    private static String PASSWORD = "Vladutz23*45";

    public ConnectionFactory()
    {
        try
        {
            Class.forName(DRIVER);
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static void createConnection()
    {
        try
        {
            new ConnectionFactory();
            connection= DriverManager.getConnection(URL,USER,PASSWORD);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static Connection getConnection()
    {
        return connection;
    }

    public static void close()
    {
        try
        {
            connection.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void close(Connection con)
    {
        if(con!= null)
        {
            try
            {
                con.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void close (Statement stat)
    {
        if(stat!=null)
        {
            try
            {
                stat.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void close (ResultSet resSet)
    {
        if(resSet!=null)
        {
            try
            {
                resSet.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

}
