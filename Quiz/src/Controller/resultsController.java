package Controller;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;

import Model.Score;
import db.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class resultsController implements Initializable {

    @FXML
    private TableColumn<Score, Integer> Score;

    @FXML
    private JFXButton backbtn;

    @FXML
    private TableColumn<Score, String> courseitle;

    @FXML
    private TableView<Score> resultsCL;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        getstudentList();
    }

     ObservableList<Score> resultlist = FXCollections.observableArrayList();

    public void getstudentList() {
       
        dbConnection.dbConnect();
        String query = "select Title,result from Quiz cross join Result";
        Statement st;
        ResultSet rs;
        try {
            st = dbConnection.con.createStatement();
            rs = st.executeQuery(query);
            Score res;
            while (rs.next()) {
                res = new Score(rs.getString("Title"), rs.getInt("result"));
                resultlist.add(res);
            }
           
            showstudent();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showstudent() {
        ObservableList<Score> list =resultlist;

        courseitle.setCellValueFactory(new PropertyValueFactory<Score, String>("Title"));
        Score.setCellValueFactory(new PropertyValueFactory<Score, Integer>("result"));
        resultsCL.setItems(list);

    }// @FXML
     // void initialize() {

    // }
    @FXML
    void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/SwelcomP.fxml"));
        Stage stage = (Stage) backbtn.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
