package com.example.hsport.currencyexchangecalculator;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;


public class Rate extends AppCompatActivity {

    public Button btusd ;
    public Button bteur ;
    public Button btcny ;
    public Button btjpy ;
    public Button btcad ;
    public Button btaud ;
    public Button btsgd ;

    private static final NumberFormat DecimalFormat = NumberFormat. getNumberInstance();


    ArrayList<Double> rateArray = new ArrayList<>();
    ArrayList<URL> urlArray = new ArrayList<>();

    private double USDrate = 1.43;
    private double EURrate = 1.29;
    private double RMBrate = 9.31;
    private double JPYrate = 162.73;
    private double CADrate = 1.91;
    private double AUDrate = 1.91;
    private double SGDrate = 1.97;



    private TextView USDrateView;
    private TextView EURrateView;
    private TextView CNYrateView;
    private TextView JPYrateView;
    private TextView CADrateView;
    private TextView AUDrateView;
    private TextView SGDrateView;

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
        setContentView(R.layout.activity_rate);

        rateArray.add(USDrate);
        rateArray.add(EURrate);
        rateArray.add(RMBrate);
        rateArray.add(JPYrate);
        rateArray.add(CADrate);
        rateArray.add(AUDrate);
        rateArray.add(SGDrate);

        rate();

        new GetOnlineRate().execute();
        btusd = (Button) findViewById(R.id.buttonusd);
        btusd.setOnClickListener(new ButtonListener1());

        bteur = (Button) findViewById(R.id.buttoneur);
        bteur.setOnClickListener(new ButtonListener2());

        btcny = (Button) findViewById(R.id.buttoncny);
        btcny.setOnClickListener(new ButtonListener3());

        btjpy = (Button) findViewById(R.id.buttonjpy);
        btjpy.setOnClickListener(new ButtonListener4());

        btcad = (Button) findViewById(R.id.buttoncad);
        btcad.setOnClickListener(new ButtonListener5());

        btaud = (Button) findViewById(R.id.buttonaud);
        btaud.setOnClickListener(new ButtonListener6());

        btsgd = (Button) findViewById(R.id.buttonsgd);
        btsgd.setOnClickListener(new ButtonListener7());
    }


    class ButtonListener1 implements View.OnClickListener {
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(Rate.this, CurrencyTrend.class);
            Rate.this.startActivity(intent);


        }
    }
    class ButtonListener2 implements View.OnClickListener {
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(Rate.this, CurrencyTrend1.class);
            Rate.this.startActivity(intent);


        }
    }
    class ButtonListener3 implements View.OnClickListener {
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(Rate.this, CurrencyTrend2.class);
            Rate.this.startActivity(intent);


        }
    }

    class ButtonListener4 implements View.OnClickListener {
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(Rate.this, CurrencyTrend3.class);
            Rate.this.startActivity(intent);


        }
    }

    class ButtonListener5 implements View.OnClickListener {
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(Rate.this, CurrencyTrend4.class);
            Rate.this.startActivity(intent);


        }
    }
    class ButtonListener6 implements View.OnClickListener {
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(Rate.this, CurrencyTrend5.class);
            Rate.this.startActivity(intent);


        }
    }
    class ButtonListener7 implements View.OnClickListener {
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(Rate.this, CurrencyTrend6.class);
            Rate.this.startActivity(intent);


        }
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
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rate();
                    }
                });


            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;

        }

    }


    private  void  rate(){


        USDrateView = (TextView) findViewById(R.id.rate1);
        USDrateView.setText(DecimalFormat.format(rateArray.get(0)));


        EURrateView = (TextView) findViewById(R.id.rate2);
        EURrateView.setText(DecimalFormat.format(rateArray.get(1)));


        CNYrateView = (TextView) findViewById(R.id.rate3);
        CNYrateView.setText(DecimalFormat.format(rateArray.get(2)));


        JPYrateView = (TextView) findViewById(R.id.rate4);
        JPYrateView.setText(DecimalFormat.format(rateArray.get(3)));


        CADrateView = (TextView) findViewById(R.id.rate5);
        CADrateView.setText(DecimalFormat.format(rateArray.get(4)));


        AUDrateView = (TextView) findViewById(R.id.rate6);
        AUDrateView.setText(DecimalFormat.format(rateArray.get(5)));


        SGDrateView = (TextView) findViewById(R.id.rate7);
        SGDrateView.setText(DecimalFormat.format(rateArray.get(6)));

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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}

