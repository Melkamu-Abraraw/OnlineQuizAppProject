package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;



public class dbConnection { 

    static final String url="jdbc:mysql://localhost/QuizDatabase";
       static final String usrName="sqluser";
       static final String dbPassword="password";
       public static Connection con=null; 
       static Statement stmt=null;
       static ResultSet resultSet=null;

    public static void dbConnect(){
        try {
        con=DriverManager.getConnection(url, usrName, dbPassword);
        stmt=con.createStatement();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }

       
    }
}
   
