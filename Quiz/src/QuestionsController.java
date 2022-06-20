import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXRadioButton;
import com.mysql.cj.xdevapi.Statement;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;

public class QuestionsController extends dbConnection implements Initializable {
    static int cnt = 0;

    @FXML
    private ToggleGroup Option;

    @FXML
    private JFXRadioButton option1;

    @FXML
    private JFXRadioButton option2;

    @FXML
    private JFXRadioButton option3;

    @FXML
    private JFXRadioButton option4;

    @FXML
    private Label question;

    @FXML
    private JFXButton submitbtn;

    @FXML
    void Submit(ActionEvent event) throws SQLException {
        // QuestionsController.getData(id, str);
        dbConnect();
        String query = "Insert into Result (QuizID, StudId, result) values (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, QuizStartController.qID);
        ps.setString(2, QuizStartController.id);
        ps.setInt(3, cnt);
        int i = ps.executeUpdate();
    }

    @FXML
    private JFXButton nextbtn;

    ResultSet result = null;

    @FXML
    void next(ActionEvent event) throws SQLException {
        nextQuestion();
    }

    String ans = null;

    public void nextQuestion() throws SQLException {
        if (result.next()) {
            question.setText(result.getString(3));
            option1.setText(result.getString(4));
            option2.setText(result.getString(5));
            option3.setText(result.getString(6));
            option4.setText(result.getString(7));
            option1.setSelected(true);
            ans = result.getString(8);
            if (((Labeled) Option.getSelectedToggle()).getText().equals(ans)) {
                cnt++;
            }
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setContentText("You Have Finished Your Quiz!\nPlease Submit Your Quiz To Be Evaluated!  " + cnt);
            alert.show();
            nextbtn.setVisible(false);
            submitbtn.setVisible(true);
        }
        
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        try {
            String query = "select * from Questions join Quiz on Quiz.quizID = Questions.qid where  Quiz.Title = ? order by rand()";
            dbConnect();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, QuizStartController.str);
            result = ps.executeQuery();
            nextQuestion();
            submitbtn.setVisible(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
