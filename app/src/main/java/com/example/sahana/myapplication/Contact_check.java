package com.example.sahana.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sahana on 19-04-2018.
 */
public class Contact_check extends Activity implements AdapterView.OnItemSelectedListener {
    public int setMax = 0;
    Button submit;
    EditText phone_number;
    TextView text;
    int maxLength= 10;
    private String blockCharacterSet = "() / N~,*;#+.-";
    private static final String[]paths = {"India", "USA", "Germany" , "Austria" ,"Saint Helena", "Bangladesh"};
    private InputFilter filter = new InputFilter() {

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

            if (source != null && blockCharacterSet.contains(("" + source))) {
                return "";
            }
            return null;
        }
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_check);
        phone_number =((EditText)findViewById(R.id.editText));
        text = ((TextView)findViewById(R.id.Text));
        submit = (Button) findViewById(R.id.button2);
        Spinner Spin = ((Spinner)findViewById(R.id.spinner));
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(Contact_check.this,
                android.R.layout.simple_spinner_item,paths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spin.setAdapter(adapter);
        Spin.setOnItemSelectedListener(this);



        }

    public void onClick(View view){
       // Toast.makeText(getApplicationContext(),"CLICKED BUTTON",Toast.LENGTH_SHORT).show();
        if((phone_number).getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Enter phone number",Toast.LENGTH_SHORT).show();
        }
        if((phone_number).getText().toString().length()==maxLength){
            Toast.makeText(getApplicationContext(),"Phone number is correct for the selected country",Toast.LENGTH_SHORT).show();
        }
        if((phone_number).getText().toString().length()!=maxLength){
            Toast.makeText(getApplicationContext(),"Phone number incorrect for the selected country",Toast.LENGTH_SHORT).show();
        }

    }
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                text.setText("+91");
                maxLength = 10;
                phone_number.setFilters(new InputFilter[] { filter , new InputFilter.LengthFilter(maxLength)});
                break;
            case 1:
                text.setText("+1");
                maxLength = 10;
                phone_number.setFilters(new InputFilter[] {filter,new InputFilter.LengthFilter(maxLength)});
                break;
            case 2:
                text.setText("+49");
                maxLength = 11;
                phone_number.setFilters(new InputFilter[] {filter , new InputFilter.LengthFilter(maxLength)});
                break;

            case 3:
                text.setText("+43");
                maxLength = 13;
                phone_number.setFilters(new InputFilter[] {filter , new InputFilter.LengthFilter(maxLength)});
                break;
            case 4:
                text.setText("+290");
                maxLength = 04;
                phone_number.setFilters(new InputFilter[] {filter , new InputFilter.LengthFilter(maxLength)});
                break;
            case 5:
                text.setText("+880");
                maxLength = 10;
                phone_number.setFilters(new InputFilter[] {filter ,new InputFilter.LengthFilter(maxLength)});
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(getApplicationContext(),"Select one country",Toast.LENGTH_SHORT).show();

    }


}


