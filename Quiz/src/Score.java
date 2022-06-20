public class Score {
   private String Title;
   private Integer result;
public Score(String title, Integer result) {
   Title=title;
   this.result=result;
}
public Integer getResult() {
    return result;
}
public void setResult(Integer result) {
    this.result = result;
}
public String getTitle() {
    return Title;
}
public void setTitle(String title) {
    this.Title = title;
}


}
