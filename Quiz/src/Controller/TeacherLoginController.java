package Controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

import db.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TeacherLoginController {

    @FXML
    private PasswordField TFteacherloginpasswd;

    @FXML
    private TextField TFteachersignupfirstname;

    @FXML
    private Button btnteacherloginback;
    @FXML
    private Label labelid;

    @FXML
    private Hyperlink linkCNA;

    @FXML
    private Button btnteacherloginlogin;

    @FXML
    private AnchorPane teacherloginpane;

    @FXML
    void createNewAccountOnAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/teacher_signup.fxml"));
            Stage stage = (Stage)linkCNA.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
           System.out.println(e);
        }
    }
    

    @FXML
    void PFteacherloginpasswd(ActionEvent event) {
       
        
    }

    @FXML
    void TFteachersignupfirstnameonaction(ActionEvent event) {
    }

    PreparedStatement verify;
    @FXML
    void btnteacherloginloginonaction(ActionEvent event) {

        if (TFteachersignupfirstname.getText() != "" && TFteacherloginpasswd.getText() != "") {
            DatabaseConnection c = new DatabaseConnection();
            Connection con = c.getconnection();
            try {
                verify = con.prepareStatement("select * From teacher ");
                ResultSet rs = verify.executeQuery();
                while (rs.next()) {
                    if (rs.getString(4).equals(TFteachersignupfirstname.getText())
                            && rs.getString(6).equals(TFteacherloginpasswd.getText())) {

                   
                        try {
                            Parent root = FXMLLoader.load(getClass().getResource("/View/QuizEntry.fxml"));
                            Stage stage = (Stage)btnteacherloginlogin.getScene().getWindow();
                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException e) {
                            
                            e.printStackTrace();
                        }

                    }
                    else{
                        labelid.setText("Incorrect Username and Password");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            labelid.setText("Please Enter Username and Password");
        }

    }

    @FXML
    void btnteacherloginbackonaction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/Occupations.fxml"));
            Stage stage = (Stage)btnteacherloginback.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
           System.out.println(e);
        }
    }

  
}
