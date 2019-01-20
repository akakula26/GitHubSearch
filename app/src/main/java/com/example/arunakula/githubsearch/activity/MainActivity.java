package com.example.arunakula.githubsearch.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.arunakula.githubsearch.R;

public class MainActivity extends AppCompatActivity {

    public EditText githubSearch;
    public Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        githubSearch =  (EditText) findViewById(R.id.searchgithub);
        search = (Button)findViewById(R.id.search);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(MainActivity.this, SearchActivity.class);
                intent.putExtra("key",githubSearch.getText().toString());
                startActivity(intent);
            }
        });
    }
}
