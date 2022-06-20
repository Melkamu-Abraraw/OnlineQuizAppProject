package Model;
import java.sql.PreparedStatement;

import db.dbConnection;

public class Questions extends dbConnection{

        public Quiz quiz;
        private Integer questionId;
        private String question="try";
        private String option1;
        private String option2;
        private String option3;
        private String option4;
        private String answer;
    
      
        public Questions(Quiz quiz, String question, String option1, String option2, String option3, String option4, String answer) {
            this.quiz = quiz;
            //this.question = question;
            this.option1 = option1;
            this.option2 = option2;
            this.option3 = option3;
            this.option4 = option4;
            this.answer = answer;
        }
    
        public Questions() {
        }

        @Override
        public String toString() {
            return this.question;
        }
    
        // Getter Setters
        public Quiz getQuiz() {
            return quiz;
        }
    
        public Integer getQuestionId() {
            return questionId;
        }
    
        public String getQuestion() {
            return question;
        }
    
        public String getOption1() {
            return option1;
        }
    
        public String getOption2() {
            return option2;
        }
    
        public String getOption3() {
            return option3;
        }
    
        public String getOption4() {
            return option4;
        }
    
        public String getAnswer() {
            return answer;
        }
    
        public void setQuiz(Quiz quiz) {
            this.quiz = quiz;
        }
    
        public void setQuestionId(Integer questionId) {
            this.questionId = questionId;
        }
    
        public void setQuestion(String question) {
            this.question = question;
        }
    
        public void setOption1(String option1) {
            this.option1 = option1;
        }
    
        public void setOption2(String option2) {
            this.option2 = option2;
        }
    
        public void setOption3(String option3) {
            this.option3 = option3;
        }
    
        public void setOption4(String option4) {
            this.option4 = option4;
        }
    
        public void setAnswer(String answer) {
            this.answer = answer;
        }
    
 
    boolean save(){
        db.dbConnection.dbConnect();
        boolean flag = false;
        String query = "INSERT INTO Questions (Question,option1,option2,option3,option4,Answer,qid) VALUES (? , ? ,? , ? , ? , ? , ?)";
        try  {
            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, this.question);
            ps.setString(2, this.option1);
            ps.setString(3, this.option2);
            ps.setString(4, this.option3);
            ps.setString(5, this.option4);
            ps.setString(6, this.answer);
            ps.setInt(7, this.quiz.getQuizId());
            flag = true;
           // int i  = ps.executeUpdate();

           
        }
           
        
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
        return flag;
    }
}

