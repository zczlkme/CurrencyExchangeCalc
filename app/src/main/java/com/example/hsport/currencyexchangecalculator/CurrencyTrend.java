package com.example.hsport.currencyexchangecalculator;

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


        spinner_from = (Spinner) findViewById(R.id.spinner_from);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currency_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_from.setAdapter(adapter);

        if(spinner_from.getSelectedItem().toString().equals("USD")){

            GraphView line_graph = (GraphView) findViewById(R.id.graph);
            LineGraphSeries<DataPoint> line_series =
                    new LineGraphSeries<DataPoint>(new DataPoint[]{
                            new DataPoint(0, 1),
                            new DataPoint(1, 5),
                            new DataPoint(2, 3),
                            new DataPoint(3, 2),
                            new DataPoint(4, 6)
                    });

            line_graph.addSeries(line_series);
            line_series.setDrawDataPoints(true);
            line_series.setDataPointsRadius(10);
            StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(line_graph);
            staticLabelsFormatter.setHorizontalLabels(new String[]{"Jan", "Feb", "March"});
            staticLabelsFormatter.setVerticalLabels(new String[]{"$1", "$2", "$3"});
            line_graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
            line_series.setOnDataPointTapListener(new OnDataPointTapListener() {
                @Override
                public void onTap(Series series, DataPointInterface dataPoint) {
                    Toast.makeText(CurrencyTrend.this, "Series: On Data Point clicked: " + dataPoint, Toast.LENGTH_SHORT).show();
                }
            });

            if(spinner_from.getSelectedItem().toString().equals("EURO")){
                line_graph = (GraphView) findViewById(R.id.graph);
                line_series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                        new DataPoint(0, 1),
                        new DataPoint(1, 2),
                        new DataPoint(2, 3),
                        new DataPoint(3, 2),
                        new DataPoint(4, 6)
                });

                line_graph.addSeries(line_series);
                line_series.setDrawDataPoints(true);
                line_series.setDataPointsRadius(10);
                staticLabelsFormatter = new StaticLabelsFormatter(line_graph);
                staticLabelsFormatter.setHorizontalLabels(new String[]{"Jan", "Feb", "March"});
                staticLabelsFormatter.setVerticalLabels(new String[]{"$1", "$2", "$3"});
                line_graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
                line_series.setOnDataPointTapListener(new OnDataPointTapListener() {
                    @Override
                    public void onTap(Series series, DataPointInterface dataPoint) {
                        Toast.makeText(CurrencyTrend.this, "Series: On Data Point clicked: " + dataPoint, Toast.LENGTH_SHORT).show();
                    }
                });


            }

        }
    }
}
