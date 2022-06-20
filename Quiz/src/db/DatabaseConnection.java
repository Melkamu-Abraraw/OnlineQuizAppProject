package db;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection  {
   
    public Connection connection;
    
    public Connection getconnection(){
          
        String DBName = "quizdatabase";
        String user = "root" ;
        String password = "nebiyat";
         String url = "jdbc:mysql://localhost:3306/"+DBName;
    
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
          System.out.println(e);
        }
        return connection;
      }
    }