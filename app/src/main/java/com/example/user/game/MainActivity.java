package com.example.user.game;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private Button btnabout, btnexit, btnnewgame, btncon;
    private Switch btnHint;
    public static boolean checked;

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnabout = (Button) findViewById(R.id.btnabout);
        btnexit = (Button) findViewById(R.id.btnexit);
        btnnewgame = (Button)findViewById(R.id.btnnewame);
        btncon = (Button)findViewById(R.id.btncon);
        btnHint = (Switch) findViewById(R.id.btnHint);

        if (!isPreviousDataAvailable()) {
            btncon.setEnabled(false);
        } else {
            btncon.setEnabled(true);
        }


        btnHint.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checked=true;
                }else {
                    checked=false;
                }

            }
        });

        btnabout.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("About")
                        .setMessage("This is a basic Brain Training Game that improve your mathematical knowledge." +"\n"+
                                "Game rules :-" +"\n"+
                                " 1) 10 arithmetic expressions will be displayed"+"\n"+"   for each level." +"\n"+
                                " 2) if hint button is ON you can have 4" +"\n"+ "  attempts for each question." +"\n"+
                                " 3) Each question time is 10 seconds")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });

        btnexit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

        btnnewgame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CharSequence[] levels = new CharSequence[]{"Novice", "Easy", "Medium", "Guru"};

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select Difficulty");


                builder.setItems(levels, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                openGameWindowForNew(1);
                                break;
                            case 1:
                                openGameWindowForNew(2);
                                break;
                            case 2:
                                openGameWindowForNew(3);
                                break;
                            case 3:
                                openGameWindowForNew(4);
                                break;

                        }
                    }
                }).show();
            }
        });

        btncon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                continueGameWindow();
            }
        });
    }

    private void openGameWindowForNew(int dLevel) {
        Intent intent=new Intent(MainActivity.this, Game.class);
        intent.putExtra("dLevel",dLevel);

        SaveGame.getSharedPreferences(getBaseContext()).edit().clear().apply();

        startActivity(intent);

    }

    private void continueGameWindow(){
        startActivity(new Intent(this,Game.class));
    }

    private boolean isPreviousDataAvailable() {
        return SaveGame.getSharedPreferences(getBaseContext()).contains("nOQ");
    }

}

