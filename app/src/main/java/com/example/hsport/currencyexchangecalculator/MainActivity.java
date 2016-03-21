package com.example.hsport.currencyexchangecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {
    public Button Bt ;
    public Button Bt1 ;
    public Button Bt2 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Bt = (Button) findViewById(R.id.Bt);
        Bt1 = (Button) findViewById(R.id.Bt1);
        Bt2 = (Button) findViewById(R.id.Bt2);
        Bt.setOnClickListener(new ButtonListener1());
        Bt1.setOnClickListener(new ButtonListener2());
        Bt2.setOnClickListener(new ButtonListener3());
    }

    class ButtonListener1 implements View.OnClickListener {
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, Main2Activity.class);
            MainActivity.this.startActivity(intent);

        }
    }



    class ButtonListener2 implements View.OnClickListener {
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, Rate.class);
            MainActivity.this.startActivity(intent);


        }
    }

        class ButtonListener3 implements View.OnClickListener {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, information.class);
                MainActivity.this.startActivity(intent);


            }
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



