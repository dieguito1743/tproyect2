package org.yourcart.model;

/**
 *
 * @author OsamaPC
 */
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {

    Connection con = null;
    private final String url = "jdbc:mysql://sql10.freesqldatabase.com/sql10244983";
    private final String user = "sql10244983";
    private final String pass = "SDRZrhdYuB";

    public DbConnection() {
        
        /*Properties prop = new Properties();

        try {

            //access properties file
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream input = classLoader.getResourceAsStream("config.properties");

            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/

        //get value from Properties file 
        //url = prop.getProperty("url", "");
        //user = prop.getProperty("username", "");
        //pass = prop.getProperty("password", "");
    	System.out.println(" URL " + url);
    	System.out.println(" USER " + user);
    	System.out.println(" PASS " + pass);

    }

    public Connection openConnection() {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            //connect to DB
            con = DriverManager.getConnection(
                    url,
                    user,
                    pass);

            System.out.println(con);
            return con;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    public boolean closeConnection() {
        try {

            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }
}
