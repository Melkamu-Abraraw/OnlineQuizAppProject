package Controller;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import Model.Student;
import db.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdminStudInfoController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AddBTN;

    @FXML
    private Button BackBTN;
    @FXML
    private ComboBox<String> comboStud;
    @FXML
    void selectOnAction(ActionEvent event) {

    }
    @FXML
    private Button CancelBTN;

    @FXML
    private Button ClearBTN;

    @FXML
    private Button DeleteBTN;

    @FXML
    private Button EditBTN;

    @FXML
    private TableColumn<Student, String> IDColumn;
    @FXML
    private TableColumn<Student, String> deptColumn;

    @FXML
    private TableColumn<Student, String> fNameColumn;

    @FXML
    private TableColumn<Student, String> lNameColumn;

    @FXML
    private Button SearchBTN;
    

    @FXML
    private TextField WrittenTF111;

    @FXML
    private TextField WrittenTFFN;

    @FXML
    private TextField WrittenTFLN;

    @FXML
    private TextField SearchTF;

    @FXML
    private TextField WrittenTF;

    @FXML
    private TableView<Student> studTable;

    @FXML
    void handleOnAction(ActionEvent event) {
        if(event.getSource()==AddBTN){
            insertRecords();
        }
        else if(event.getSource()==EditBTN){
            updateRecords();
        }
        else if(event.getSource()==DeleteBTN){
            deleteRecords();
        }
        else if(event.getSource()==ClearBTN){
            ClearRecords();
        }
            }
    String a = comboStud.getSelectionModel().getSelectedItem().toString(); 

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
      showstudent();
      ObservableList<String> list = FXCollections.observableArrayList();
      list.add("teacherInfo");
      comboStud.setItems(list);
      if (comboStud.getValue().equals("teacherInfo")) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/teacherInfo.fxml"));
            Stage stage = (Stage)comboStud.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
           System.out.println(e);
        }
      } else {
        
      }
    }
    public ObservableList<Student> getstudentList(){
    ObservableList<Student> studentList =FXCollections.observableArrayList();
    DatabaseConnection c = new DatabaseConnection();
    Connection con = c.getconnection();
    String query="select ID,FirstName,LastName,Department from StudAdmin INNER JOIN Student on  Student.StudID=StudAdmin.ID";

    Statement st;
    ResultSet rs;
    try {
        st=con.createStatement();
        rs=st.executeQuery(query);
        Student student;
        while(rs.next()){
              student=new Student(rs.getString("ID"),rs.getString("FirstName"),
              rs.getString("LastName"),rs.getString("Department"));
             
            
            studentList.add(student);
            }

    } catch (Exception e) {
    e.printStackTrace();
    }
    return studentList;
}
public void showstudent(){
    ObservableList<Student> list= getstudentList();
    
    IDColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("ID"));
    fNameColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("FirstName"));
    lNameColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("LastName"));
    deptColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("Department"));
    studTable.setItems(list);
}
void ClearRecords(){
    WrittenTF.clear();
}
public void insertRecords(){
    DatabaseConnection c = new DatabaseConnection();
    Connection con = c.getconnection();
    String sql = ("insert into StudAdmin values('"+ WrittenTF.getText()+"')");
    String sql1= ("insert into Student(StudId,FirstName,LastName,Department) values(?,?,?,?)");
    try {
        PreparedStatement st = con.prepareStatement(sql1);

        st.setString(2, WrittenTFFN.getText());
        st.setString(3, WrittenTFLN.getText());
        st.setString(4, WrittenTF111.getText());
        st.setString(1,WrittenTF.getText());
   
        st.executeUpdate();
        } catch (Exception e) {
     System.out.println(e);
    }
    
    executeQuery(sql);
    showstudent();
    Alert alret=new Alert(AlertType.INFORMATION);
            alret.setTitle("Online Quiz App");
            alret.setHeaderText("Student Information");
            alret.setContentText("Record Added!!");
            alret.showAndWait();
            WrittenTF.clear();
            WrittenTF111.clear();
            WrittenTFFN.clear();
            WrittenTFLN.clear();
}
public void updateRecords(){ 
    String sql=("update StudAdmin set StudID = ('"+ WrittenTF.getText()+"')" + "where StudID = ('"+ WrittenTF.getText()+"')");
    executeQuery(sql);
    showstudent();
    Alert alret=new Alert(AlertType.INFORMATION);
    alret.setTitle("Online Quiz App");
    alret.setHeaderText("Student Information");
    alret.setContentText("Updated sucessfully!!");
    alret.showAndWait();
}
public void deleteRecords(){
    String sql=("delete from StudAdmin where StudID = ('"+ WrittenTF.getText()+"')");
    executeQuery(sql);
    showstudent();

    Alert alret=new Alert(AlertType.INFORMATION);
    alret.setTitle("Online Quiz App");
    alret.setHeaderText("Student Information");
    alret.setContentText("Deleted sucessfully!!");
    alret.showAndWait();
}
public void executeQuery(String sql){
    DatabaseConnection c = new DatabaseConnection();
    Connection con = c.getconnection();
    Statement st;
   try {
    st=con.createStatement();
    st.executeUpdate(sql);
    
}
    catch (Exception e) {
    e.printStackTrace();
   }

}
}