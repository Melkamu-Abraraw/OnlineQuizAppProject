package Controller;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;

import db.dbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class QuizStartController extends dbConnection {
    ResultSet result = null;
    @FXML
    private ChoiceBox<String> coursesCB;

    @FXML
    private TextField idTF;
    static String id = null;

    @FXML
    private JFXButton startbtn;

    @FXML
    void startButton(ActionEvent event) throws SQLException, IOException {
        getData();
        Parent root = FXMLLoader.load(getClass().getResource("/View/Question.fxml"));
        Stage stage = (Stage) startbtn.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    static String str = null;
    static int qID = 0;

    public void getData() throws SQLException {
        str = coursesCB.getSelectionModel().getSelectedItem();
        String query = "select quizID from Quiz where Title = ?";
        dbConnect();
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, str);
       ResultSet res = ps.executeQuery();
       while(res.next()) {
        qID = res.getInt(1);
       }
        id = idTF.getText();
    }

    @FXML
    void initialize() throws SQLException {

        String query = "select * from Quiz";
        dbConnect();
        PreparedStatement ps = con.prepareStatement(query);
        result = ps.executeQuery();
        while (result.next()) {
            coursesCB.getItems().add(result.getString(2));
        }
    }
}
