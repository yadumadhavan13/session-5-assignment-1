package com.example.y.search;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etuserinput;
    Button buttonsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etuserinput = (EditText) findViewById(R.id.et_userinput);
        buttonsearch = (Button) findViewById(R.id.button_search);
        buttonsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userinput = etuserinput.getText().toString();
                if (userinput==null){
                    Log.e("MainActivity","userinput is null");
                    etuserinput.setError("Enter a search ");
                    Toast.makeText(MainActivity.this,"input field null", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY, userinput);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "serach result", Toast.LENGTH_SHORT).show();
                    Log.e("MainActivity", "" + userinput);
                }
            }
        });
    }
}
