package com.xusl98.lolapp;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SearchActivity extends AppCompatActivity {

    private Button btnSpy;
    private TextInputLayout input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        btnSpy = (Button) findViewById(R.id.btn_spy);
        input = (TextInputLayout) findViewById(R.id.input);

        btnSpy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SearchActivity.this, MainActivity.class);
                String summonerName = input.getEditText().getText().toString();
                i.putExtra("summonerName", summonerName);
                startActivity(i);
            }
        });
    }
}
