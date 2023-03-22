package co.iam149cm.springboot.bean;

public class Student {
    private int id;
    private String firstName;
    private String lastName;

    public Student(int id, String firstNAme, String lastName) {
        this.id = id;
        this.firstName = firstNAme;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
