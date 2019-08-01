package sg.edu.rp.c346.demodynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner spn1;
    Spinner spn2;
    Button btnUpdate;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.buttonUpdate);
        //initialize the arraylist
        alNumbers= new ArrayList<>();
        //create an ArrayAdapter  using the default  Spinner layout and the arraylist
        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);
        //Bind the ArrayAdapter to the spinner, Save changes
        spn2.setAdapter(aaNumbers);
        //Approach 1
//        alNumbers.add("2");
//        alNumbers.add("4");
//        alNumbers.add("6");

        //Approach 2
        String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
        //Convert Array to List and add to the ArrayList
        alNumbers.addAll(Arrays.asList(strNumbers));

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear();

                if (pos==0) {
                    String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                }else {
                    String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                }
            }
        });

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0:
                        alNumbers.clear();
                        String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                        alNumbers.addAll(Arrays.asList(strNumbers));
                        spn2.setSelection(2);
                        break;
                    case 1:
                        alNumbers.clear();
                        String[] strNumbers1 = getResources().getStringArray(R.array.odd_numbers);
                        alNumbers.addAll(Arrays.asList(strNumbers1));
                        spn2.setSelection(1);
                        break;
                }
                aaNumbers.notifyDataSetChanged();
            }
            public void onNothingSelected(AdapterView<?> parent ) {
            }
        });
    }
}