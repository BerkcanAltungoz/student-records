
public class tablecontents {

private String name;
private String surname;
private long studentID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public tablecontents(String name, String surname, long studentID) {
        this.name = name;
        this.surname = surname;
        this.studentID = studentID;
    }




}
