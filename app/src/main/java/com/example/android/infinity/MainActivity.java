package com.example.android.infinity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Boolean.FALSE;


public class MainActivity extends AppCompatActivity {
    int number;
    Button Color;
    TextView Stone;
    TextView textView;
    String retrieved;
    int pos;
    ArrayList<String> stones = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Color= (Button) findViewById(R.id.colorstone);
        Stone= (TextView) findViewById(R.id.namestone);
        final Button stonegen = (Button) findViewById(R.id.random);
        stonegen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                number = (r.nextInt(6) + 0);
                stonealloc(number);


            }
        });
    }

    public void stonealloc(int num)
    {
        if(num==0)
        {   if(stones.contains("POWER STONE")== FALSE)
            stones.add("POWER STONE");
            Color.setBackgroundColor(getResources().getColor(R.color.purple));
            Stone.setText("POWER STONE");
            textView=(TextView) findViewById(R.id.power);
            textView.setText("POWER STONE");
            checkfull();
        }
        if(num==1)
        {
            if(stones.contains("SPACE STONE")== FALSE)
            stones.add("SPACE STONE");
            Color.setBackgroundColor(getResources().getColor(R.color.blue));
            Stone.setText("SPACE STONE");
            textView=(TextView) findViewById(R.id.space);
            textView.setText("SPACE STONE");
            checkfull();

        }
        if(num==2)
        {
            if(stones.contains("TIME STONE")== FALSE)
            stones.add("TIME STONE");
            Color.setBackgroundColor(getResources().getColor(R.color.green));
            Stone.setText("TIME STONE");
            textView=(TextView) findViewById(R.id.time);
            textView.setText("TIME STONE");
            checkfull();
        }
        if(num==3)
        {
            if(stones.contains("REALITY STONE")== FALSE)
            stones.add("REALITY STONE");
            Color.setBackgroundColor(getResources().getColor(R.color.red));
            Stone.setText("REALITY STONE");
            textView=(TextView) findViewById(R.id.reality);
            textView.setText("REALITY STONE");
            checkfull();

        }
        if(num==4)
        {
            if(stones.contains("SOUL STONE")== FALSE)
            stones.add("SOUL STONE");
            Color.setBackgroundColor(getResources().getColor(R.color.orange));
            Stone.setText("SOUL STONE");
            textView=(TextView) findViewById(R.id.soul);
            textView.setText("SOUL STONE");
            checkfull();

        }
        if(num==5)
        {
            if(stones.contains("MIND STONE")== FALSE)
            stones.add("MIND STONE");
            Color.setBackgroundColor(getResources().getColor(R.color.yellow));
            Stone.setText("MIND STONE");
            textView=(TextView) findViewById(R.id.mind);
            textView.setText("MIND STONE");
            checkfull();
        }

    }
    public void checkfull()
    {
        if(stones.contains("MIND STONE")&& stones.contains("SOUL STONE") && stones.contains("REALITY STONE")&&
                stones.contains("TIME STONE")&& stones.contains("SPACE STONE")&& stones.contains("POWER STONE"))
        {
            stones.clear();
            textView=(TextView) findViewById(R.id.soul);
            textView.setText("");
            textView=(TextView) findViewById(R.id.power);
            textView.setText("");
            textView=(TextView) findViewById(R.id.time);
            textView.setText("");
            textView=(TextView) findViewById(R.id.reality);
            textView.setText("");
            textView.setText("");
            textView=(TextView) findViewById(R.id.mind);
            textView.setText("");
            textView=(TextView) findViewById(R.id.space);
            textView.setText("");
            Intent finalIntent = new Intent(MainActivity.this, FinishActivity.class);
            startActivity(finalIntent);
        }


    }
}
