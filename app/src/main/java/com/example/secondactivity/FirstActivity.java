package com.example.secondactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button btnGoTo2nd = (Button) findViewById(R.id.btnGoTo2nd);
        btnGoTo2nd.setOnClickListener(this); // calling onClick() method
        Button btnDialog = (Button) findViewById(R.id.btnDialog);
        btnDialog.setOnClickListener(this); // calling onClick() method
    }

    @Override
    public void onClick(View view){
        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        switch (view.getId()){
            case R.id.btnGoTo2nd:
                toast.setText("Go to second");
                toast.show();
                switchActivities();
                break;
            case R.id.btnDialog:
                toast.setText("Show dialog");
                toast.show();
                break;
        }

        }

    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, SecondActivity.class);
        startActivity(switchActivityIntent);
    }

}