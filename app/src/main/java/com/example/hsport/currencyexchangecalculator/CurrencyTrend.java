package com.example.hsport.currencyexchangecalculator;
//usd
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;

public class CurrencyTrend extends AppCompatActivity {
    private Spinner spinner_from;
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







        }
    }

