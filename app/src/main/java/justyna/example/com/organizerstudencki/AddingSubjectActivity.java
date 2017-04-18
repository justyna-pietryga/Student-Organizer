package justyna.example.com.organizerstudencki;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddingSubjectActivity extends AppCompatActivity {
    private static String TAG="AddingSubjectActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "on create");
        setContentView(R.layout.activity_adding_subject);
        setTitle(R.string.adding_subject_title);

        loadContent();
    }

    private void loadContent(){
        EditText subjectTextView = (EditText) findViewById(R.id.subjectName_editText);
        CheckBox[] checkBoxes = new CheckBox[3];
        checkBoxes[0]= (CheckBox) findViewById(R.id.lessonLecture_checkBox);
        checkBoxes[1]= (CheckBox) findViewById(R.id.lesson_exercise_checkBox);
        checkBoxes[2]= (CheckBox) findViewById(R.id.lessonLaboratoryCheckBox);
        ArrayList<Integer> list = new ArrayList<>();
        Button nextButton = (Button) findViewById(R.id.next_button);

        setNextOnClick(nextButton, checkBoxes, subjectTextView, list);

    }

    private void setNextOnClick(Button button, final CheckBox[]checkBoxes, final EditText editText, final ArrayList<Integer> list){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!checkBoxes[0].isChecked()&!checkBoxes[1].isChecked()&!checkBoxes[2].isChecked())
                    Toast.makeText(AddingSubjectActivity.this, "Nic nie zostalo zaznaczone", Toast.LENGTH_SHORT).show();
                else if(editText.getText().toString().equals("")) Toast.makeText(AddingSubjectActivity.this, "Nie podano nazwy przedmiotu", Toast.LENGTH_SHORT).show();

                else {
                    for(int i=0; i< checkBoxes.length; i++) if(checkBoxes[i].isChecked()) list.add(i);
                    Intent intent = new Intent(AddingSubjectActivity.this, LessonsAddingActivity.class);
                    intent.putExtra("which_lessons", list);
                    intent.putExtra("subject_name", editText.getText().toString());
                    startActivity(intent);

                }
            }
        });
    }



}
