package deansoffice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {
    private static int indexCounter = 1;

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;
    private Date birthdate;
    private String indexNumber;
    private String status;
    private Studies studies;
    private int currentSemester;
    private List<Grade> grades;

    public Student(String firstName, String lastName, String email, String address, String phoneNumber, Date birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birthdate = birthdate;
        this.indexNumber = "s" + indexCounter++;
        this.status = "Candidate";
        this.grades = new ArrayList<>();
    }

    public void enrollStudent(Studies studies) {
        this.studies = studies;
        this.currentSemester = 1;
        this.status = "Student";
    }

    public void addGrade(int grade, String subject) {
        grades.add(new Grade(grade, subject));
    }

    public void promoteToNextSemester() {
        if (currentSemester < studies.getTotalSemesters() && !exceededAllowedITNs()) {
            currentSemester++;
        } else {
            status = "Graduate";
        }
    }

    private boolean exceededAllowedITNs() {
        long itnCount = grades.stream().filter(g -> g.getGrade() < 3).count();
        return itnCount > studies.getMaxAllowedITNs();
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public int getCurrentSemester() {
        return currentSemester;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("Student: %s %s, Index: %s, Semester: %d, Status: %s", firstName, lastName, indexNumber, currentSemester, status);
    }
}
