package com.example.hsport.currencyexchangecalculator;

import android.media.AudioRecord;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
// for pounds input
import android.widget.EditText;
import android.widget.TextView;
import android.text.Editable;

import java.text.NumberFormat; //for currency formatting

public class MainActivity extends AppCompatActivity {

    private static final NumberFormat currencyFormat = NumberFormat. getCurrencyInstance();

    private double USDrate = 1.433;
    private double EUROrate = 9.313;
    private double RMBrate = 1.290;
    private double YENrate = 162.728;
    private double CADrate = 1.904;
    private double AUDrate = 1.906;
    private double SGDrate = 1.972;

    private double USD;
    private double EURO;
    private double RMB;
    private double YEN;
    private double CAD;
    private double AUD;
    private double SGD;

    private double Pounds=0.0;


    private TextView USDTextView;
    private TextView EUROTextView;
    private TextView RMBTextView;
    private TextView YENTextView;
    private TextView CADTextView;
    private TextView AUDTextView;
    private TextView SGDTextView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        USD= USDrate*Pounds;
        EURO = EUROrate*Pounds;
        RMB = RMBrate*Pounds;
        YEN = YENrate*Pounds;
        CAD = CADrate*Pounds;
        AUD = AUDrate*Pounds;
        SGD =SGDrate*Pounds;


        EditText nameText=(EditText) findViewById(R.id.nameText);
        nameText.addTextChangedListener(amountEditTextWatcher);



        USDTextView = (TextView) findViewById(R.id.value1);

        USDTextView.setText(currencyFormat.format(USD));


        EUROTextView = (TextView) findViewById(R.id.value2);

        EUROTextView.setText(currencyFormat.format(EURO));


        RMBTextView= (TextView) findViewById(R.id.value3);

        RMBTextView.setText(currencyFormat.format(RMB));


        YENTextView = (TextView) findViewById(R.id.value4);

        YENTextView.setText(currencyFormat.format(YEN));


        CADTextView = (TextView) findViewById(R.id.value5);

        CADTextView.setText(currencyFormat.format(CAD));


        AUDTextView = (TextView) findViewById(R.id.value6);

        AUDTextView.setText(currencyFormat.format(AUD));


        SGDTextView = (TextView) findViewById(R.id.value7);

        SGDTextView.setText(currencyFormat.format(SGD));


/*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }



    private final TextWatcher amountEditTextWatcher = new TextWatcher() {

        @Override

    public void onTextChanged(CharSequence s, int start, int before, int count){

            /* TextView Amountofpounds;
            Amountofpounds =(TextView) findViewById(R.id.view0); */

            try{

                //get the currency data
                Pounds=Double.parseDouble(s.toString())/100.0;

                /*display the format in textview view0.
                Amountofpounds.setText(""); */
            }
            catch(NumberFormatException e) {

                /* if the curreny is not a numble; pounds=0;
                Amountofpounds.setText(""); */
                Pounds = 0.0;

            }
        }

    @Override
    public void afterTextChanged(Editable s) { }

    @Override
    public void beforeTextChanged(
            CharSequence s, int start, int count, int after) { }
};



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
