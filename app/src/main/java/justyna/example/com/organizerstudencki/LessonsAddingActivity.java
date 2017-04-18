package justyna.example.com.organizerstudencki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import justyna.example.com.organizerstudencki.DB.DBHelper;
import justyna.example.com.organizerstudencki.DB.LectureDAO;
import justyna.example.com.organizerstudencki.DB.RoomDAO;
import justyna.example.com.organizerstudencki.DB.SubjectsDBDAO;
import justyna.example.com.organizerstudencki.SubjectsOption.LectureLesson;
import justyna.example.com.organizerstudencki.SubjectsOption.Lessons;
import justyna.example.com.organizerstudencki.SubjectsOption.Room;

public class LessonsAddingActivity extends AppCompatActivity {
      private static int typeLessonIterator=0;
    private static final String TAG="LessonsAddingActivity";
    private RoomDAO roomDAO;
    private LectureDAO lectureDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons_adding);


        roomDAO = new RoomDAO(getApplicationContext());
        lectureDAO=new LectureDAO(getApplicationContext());
        typeOfLesson();

    }

    private void typeOfLesson(){
        ArrayList<Integer> typesNumber = getIntent().getExtras().getIntegerArrayList("which_lessons");

        assert typesNumber != null;
        Log.i(TAG, typesNumber.toString());
        if(typesNumber.get(typeLessonIterator)==0) setTitle("Wyklaady");
        if(typesNumber.get(typeLessonIterator)==1) setTitle("Cwiczenia");
        if(typesNumber.get(typeLessonIterator)==2) setTitle("Laboratoria");
        boolean stay = false;
        if((typesNumber.size()-1)!=typeLessonIterator) stay =true;

        loadContent(stay);
    }
    private void loadContent(boolean stay){
        EditText teacherNameEditText = (EditText) findViewById(R.id.teacherEditText);
        Spinner daySpinner =(Spinner) findViewById(R.id.day_of_week_spinner);
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
        Button okButton = (Button) findViewById(R.id.lessonsOKbutton);
        EditText roomEditText = (EditText) findViewById(R.id.roomNumber_editText);
        EditText durationEditText = (EditText) findViewById(R.id.duration_editText);
        setOkButtonOnclick(okButton, teacherNameEditText, roomEditText, durationEditText, daySpinner,
                timePicker, stay);
    }

    private void setOkButtonOnclick(Button button, final EditText teacherET, final EditText roomET,
                                    final EditText durationET, final Spinner dayS, final TimePicker timePicker, final boolean stay){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(teacherET.getText().toString().equals("")| roomET.getText().toString().equals("")|
                        durationET.getText().toString().equals(""))
                    Toast.makeText(LessonsAddingActivity.this, "Coś nie zostało podane", Toast.LENGTH_SHORT).show();
                else{
                    /**
                     * zapis do bazy tu ma być !!!
                     */

                    /**db.addRoom(new Room(roomET.getText().toString()));
                    List<Room> rooms = db. getAllRooms();
                    Log.d(TAG, String.valueOf(rooms.size()));
                    for(Room r: rooms) Log.d(TAG, r.getNumber());

                     delete it, it was only for test about problems with DB*/

                Room r=new Room(roomET.getText().toString());
                    Log.i(TAG, String.valueOf(r.getId()));
                    roomDAO.save(r);

                    LectureLesson lectureLesson=new LectureLesson();
                   // List<LectureLesson> ls = lectureDAO. getLectureLessons();
                  //  r.setId(ls.size()+1);
                    lectureLesson.setTeacher(teacherET.getText().toString()); lectureLesson.setRoom(r);
                    lectureDAO.save(lectureLesson);
                    List<LectureLesson> ls = lectureDAO. getLectureLessons();

                 //  ls = lectureDAO. getLectureLessons();
                 // for(LectureLesson lesson: ls) Log.d(TAG, lesson.getTeacher()+" "+lesson.getRoom().getNumber());


                    Log.i(TAG, teacherET.getText().toString()+" "+roomET.getText().toString()+" "+
                    durationET.getText().toString()+ " ");

                    if(stay){
                        typeLessonIterator++;
                        Intent refresh = getIntent();
                        finish();
                        startActivity(refresh);
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        typeLessonIterator=0;
    }
}
