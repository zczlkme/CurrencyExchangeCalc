package com.example.hsport.currencyexchangecalculator;

import android.media.AudioRecord;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {


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


    private TextView USD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


/*
        USD = USDrate*Pounds;
        EURO = EUROrate*Pounds;
        RMB = RMBrate*Pounds;
        YEN = YENrate*Pounds;
        CAD = CADrate*Pounds;
        AUD = AUDrate*Pounds;
        SGD =SGDrate*Pounds;
*/



        EditText nameText=(EditText) findViewById(R.id.nameText);

        String Pounds=nameText.getText().toString();

        TextView ResultView = (TextView) findViewById(R.id.value1);
        ResultView.setText("TOP!");

        

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }






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
