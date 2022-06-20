package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import db.dbConnection;

public class Quiz extends dbConnection {

    private Integer quizId;
    private String title;

    public Quiz(String title) {
        this.title = title;
    }

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

    public int save() {

        try {
            dbConnect();
            String query = "Insert into Quiz (Title) values (?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, this.title);
            int i = ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                return keys.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }

        return -1;
    }

    public boolean save(List<Questions> questions) {
        boolean flag = true;
        this.quizId = this.save();

        for (Questions q : questions) {
            flag = flag && q.save();

        }
        return flag;

    }
}
