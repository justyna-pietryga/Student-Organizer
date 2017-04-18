package justyna.example.com.organizerstudencki;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

public class SubjectsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);
        setTitle(R.string.przedmioty);
        loadContent();
    }

    private void loadContent(){
        ImageButton addSubjectButton = (ImageButton) findViewById(R.id.addImageButton);
        ListView subjectsListView = (ListView) findViewById(R.id.subjectListView);

        setAddButtonListener(addSubjectButton);

    }

    private void setAddButtonListener(ImageButton addSubjectButton){
        addSubjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SubjectsActivity.this, AddingSubjectActivity.class));
            }
        });
    }

}
