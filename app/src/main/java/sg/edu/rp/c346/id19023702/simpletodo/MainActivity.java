package sg.edu.rp.c346.id19023702.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etToDo;
    Button btnAdd, btnClear;
    ListView lvToDo;
    Spinner spnAddDel;

    ArrayList<String> taskList;
    ArrayAdapter<String> aaTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etToDo = findViewById(R.id.editTextToDo);
        btnAdd = findViewById(R.id.buttonAdd);
        btnClear = findViewById(R.id.buttonClear);
        lvToDo = findViewById(R.id.listViewToDo);
        spnAddDel = findViewById(R.id.spinner);

        taskList = new ArrayList<>();
/*        aaTask.add("Red");
        aaTask.add("Orange");*/

        aaTask  = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);

        lvToDo.setAdapter(aaTask);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName = etToDo.getText().toString();
                taskList.add(taskName);
                aaTask.notifyDataSetChanged();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskList.clear();
                aaTask.notifyDataSetChanged();
            }
        });

        spnAddDel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Toast.makeText(MainActivity.this, "Spinner Item, Yes Selected", Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "Spinner Item, Not Selected", Toast.LENGTH_LONG).show();
                        break;
                }
            }

           public void onNothingSelected(AdapterView<?> parent) {}
        });

    }
}