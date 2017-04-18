package justyna.example.com.organizerstudencki.SubjectsOption;


public class Room {
    private int id;
    private String number;

    public Room() {
    }

    public Room(String number) {
        this.number = number;
    }

    public Room(int id, String number) {
        this.id = id;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
