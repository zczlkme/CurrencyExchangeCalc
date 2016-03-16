package com.example.hsport.currencyexchangecalculator;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
// for pounds input
import android.widget.EditText;
import android.widget.TextView;
import android.text.Editable;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.NumberFormat; //for currency formatting
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final NumberFormat currencyFormat = NumberFormat. getCurrencyInstance();
    ArrayList<Double> rateArray = new ArrayList<>();
    ArrayList<URL> urlArray = new ArrayList<>();

    private double USDrate = 1.433;
    private double EURrate = 1.290;
    private double RMBrate = 9.313;
    private double JPYrate = 162.728;
    private double CADrate = 1.904;
    private double AUDrate = 1.906;
    private double SGDrate = 1.972;

    private double USD;
    private double EUR;
    private double CNY;
    private double JPY;
    private double CAD;
    private double AUD;
    private double SGD;

    private double Pounds;

    private TextView USDTextView;
    private TextView EUROTextView;
    private TextView RMBTextView;
    private TextView YENTextView;
    private TextView CADTextView;
    private TextView AUDTextView;
    private TextView SGDTextView;
    private TextView Amountofpounds;

    private final String usd_url = "http://download.finance.yahoo.com/d/quotes.csv?s=GBPUSD=X&f=sl1d1t1ba&e=.csv";
    private final String eur_url = "http://download.finance.yahoo.com/d/quotes.csv?s=GBPEUR=X&f=sl1d1t1ba&e=.csv";
    private final String rmb_url = "http://download.finance.yahoo.com/d/quotes.csv?s=GBPCNY=X&f=sl1d1t1ba&e=.csv";
    private final String jpy_url = "http://download.finance.yahoo.com/d/quotes.csv?s=GBPJPY=X&f=sl1d1t1ba&e=.csv";
    private final String cad_url = "http://download.finance.yahoo.com/d/quotes.csv?s=GBPCAD=X&f=sl1d1t1ba&e=.csv";
    private final String aud_url = "http://download.finance.yahoo.com/d/quotes.csv?s=GBPAUD=X&f=sl1d1t1ba&e=.csv";
    private final String sgd_url = "http://download.finance.yahoo.com/d/quotes.csv?s=GBPSGD=X&f=sl1d1t1ba&e=.csv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rateArray.add(USDrate);
        rateArray.add(EURrate);
        rateArray.add(RMBrate);
        rateArray.add(JPYrate);
        rateArray.add(CADrate);
        rateArray.add(AUDrate);
        rateArray.add(SGDrate);

        EditText nameText = (EditText) findViewById(R.id.nameText);
        nameText.addTextChangedListener(amountEditTextWatcher);

        Amountofpounds =(TextView) findViewById(R.id.view0);

        new GetOnlineRate().execute();

    }

    class GetOnlineRate extends AsyncTask<String, Void, Void> {

        protected Void doInBackground(String... urls) {
            try {
                urlArray.add(new URL(usd_url));
                urlArray.add(new URL(eur_url));
                urlArray.add(new URL(rmb_url));
                urlArray.add(new URL(jpy_url));
                urlArray.add(new URL(cad_url));
                urlArray.add(new URL(aud_url));
                urlArray.add(new URL(sgd_url));

                for (int i = 0; i < urlArray.size(); i++) {
                    HttpURLConnection urlConnection = (HttpURLConnection) urlArray.get(i).openConnection();
                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    String result = reader.readLine();
                    rateArray.set(i, Double.valueOf(result.substring(result.indexOf(',') + 1, result.indexOf(',') + 7)));
//                    System.out.println(i + "th rate is: " + rateArray.get(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void startChild(View view)
    {
        startActivity(new Intent(this, CurrencyTrend.class));
    }


    private void calculate() {

        USD = rateArray.get(0) * Pounds;
        EUR = rateArray.get(1) * Pounds;
        CNY = rateArray.get(2) * Pounds;
        JPY = rateArray.get(3) * Pounds;
        CAD = rateArray.get(4) * Pounds;
        AUD = rateArray.get(5) * Pounds;
        SGD = rateArray.get(6) * Pounds;


        USDTextView = (TextView) findViewById(R.id.value1);
        USDTextView.setText(currencyFormat.format(USD));

        EUROTextView = (TextView) findViewById(R.id.value2);
        EUROTextView.setText(currencyFormat.format(EUR));

        RMBTextView = (TextView) findViewById(R.id.value3);
        RMBTextView.setText(currencyFormat.format(CNY));

        YENTextView = (TextView) findViewById(R.id.value4);
        YENTextView.setText(currencyFormat.format(JPY));

        CADTextView = (TextView) findViewById(R.id.value5);
        CADTextView.setText(currencyFormat.format(CAD));

        AUDTextView = (TextView) findViewById(R.id.value6);
        AUDTextView.setText(currencyFormat.format(AUD));

        SGDTextView = (TextView) findViewById(R.id.value7);
        SGDTextView.setText(currencyFormat.format(SGD));

    }


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



    private final TextWatcher amountEditTextWatcher = new TextWatcher() {

        @Override

        public void onTextChanged(CharSequence s, int start, int before, int count){

            try{

                //get the currency data
                Pounds=Double.parseDouble(s.toString())/100.0;

                /*display the format in textview view0.*/
                Amountofpounds.setText(currencyFormat.format(Pounds));
            }
            catch(NumberFormatException e) {

               /* if the curreny is not a numble; pounds=0;*/
                Amountofpounds.setText("");
                Pounds = 0.0;
            }
            calculate();
        }

    @Override
    public void afterTextChanged(Editable s) { }

    @Override
    public void beforeTextChanged(
            CharSequence s, int start, int count, int after) { }
};


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

