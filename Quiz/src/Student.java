public class Student{

    private String ID;
    private String FirstName;
    private String LastName;
    private String Department;
    
    public Student(String ID,String firstName, String lastName, String department) {
      this.ID=ID;
      FirstName=firstName;
      LastName=lastName;
      Department=department;
      
    }
   

    public String getID() {
      return ID;
    }

    public void setID(String iD) {
      this.ID = iD;
    }

    public String getFirstName() {
      return FirstName;
    }

    public void setFirstName(String firstName) {
      this.FirstName = firstName;
    }

    public String getLastName() {
      return LastName;
    }

    public void setLastName(String lastName) {
      this.LastName = lastName;
    }

    public String getDepartment() {
      return Department;
    }

    public void setDepartment(String department) {
      this.Department = department;
    }
 
    
    
    
   
    
     }