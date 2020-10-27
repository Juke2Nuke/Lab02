package com.example.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView tvMain;
    private TextView tvResult;
    private EditText textInputMain;
    private Button button01;
    private Spinner spinner01;
    Counting cnt = new Counting();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tvMain = findViewById(R.id.tvMain);
        this.textInputMain = findViewById(R.id.textInputMain);
        this.button01 = findViewById(R.id.button01);
        this.spinner01 = findViewById(R.id.spinner01);
        this.tvResult = findViewById(R.id.tvResult);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.mode, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner01.setAdapter(adapter);
        spinner01.setOnItemSelectedListener(this);
    }

    public void btn01OnClick(View view) {


        String check = textInputMain.getText().toString();
        String result;
        String spinnerState = spinner01.getSelectedItem().toString();
        if(check.isEmpty()){
            Toast.makeText(this,"You have no text to count!", Toast.LENGTH_SHORT).show();
        }
        else if(spinnerState.equals("Words") ){
            result = String.valueOf(cnt.wordCounting(check));
            tvResult.setText("Counted words: "+result);
        }
        else if(spinnerState.equals("Symbols")){
            result = String.valueOf(cnt.symbolCounting(check));
            tvResult.setText("Counted symbols: "+result);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}