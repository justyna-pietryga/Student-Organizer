package justyna.example.com.organizerstudencki.SubjectsOption;


import java.util.ArrayList;

public class Subject {

    private int id;
    private String nazwa;
    private ArrayList<Lessons> lessons;

    public Subject(int id, String nazwa, ArrayList<Lessons> lessons) {
        this.id = id;
        this.nazwa = nazwa;
        this.lessons = lessons;
    }

    public Subject(String nazwa, ArrayList<Lessons> lessons) {
        this.nazwa = nazwa;
        this.lessons = lessons;
    }

    public Subject() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public ArrayList<Lessons> getLessons() {
        return lessons;
    }

    public void setLessons(ArrayList<Lessons> lessons) {
        this.lessons = lessons;
    }




}
