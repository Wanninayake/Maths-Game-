package com.example.user.game;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.user.game.MainActivity.checked;
import static com.example.user.game.R.id.time;
import static com.example.user.game.R.id.timer;

public class Game extends AppCompatActivity {

    private Button btn1, btn2, btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnDel,btnHash,btnMin;
    private TextView prob,message,Timer;
    private EditText answ;
    static int count=0,answcounter=0,attemptcounter=1,remaintime=0,points=0;
    static int dLevel;
    private String problem="",answer="";
    ArrayList<String> rNum = new ArrayList<String>();
    static String[] str = new String[]{"+", "-", "/", "*"};
    static CountDownTimer time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn0 = (Button) findViewById(R.id.btn0);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnHash = (Button) findViewById(R.id.btnHash);
        btnMin = (Button) findViewById(R.id.btnMin);
        prob = (TextView) findViewById(R.id.prob);
        answ = (EditText) findViewById(R.id.answ);
        message = (TextView) findViewById(R.id.message);
        Timer = (TextView) findViewById(timer);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
          dLevel = getIntent().getIntExtra("dLevel", 0);
        }

        btnHash.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (count <10) {
                    switch (dLevel) {
                        case 1:
                            setmessages();
                            if (answcounter != 1 || attemptcounter == 5) {
                                attemptcounter = 1;
                                answ.setText("");
                                problem = Integer.toString(RandomNum());
                                problem += str[new Random().nextInt(str.length)];
                                problem += Integer.toString(RandomNum());
                                prob.setText(problem);
                                count = ++count;
                                timer();
                                time.cancel();
                                time.start();
                            }

                            break;
                        case 2:
                            setmessages();
                            if (answcounter != 1 || attemptcounter == 5) {
                                attemptcounter = 1;
                                answ.setText("");
                                problem = Integer.toString(RandomNum());
                                problem += str[new Random().nextInt(str.length)];
                                problem += Integer.toString(RandomNum());
                                rNum.add(0, problem);
                                problem += str[new Random().nextInt(str.length)];
                                problem += Integer.toString(RandomNum());
                                rNum.add(1, problem);
                                problem = rNum.get(new Random().nextInt(rNum.size()));
                                prob.setText(problem);
                                count = ++count;
                                timer();
                                time.cancel();
                                time.start();
                            }
                            break;
                        case 3:
                            setmessages();
                            if (answcounter != 1 || attemptcounter == 5) {
                                attemptcounter = 1;
                                answ.setText("");
                                problem = Integer.toString(RandomNum());
                                problem += str[new Random().nextInt(str.length)];
                                problem += Integer.toString(RandomNum());
                                rNum.add(0, problem);
                                problem += str[new Random().nextInt(str.length)];
                                problem += Integer.toString(RandomNum());
                                rNum.add(1, problem);
                                problem += str[new Random().nextInt(str.length)];
                                problem += Integer.toString(RandomNum());
                                rNum.add(2, problem);
                                problem = rNum.get(new Random().nextInt(rNum.size()));
                                prob.setText(problem);
                                count = ++count;
                                timer();
                                time.cancel();
                                time.start();
                            }
                            break;
                        case 4:
                            setmessages();
                            if (answcounter != 1 || attemptcounter == 5) {
                                attemptcounter = 1;
                                answ.setText("");
                                problem = Integer.toString(RandomNum());
                                problem += str[new Random().nextInt(str.length)];
                                problem += Integer.toString(RandomNum());
                                rNum.add(0, problem);
                                problem += str[new Random().nextInt(str.length)];
                                problem += Integer.toString(RandomNum());
                                rNum.add(1, problem);
                                problem += str[new Random().nextInt(str.length)];
                                problem += Integer.toString(RandomNum());
                                rNum.add(2, problem);
                                problem += str[new Random().nextInt(str.length)];
                                problem += Integer.toString(RandomNum());
                                rNum.add(3, problem);
                                problem += str[new Random().nextInt(str.length)];
                                problem += Integer.toString(RandomNum());
                                rNum.add(4, problem);
                                problem = rNum.get(new Random().nextInt(rNum.size()));
                                prob.setText(problem);
                                count = ++count;
                                timer();
                                time.cancel();
                                time.start();
                            }
                            break;
                    }
                }else {
                    new AlertDialog.Builder(Game.this)
                            .setTitle("Score")
                            .setMessage("Your Score is = "+points)
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // continue with delete
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                    points=0;
                    count = 0;
                    prob.setText("Press # to start !!");
                    answ.setText("");
                    problem="";
                    answer="";

                }
            }
        });
        btnMin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Answer("-");
            }
            });
        btnDel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                answ.setText("");
                answer="";
            }
        });


        btn0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Answer("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Answer("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Answer("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Answer("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Answer("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Answer("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Answer("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Answer("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Answer("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Answer("9");
            }
        });

    }
    public int RandomNum (){
        int randomNum = ThreadLocalRandom.current().nextInt(0, 100 + 1);
        return randomNum;
    }

    public void Answer(String num){
        answer += (num);
        answ.setText(answer);
    }

    public static String min (String problem){
        return problem.replaceAll("-","+-");
    }

    private int solveProblem(String prob) {
        prob.replace("-","+");
        String[] toAdd=prob.split("\\+");

        double finalResult=0.0;

        for(String exp:toAdd){
            String byMultiply[]=exp.split("\\*");
            double multiplyResult=1.0;

            for (String divideThingy:byMultiply){
                if(divideThingy.contains("/")){
                    String toDivide[]=divideThingy.split("/");
                    double number=Double.parseDouble(toDivide[0]);
                    for(int i=1;i<toDivide.length;i++){
                        number/=Double.parseDouble(toDivide[i]);
                    }

                    multiplyResult*=number;
                }else {
                    multiplyResult*=Double.parseDouble(divideThingy);
                }
            }

            finalResult+=multiplyResult;

        }
        return ((int)Math.round(finalResult));
    }

    public void setmessages(){
        if (problem.equals("")) {
            message.setText("");
        }else if(answer.equals("")){
            answcounter=1;
            message.setText("Enter the answer");
            ((TextView)findViewById(R.id.message)).setTextColor(Color.BLACK);
            message.postDelayed(new Runnable() {
                public void run() {
                    message.setText("");
                }
            }, 3000);
        }else if (isCorrect(answer,solveProblem(min(problem)))){
            message.setText("CORRECT !");
            points=points+100/(10-remaintime);
            answ.setText("");
            answer="";
            answcounter=0;
            ((TextView)findViewById(R.id.message)).setTextColor(Color.GREEN);
            message.postDelayed(new Runnable() {
                public void run() {
                    message.setText("");
                }
            }, 1000);
        }else {
            answcounter=1;
            message.setText("WRONG !!!");
            ((TextView)findViewById(R.id.message)).setTextColor(Color.RED);
            message.postDelayed(new Runnable() {
                public void run() {
                    message.setText("");
                }
            }, 1000);
            if (attemptcounter <4 && checked) {
                if (isgreater(answer, solveProblem(min(problem)))) {
                    message.postDelayed(new Runnable() {
                        public void run() {
                            message.setText("Less");
                            ((TextView) findViewById(R.id.message)).setTextColor(Color.BLACK);
                        }
                    }, 1000);
                } else if (isless(answer, solveProblem(min(problem)))) {
                    message.postDelayed(new Runnable() {
                        public void run() {
                            message.setText("Greater");
                            ((TextView) findViewById(R.id.message)).setTextColor(Color.BLACK);
                        }
                    }, 1000);
                }
                message.postDelayed(new Runnable() {
                    public void run() {
                        answ.setText("");
                        message.setText("Attempt " + attemptcounter);
                        ((TextView) findViewById(R.id.message)).setTextColor(Color.BLACK);
                    }
                }, 3000);
            }else {
                answcounter=0;
            }
            attemptcounter++;
            answer="";
        }
    }

    private void timer(){
        time =new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                Timer.setText("seconds remaining: " + millisUntilFinished / 1000);
                remaintime=(int) millisUntilFinished/1000;
            }
            public void onFinish() {
                Timer.setText("done!");
                //this.start();
                if (count <10) {
                    switch (dLevel) {
                        case 1:
                            setmessages();
                            if (answcounter != 1 || attemptcounter == 5) {
                                attemptcounter = 1;
                                answ.setText("");
                                problem = Integer.toString(RandomNum());
                                problem += str[new Random().nextInt(str.length)];
                                problem += Integer.toString(RandomNum());
                                prob.setText(problem);
                                count = ++count;
                                timer();
                                time.cancel();
                                time.start();
                            }

                            break;
                        case 2:
                            setmessages();
                            if (answcounter != 1 || attemptcounter == 5) {
                                attemptcounter = 1;
                                answ.setText("");
                                problem = Integer.toString(RandomNum());
                                problem += str[new Random().nextInt(str.length)];
                                problem += Integer.toString(RandomNum());
                                rNum.add(0, problem);
                                problem += str[new Random().nextInt(str.length)];
                                problem += Integer.toString(RandomNum());
                                rNum.add(1, problem);
                                problem = rNum.get(new Random().nextInt(rNum.size()));
                                prob.setText(problem);
                                count = ++count;
                                timer();
                                time.cancel();
                                time.start();
                            }
                            break;
                        case 3:
                            setmessages();
                            if (answcounter != 1 || attemptcounter == 5) {
                                attemptcounter = 1;
                                answ.setText("");
                                problem = Integer.toString(RandomNum());
                                problem += str[new Random().nextInt(str.length)];
                                problem += Integer.toString(RandomNum());
                                rNum.add(0, problem);
                                problem += str[new Random().nextInt(str.length)];
                                problem += Integer.toString(RandomNum());
                                rNum.add(1, problem);
                                problem += str[new Random().nextInt(str.length)];
                                problem += Integer.toString(RandomNum());
                                rNum.add(2, problem);
                                problem = rNum.get(new Random().nextInt(rNum.size()));
                                prob.setText(problem);
                                count = ++count;
                                timer();
                                time.cancel();
                                time.start();
                            }
                            break;
                        case 4:
                            setmessages();
                            if (answcounter != 1 || attemptcounter == 5) {
                                attemptcounter = 1;
                                answ.setText("");
                                problem = Integer.toString(RandomNum());
                                problem += str[new Random().nextInt(str.length)];
                                problem += Integer.toString(RandomNum());
                                rNum.add(0, problem);
                                problem += str[new Random().nextInt(str.length)];
                                problem += Integer.toString(RandomNum());
                                rNum.add(1, problem);
                                problem += str[new Random().nextInt(str.length)];
                                problem += Integer.toString(RandomNum());
                                rNum.add(2, problem);
                                problem += str[new Random().nextInt(str.length)];
                                problem += Integer.toString(RandomNum());
                                rNum.add(3, problem);
                                problem += str[new Random().nextInt(str.length)];
                                problem += Integer.toString(RandomNum());
                                rNum.add(4, problem);
                                problem = rNum.get(new Random().nextInt(rNum.size()));
                                prob.setText(problem);
                                count = ++count;
                                timer();
                                time.cancel();
                                time.start();
                            }
                            break;
                    }
                }else {
                    new AlertDialog.Builder(Game.this)
                            .setTitle("Score")
                            .setMessage("Your Score is = "+points)
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // continue with delete
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                    points=0;
                    count = 0;
                    prob.setText("Press # to start !!");
                    answ.setText("");
                    problem="";
                    answer="";

                }
            }

        };

    }

    private boolean isCorrect(String answer,int solution){
        return (Integer.parseInt(answer)==solution);
    }

    private boolean isgreater(String answer,int solution){
        return (Integer.parseInt(answer)  >  solution);
    }

    private boolean isless(String answer,int solution){
        return (Integer.parseInt(answer)  <  solution);
    }


}
