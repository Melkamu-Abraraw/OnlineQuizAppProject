package Controller;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Model.Questions;
import Model.Quiz;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;

public class QuizEntryController implements Initializable {

    @FXML
    private TextField Quiztitle;

    @FXML
    private Button addNextQuestion;

    @FXML
    private TextField option1;

    @FXML
    private RadioButton option1radio;

    @FXML
    private TextField option2;

    @FXML
    private RadioButton option2radio;

    @FXML
    private RadioButton option3radio;

    @FXML
    private TextField option4;

    @FXML
    private TextField option3;
    @FXML
    private RadioButton option4radio;

    private ToggleGroup radioGroup;

    @FXML
    private TextField question;

    @FXML
    private Button submitQuiz;
    private Quiz quiz = null;
    private ArrayList<Questions> questions = new ArrayList<>();
   
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        radioButtonSetup();       
    }
    private void radioButtonSetup(){
        radioGroup = new ToggleGroup();
        option1radio.setToggleGroup(radioGroup);
        option2radio.setToggleGroup(radioGroup);
        option3radio.setToggleGroup(radioGroup);
        option4radio.setToggleGroup(radioGroup);
    }
    @FXML
    private void setQuizTitle(ActionEvent event) {
       
        String title = Quiztitle.getText();
        if(title.trim().isEmpty()){
            {
                Alert alert=new Alert(AlertType.ERROR ,"Please Enter All Field", ButtonType.NEXT);
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alert.show();                
            }
            
        }else{
            Quiztitle.setEditable(false);          
            this.quiz = new Quiz(title);
        }
    }
    
        @FXML
        private void addNextQuestion(ActionEvent event) {
           addQuestions();
        }
        
        private boolean addQuestions(){
             boolean valid = validateFields();
            Questions question = new Questions();
            if(valid){
                 
                question.setOption1(option1.getText().trim());
                question.setOption2(option2.getText().trim());
                question.setOption3(option3.getText().trim());
                question.setOption4(option4.getText().trim());
                Toggle selected = radioGroup.getSelectedToggle();
                String ans = null;
                if(selected == option1radio){
                    ans = option1.getText().trim();
                }else if(selected == option2radio){
                    ans = option2.getText().trim();
                }
                else if(selected == option3radio){
                    ans = option3.getText().trim();
                }
                else if(selected == option4radio){
                    ans = option4.getText().trim();
                }
                question.setAnswer(ans);
                question.setQuestion(this.question.getText().trim());               
                this.question.clear();
                option1.clear();
                option2.clear();
                option3.clear();
                option4.clear();
                questions.add(question);
                question.setQuiz(quiz);
            }
            
            return valid;
        }

    

    @FXML
    void submitQuiz(ActionEvent event) {
        boolean flag = addQuestions();
        if(flag){
            flag = quiz.save(questions);
            if(flag){
                
              
                Quiztitle.setDisable(false);
                Alert alert=new Alert(AlertType.INFORMATION ,"Questions Adedd Successfully", ButtonType.CLOSE);
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alert.show();
                
 
            }else{
                Alert alert=new Alert(AlertType.INFORMATION ,"Questions Adedd Successfully", ButtonType.CLOSE);
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alert.show();
                
               
            }
        }
       }
    

    

    private boolean validateFields(){
        
        
        if(quiz==null){
            {
                Alert alert=new Alert(AlertType.ERROR ,"Please Enter All Field", ButtonType.CLOSE);
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alert.show();
                
            }
           return false;
        }
        String qu = this.question.getText();
        String op1 = this.option1.getText();
        String op2 = this.option2.getText();
        String op3 = this.option3.getText();
        String op4 = this.option4.getText();
        Toggle selectedRadio = radioGroup.getSelectedToggle();
        if(qu.trim().isEmpty() || 
                op1.trim().isEmpty() || 
                op2.trim().isEmpty() || op3.trim().isEmpty()
                || op4.trim().isEmpty()){            
                    {
                        Alert alert=new Alert(AlertType.ERROR ,"Please Enter All Field", ButtonType.NEXT);
                        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                        alert.show();
                    }
           return false;
        }else{
            if(selectedRadio == null){
                {
                    Alert alert=new Alert(AlertType.ERROR ,"Please Enter All Field", ButtonType.NEXT);
                    alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    alert.show();
                }
                return false;
            }else{
                return true;   // save Quistion and add next 
            }
        }
    }

    
}
  
    


