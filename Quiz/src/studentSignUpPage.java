import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class studentSignUpPage extends dbConnection  implements Initializable {

    @FXML
    private TextField IdTF;

    @FXML
    private Button backcbtn;
    @FXML
    private CheckBox ShowPass;
    @FXML
    private TextField PasswordTF;

    @FXML
    private TextField depTF;

    @FXML
    private TextField emailTF;

    @FXML
    private TextField fnameTF;

    @FXML
    private TextField lastNameTF;

    @FXML
    private Hyperlink loginHyper;
    @FXML
    private PasswordField passwordTF;

    @FXML
    private Button signbtn;

    @FXML
    private TextField usernaneTF;
    
    @FXML
    void BackAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("studentlogin.fxml"));
            Stage stage=(Stage)backcbtn.getScene().getWindow();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void studloginAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("studentlogin.fxml"));
            Stage stage=(Stage)loginHyper.getScene().getWindow();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
     }
     public void store(){
         dbConnect();
        String sql = ("insert into Student(StudId,FirstName,LastName,Username,Email,Password) values(?,?,?,?,?,?)");
        try {
            PreparedStatement st = con.prepareStatement(sql);
    
            st.setString(1, IdTF.getText());
            st.setString(2, fnameTF.getText());
            st.setString(3, lastNameTF.getText());
            st.setString(4, usernaneTF.getText());
            st.setString(5, emailTF.getText());
            st.setString(6, passwordTF.getText());
           
        
            st.executeUpdate();
            Alert alert=new Alert(AlertType.INFORMATION ,"REGISTERED SUCCESSFULLY", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
            
            
     
       
            } catch (Exception e) {
         System.out.println(e);
        }


    }
   
    @FXML
    void signbtn(ActionEvent event) {

       
            if (fnameTF.getText().isBlank()==false && lastNameTF.getText().isBlank()==false  
            && passwordTF.getText().isBlank()==false
            && emailTF.getText().isBlank()==false  
            && IdTF.getText().isBlank()==false && depTF.getText().isBlank()==false) {
                store();
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("studentlogin.fxml"));
                    Stage stage=(Stage)signbtn.getScene().getWindow();
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
       
        
    }

           
        }


    

    


