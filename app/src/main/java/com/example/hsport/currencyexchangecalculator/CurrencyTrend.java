package com.example.hsport.currencyexchangecalculator;
//usd
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;

import java.util.ArrayList;

public class CurrencyTrend extends AppCompatActivity {

    double rate1 = 1.425;
    double rate2 = 1.423;
    double rate3 = 1.423;
    double rate4 = 1.418;
    double rate5 = 1.417;
    private TextView maxview;
    ArrayList<Double> rateArray = new ArrayList<>();
    ArrayList<String> timeArray = new ArrayList<>();
    double max_rate = 0;
    String max_month ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_trend);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



            GraphView line_graph = (GraphView) findViewById(R.id.graph);
            LineGraphSeries<DataPoint> line_series =
                    new LineGraphSeries<DataPoint>(new DataPoint[]{
                            new DataPoint(0, 7.5),
                            new DataPoint(1, 6.5),
                            new DataPoint(2, 6.5),
                            new DataPoint(3, 4),
                            new DataPoint(4, 3.5),

                    });

            line_graph.addSeries(line_series);
            line_series.setDrawDataPoints(true);
            line_series.setDataPointsRadius(5);
            StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(line_graph);
            staticLabelsFormatter.setHorizontalLabels(new String[]{ "Mar 21","22","23"});
            staticLabelsFormatter.setVerticalLabels(new String[]{"1.41", "1.42", "1.43"});
            line_graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);





        new findRate().execute();

        }



    class findRate extends AsyncTask<String, Void, Void> {

        protected Void doInBackground(String... urls) {
            try {
                rateArray.add(rate1);
                rateArray.add(rate2);
                rateArray.add(rate3);
                rateArray.add(rate4);
                rateArray.add(rate5);

                timeArray.add("Mar 21");
                timeArray.add("Mar 21 noon");
                timeArray.add("Mar 22");
                timeArray.add("Mar 22 noon");
                timeArray.add("Mar 23");


                for (int i = 0; i < rateArray.size(); i++) {
                    if (rateArray.get(i) > max_rate) {
                        max_rate = rateArray.get(i);
                        max_month = timeArray.get(i);

                    }

                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        maxview = (TextView) findViewById(R.id.trend1);
                        maxview.setText("The max rate is " + max_rate + " happend at " + max_month);
                    }
                });

            }catch (Exception e) {
                e.printStackTrace();
            }


            return  null;
        }
    }

}

