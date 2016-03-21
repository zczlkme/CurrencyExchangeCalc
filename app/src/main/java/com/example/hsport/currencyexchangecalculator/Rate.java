package com.example.hsport.currencyexchangecalculator;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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


    private static final NumberFormat DecimalFormat = NumberFormat. getNumberInstance();


    ArrayList<Double> rateArray = new ArrayList<>();
    ArrayList<URL> urlArray = new ArrayList<>();

    private double USDrate= 1.43;
    private double EURrate= 1.29;
    private double RMBrate= 9.31;
    private double JPYrate= 162.73;
    private double CADrate= 1.91;
    private double AUDrate= 1.91;
    private double SGDrate= 1.97;




    private TextView Amountofpounds;

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


        new GetOnlineRate().execute();
        rate();

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


            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;

        }

    }



    private  void  rate() {


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





}

