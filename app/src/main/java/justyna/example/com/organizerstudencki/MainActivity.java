package justyna.example.com.organizerstudencki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadImageButtons();
    }

    private void loadImageButtons(){
        ImageButton subjects = (ImageButton) findViewById(R.id.subjects_imageButton);
        ImageButton agenda = (ImageButton) findViewById(R.id.agenda_imageButton);
        ImageButton tasks = (ImageButton) findViewById(R.id.tasks_imageButton);
        ImageButton lecturers = (ImageButton) findViewById(R.id.lecturers_imageButton);

        subjectSetListener(subjects);
        agendaSetListener(agenda);
        tasksSetListener(tasks);
        lecturersSetListener(lecturers);

    }

    private void subjectSetListener(ImageButton subject){
        subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SubjectsActivity.class));
            }
        });
    }

    private void agendaSetListener(ImageButton agenda){
        agenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void tasksSetListener(ImageButton tasks){
        tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void lecturersSetListener(ImageButton lecturers){
        lecturers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
