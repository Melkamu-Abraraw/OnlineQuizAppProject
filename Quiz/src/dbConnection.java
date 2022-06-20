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
       static Connection con=null; 
       static Statement stmt=null;
       static ResultSet resultSet=null;

    static void dbConnect(){
        try {
        con=DriverManager.getConnection(url, usrName, dbPassword);
        stmt=con.createStatement();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }

       
    }
}
   
