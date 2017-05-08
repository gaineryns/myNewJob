package steve.gaineryns.mynewjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button newbtn = (Button) findViewById(R.id.newBtn);

        newbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent Jobintent = new Intent(MainActivity.this, Main2Activity.class);

                startActivity(Jobintent);
            }
        });

        Spinner spinner = (Spinner)findViewById(R.id.statusSpn);
        ArrayAdapter<String> adapt;
        final List<String> list;

        list = new ArrayList<String>();
        list.add("Status 1");
        list.add("Status 2");
        list.add("Status 3");
        list.add("Status 4");
        list.add("Status 5");

        adapt = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapt);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(), "Item selected" + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        GridView gridView = (GridView) findViewById(R.id.gridview1);

        String[] itemGrid = new String[]{
                "A", "B", "C", "D", "E",
                "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O",
                "P", "Q", "R", "S", "T"
        };

        ArrayAdapter<String> adaptGrid = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, itemGrid);

        gridView.setAdapter(adaptGrid);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }



}
