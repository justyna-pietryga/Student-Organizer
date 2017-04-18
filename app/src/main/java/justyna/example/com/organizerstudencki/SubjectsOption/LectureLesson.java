package justyna.example.com.organizerstudencki.SubjectsOption;


public class LectureLesson extends Lessons {

    private int id;
    private String teacher;
    private Room room;

    public LectureLesson() {
    }

    public LectureLesson(String teacher, Room room, int id) {
        this.teacher = teacher;
        this.room = room;
        this.id = id;
    }

    public LectureLesson(String teacher, Room room) {
        this.teacher = teacher;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }


    public Room getRoom() {
        return room;
    }


    public void setRoom(Room room) {
        this.room = room;
    }
}
