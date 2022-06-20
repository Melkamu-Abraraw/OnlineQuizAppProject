import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminLoginController {

    @FXML
    private PasswordField PasswordTField;

    @FXML
    private Button SignInBTN;
    @FXML
    private Label LabelID;

    @FXML
    private TextField userTextField;
    @FXML
    private Button BackButton;
    PreparedStatement verify;

    @FXML
    void loginPressed(ActionEvent event) {

        if (userTextField.getText() != "" && PasswordTField.getText() != "") {
            DatabaseConnection c = new DatabaseConnection();
            Connection con = c.getconnection();
            try {
                verify = con.prepareStatement("select *From admins ");
                ResultSet rs = verify.executeQuery();
                while (rs.next()) {
                    if (rs.getString(1).equals(userTextField.getText())
                            && rs.getString(2).equals(PasswordTField.getText())) {

                   
                        try {
                            Parent root = FXMLLoader.load(getClass().getResource("StudentInfo.fxml"));
                            Stage stage = (Stage) SignInBTN.getScene().getWindow();
                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                    }
                    else{
                        LabelID.setText("Incorrect Username and Password");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            LabelID.setText("Please Enter Username and Password");
        }

    }

    @FXML
    void backButtonOnAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Occupations.fxml"));
            Stage stage = (Stage) BackButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}