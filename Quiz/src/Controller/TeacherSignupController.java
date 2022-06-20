package Controller;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import db.dbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class TeacherSignupController extends dbConnection implements Initializable {

    @FXML
    private HBox HBteachersignupwelcome;

    @FXML
    private PasswordField PFteachersignuppasswd;

    @FXML
    private TextField TFteachersignupemail;

    @FXML
    private TextField TFteachersignupfirstname;

    @FXML
    private TextField TFteachersignuplastname;

    @FXML
    private TextField TFteachersignupusername;

    @FXML
    private Button btnteachersignupback;

    @FXML
    private Button btnteachersignupsubmit;

    @FXML
    private Label lblteachersignupsignup;

    @FXML
    private Label lblteachersignupwelcome;

    @FXML
    private AnchorPane teachersignuppane;

    @FXML
    void PFteachersignuppasswdonaction(ActionEvent event) {

    }
    public void store(){
        dbConnect();
       String sql = ("insert into Student(StudId,FirstName,LastName,Username,Email,Password) values(?,?,?,?,?,?)");
       try {
           PreparedStatement st = con.prepareStatement(sql);
   
           st.setString(1, TFteachersignupfirstname.getText());
           st.setString(2, TFteachersignuplastname.getText());
           st.setString(3, TFteachersignupusername.getText());
           st.setString(4, TFteachersignupemail.getText());
           st.setString(5, PFteachersignuppasswd.getText());
           
          
       
           st.executeUpdate();
           Alert alert=new Alert(AlertType.INFORMATION ,"REGISTERED SUCCESSFULLY", ButtonType.OK);
           alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
           alert.show();
           
           
    
      
           } catch (Exception e) {
        System.out.println(e);
       }


   }
  

    @FXML
    void TFteachersignupemailonaction(ActionEvent event) {

    }

    @FXML
    void TFteachersignupfirstnameonaction(ActionEvent event) {

    }

    @FXML
    void TFteachersignuplastnameonaction(ActionEvent event) {

    }

    @FXML
    void TFteachersignupusernameonaction(ActionEvent event) {

    }

    @FXML
    void btnteachersignupbacksetonaction(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/teacher_login.fxml"));
            Stage stage = (Stage)btnteachersignupback.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
           System.out.println(e);
        }
    }

    @FXML
    void btnteachersignupsubmitsetonaction(ActionEvent event) {

        if (TFteachersignupfirstname.getText().isBlank()==false && TFteachersignuplastname.getText().isBlank()==false  
        && PFteachersignuppasswd.getText().isBlank()==false
        && TFteachersignupemail.getText().isBlank()==false) {
            store();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/View/teacher_login.fxml"));
                Stage stage=(Stage)btnteachersignupsubmit.getScene().getWindow();
                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

                }else {
                    Alert alert=new Alert(AlertType.WARNING ,"Please fill all the requirements!", ButtonType.CLOSE);
                    alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    alert.show();
        
      }
      
    }

    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
    }

}
