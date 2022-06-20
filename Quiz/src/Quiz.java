
import java.sql.*;
import java.util.*;

import javafx.animation.SequentialTransition;

public class Quiz extends dbConnection{
    // Properties

    private Integer quizId;
    private String title;

    // Constructers
    public Quiz(String title) {
        this.title = title;
    }

    public static class MetaData {

        public static final String TABLE_NAME = "Quiz";
        public static final String QUIZ_ID = "quizID";
        static final String TITLe = "Title";
    }

    public Quiz() {
    }

    // Getter Setters
    public Integer getQuizId() {
        return quizId;
    }

    public String getTitle() {

        return title;
    }
   
    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }
  
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
    // get questions Using Quiz
    public List<Question> getQuestions() {
        List<Question> quizes = new ArrayList<>();

        String query = String.format("SELECT %s , %s , %s , %s ,%s , %s , %s\n" +
                "FROM %s  where %s = ?",
                Question.MetaData.QUESTION_ID,
                Question.MetaData.QUESTION,
                Question.MetaData.OPTION1,
                Question.MetaData.OPTION2,
                Question.MetaData.OPTION3,
                Question.MetaData.OPTION4,
                Question.MetaData.ANSWER,
                Question.MetaData.TABLE_NAME,
                Question.MetaData.QUIZ_ID
        );
        
        try {
            this.setTitle("A");
    this.setQuizId(1);
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, this.quizId);
                ResultSet result = ps.executeQuery();
                while (result.next()) {
                    Question tempQuestion = new Question();
                    tempQuestion.setQuestionId(result.getInt(1));
                    tempQuestion.setQuestion(result.getString(2));
                    tempQuestion.setOption1(result.getString(3));
                    tempQuestion.setOption2(result.getString(4));
                    tempQuestion.setOption3(result.getString(5));
                    tempQuestion.setOption4(result.getString(6));
                    tempQuestion.setAnswer(result.getString(7));
                    tempQuestion.setQuiz(this);
                    quizes.add(tempQuestion);
                }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return quizes;
    }
}
