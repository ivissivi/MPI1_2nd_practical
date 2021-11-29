package com.example.secondactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener{

    AlertDialog.Builder builder;

    private static final String[] group_members = new String[] {
            "Ivars Sloka", "Alvils Glušonoks", "Kārlis Puriņš"
    };

    private boolean[] clicked_members = new boolean[group_members.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button btnGoTo2nd = (Button) findViewById(R.id.btnGoTo2nd);
        btnGoTo2nd.setOnClickListener(this); // calling onClick() method
        Button btnDialog = (Button) findViewById(R.id.btnDialog);
        btnDialog.setOnClickListener(this); // calling onClick() method
        builder = new AlertDialog.Builder (this);

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
                builder.setTitle("Select group members:")
                        .setMultiChoiceItems(group_members, clicked_members, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                    clicked_members[which] = isChecked;
                                    if (!isChecked) {
                                        String getCBName = group_members[which];
                                        toast.setText(getCBName + " checked");
                                        toast.show();
                                    }
                                        else if (isChecked) {    String getCBName = group_members[which];
                                        toast.setText(getCBName + " unchecked");
                                        toast.show();
                                }
                 }
            });
                        builder.setCancelable(true)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                toast.setText("You clicked OK");
                                toast.show();
                            }
                        });
                        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                toast.setText("You closed dialog");
                                toast.show();
                                dialog.cancel();
                            }
                        });
                        builder.show();
                break;
        }
    }

    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, SecondActivity.class);
        startActivity(switchActivityIntent);
    }
}