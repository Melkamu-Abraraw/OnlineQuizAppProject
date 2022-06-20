package Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdminTeacherInfoController {

    @FXML
    private Button AddBTN;

    @FXML
    private Button BackBTN;

    @FXML
    private Button CancelBTN;

    @FXML
    private Button DeleteBTN;

    @FXML
    private Button EditBTN;

    @FXML
    private Button SearchBTN;

    @FXML
    private TextField SearchTF;

    @FXML
    private TableColumn<?, ?> TeachIDColumn;

    @FXML
    private TextField WrittenDept;

    @FXML
    private TextField WrittenFName;

    @FXML
    private TextField WrittenIdTF;

    @FXML
    private TextField WrittenLN;

    @FXML
    private AnchorPane comboStud;

    @FXML
    private TableColumn<?, ?> depatColumn;

    @FXML
    private TableColumn<?, ?> firstNameColumn;

    @FXML
    private TableColumn<?, ?> lastNameColumn;

    @FXML
    private TableView<?> teachTable;

    @FXML
    void backButton(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/StudentInfo.fxml"));
            Stage stage = (Stage) BackBTN.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void cancelButton(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(""));
            Stage stage = (Stage) CancelBTN.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleOnAction(ActionEvent event) {

    }

}
