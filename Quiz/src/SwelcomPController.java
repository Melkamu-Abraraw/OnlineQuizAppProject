import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SwelcomPController extends resultsController {

    @FXML
    private JFXButton prevbtn;

    @FXML
    private JFXButton quizbtn;

    @FXML
    void PreviousResults(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("results.fxml"));
        Stage stage = (Stage) quizbtn.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();  
    }

    @FXML
    void TakeQuiz(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("QuizStart.fxml"));
        Stage stage = (Stage) quizbtn.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();        
    }

}
