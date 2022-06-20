package Controller;



import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
    
    public class StudentLOginController {
    
        @FXML
        private Button clickhereButton;
    
        @FXML
        private Button loginButton;
    
        @FXML
        private PasswordField passwordPassField;
    
        @FXML
        private CheckBox remeRadioBtn;
        @FXML
        private Label labelId;
    
        @FXML
        private TextField usernameTextField;

        PreparedStatement sql;
    
        @FXML
        void loginAction(ActionEvent event) {
        
            if (usernameTextField.getText() != "" && passwordPassField.getText() != "") {
                DatabaseConnection c = new DatabaseConnection();
                Connection con = c.getconnection();
                try {
                    sql = con.prepareStatement("select *from student ");
                    ResultSet rs = sql.executeQuery();
                    while (rs.next()) {
                        if (rs.getString(4).equals(usernameTextField.getText())
                                && rs.getString(6).equals(passwordPassField.getText())) {
                       
                            try {
                                Parent root = FXMLLoader.load(getClass().getResource("/View/QuizEntry.fxml"));
                                Stage stage = (Stage) loginButton.getScene().getWindow();
                                Scene scene = new Scene(root);
                                stage.setScene(scene);
                                stage.show();
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
    
                        }
                        else{
                            labelId.setText("Incorrect Username and Password");
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else{
                labelId.setText("Please Enter Username and Password");
            }
    
        }
        
    
        @FXML
        void clickHereAction(ActionEvent event) {
    try {
        Parent root = FXMLLoader.load(getClass().getResource("/View/StudentSignUpPage.fxml"));
        Stage stage = (Stage)loginButton.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    } catch (Exception e) {
       System.out.println(e);
    }
        
    
    }
    
}

    