import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class OccupationsController implements Initializable
 {
   

    @FXML
    private Button ButtonAdminID;

    @FXML
    private Button buttonStudentID;

    @FXML
    private Button buttonTeacherID;

    

    @FXML
    void AdminOnAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
            Stage stage = (Stage)ButtonAdminID.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
           System.out.println(e);
        }
    }

    @FXML
    void StudentOnAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("studentlogin.fxml"));
            Stage stage = (Stage)buttonStudentID.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
           System.out.println(e);
        }
    }

    @FXML
    void TeacherOnAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("teacher_login.fxml"));
            Stage stage = (Stage)buttonTeacherID.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
           System.out.println(e);
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
 
        
    }

}
