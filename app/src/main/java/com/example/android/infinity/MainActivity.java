package com.example.android.infinity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Boolean.FALSE;


public class MainActivity extends AppCompatActivity {
    int number;
    Button Color;
    TextView Stone;
    TextView textView1;
    TextView textView;
    String retrieved;
    int pos;
    final int first = 0;
    ArrayList<String> stones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = (TextView) findViewById(R.id.stonelist);
        Color= (Button) findViewById(R.id.colorstone);
        Stone= (TextView) findViewById(R.id.namestone);
        loadData();
        treasure();
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
        if(num==0) {
            if (stones.contains("POWER STONE") == FALSE) {
                stones.add("POWER STONE");
                saveData();
            }
            Color.setBackgroundColor(getResources().getColor(R.color.purple));
            Stone.setText("POWER STONE");
            checkfull();
        } else if (num == 1)
        {
            if (stones.contains("SPACE STONE") == FALSE) {
                stones.add("SPACE STONE");
                saveData();

            }
            Color.setBackgroundColor(getResources().getColor(R.color.blue));
            Stone.setText("SPACE STONE");
            checkfull();

        } else if (num == 2)
        {
            if (stones.contains("TIME STONE") == FALSE) {
                stones.add("TIME STONE");
                saveData();


            }
            Color.setBackgroundColor(getResources().getColor(R.color.green));
            Stone.setText("TIME STONE");
            checkfull();
        } else if (num == 3)
        {
            if (stones.contains("REALITY STONE") == FALSE) {
                stones.add("REALITY STONE");
                saveData();

            }
            Color.setBackgroundColor(getResources().getColor(R.color.red));
            Stone.setText("REALITY STONE");
            checkfull();

        } else if (num == 4)
        {
            if (stones.contains("SOUL STONE") == FALSE) {
                stones.add("SOUL STONE");
                saveData();

            }
            Color.setBackgroundColor(getResources().getColor(R.color.orange));
            Stone.setText("SOUL STONE");
            checkfull();

        } else if (num == 5)
        {
            if (stones.contains("MIND STONE") == FALSE) {
                stones.add("MIND STONE");
                saveData();

            }
            Color.setBackgroundColor(getResources().getColor(R.color.yellow));
            Stone.setText("MIND STONE");
            checkfull();
        }

    }

    public void checkfull() {
        if(stones.contains("MIND STONE")&& stones.contains("SOUL STONE") && stones.contains("REALITY STONE")&&
                stones.contains("TIME STONE") && stones.contains("SPACE STONE") && stones.contains("POWER STONE")) {
            TextView textView1 = (TextView) findViewById(R.id.stonelist);
            textView1.setText("");
            stones.clear();
            saveData();
            Intent finalIntent = new Intent(MainActivity.this, FinishActivity.class);
            startActivity(finalIntent);
            stones.clear();
        } else
            treasure();


    }

    public void reset(View view) {
        stones.clear();
        saveData();
        Color.setBackgroundColor(getResources().getColor(R.color.gray));
        Stone.setText("");
        textView1.setText("YOU HAVE NOTHING!");

    }

    public void treasure() {
        TextView textView1 = (TextView) findViewById(R.id.stonelist);
        String temp;
        if (stones.isEmpty())
            textView1.setText("YOU HAVE NOTHING!");
        else {
            int n = stones.size();
            temp = "YOU HAVE WITH YOU: \n";
            for (int i = 0; i < n; i++)
                temp += stones.get(i) + "\n";
            textView1.setText(temp);
        }

    }


    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(stones);
        editor.putString("task list", json);
        editor.apply();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();
        stones = gson.fromJson(json, type);
        if (stones == null) {
            stones = new ArrayList<>();
        }

    }






}
