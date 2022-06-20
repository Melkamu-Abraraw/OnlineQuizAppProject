package Model;
public class Teacher {
    private String ID;
    private String FirstName;
    private String LastName;
    private String Department;
    public Teacher(String iD, String firstName, String lastName, String department) {
        ID = iD;
        FirstName = firstName;
        LastName = lastName;
        Department = department;
    }
    public String getID() {
        return ID;
    }
    public void setID(String iD) {
        ID = iD;
    }
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public String getDepartment() {
        return Department;
    }
    public void setDepartment(String department) {
        Department = department;
    }
    
 
}
