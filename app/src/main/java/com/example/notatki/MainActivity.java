package com.example.notatki;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Note> notesList;
    private NoteAdapter adapter;
    private EditText editTextTitle;
    private EditText editTextContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView = findViewById(R.id.listViewNotes);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextContent = findViewById(R.id.editTextContent);
        Button buttonAdd = findViewById(R.id.buttonAdd);


        notesList = new ArrayList<>();
        notesList.add(new Note("tenis", "Gra z Ewą w poniedziałek"));
        adapter = new NoteAdapter(this, notesList);
        listView.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTextTitle.getText().toString().trim();
                String content = editTextContent.getText().toString().trim();

                if (!title.isEmpty() && !content.isEmpty()) {
                    notesList.add(new Note(title, content));
                    adapter.notifyDataSetChanged();
                    editTextTitle.setText("");
                    editTextContent.setText("");
                }
            }
        });
    }
}