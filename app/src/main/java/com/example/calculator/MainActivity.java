package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,ba,bs,bm,bd,be,b_dot,bsm,c,c1;
    TextView t1,t2,t3;
    char ch;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b0 = findViewById(R.id.buttonzero);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        ba = findViewById(R.id.buttonplus);
        bs = findViewById(R.id.buttonminus);
        bm = findViewById(R.id.buttonmult);
        bd = findViewById(R.id.buttondiv);
        be = findViewById(R.id.buttonequal);
        c  = findViewById(R.id.buttonc2);
        c1 = findViewById(R.id.buttonc1);
        b_dot = findViewById(R.id.buttondot);
        t2 = findViewById(R.id.textView2);
        t1 = findViewById(R.id.textView1);
        bsm = findViewById(R.id.buttonsm);
        t3 = findViewById(R.id.textView);

        c.setOnClickListener(v -> {
            t1.setText("");
            t2.setText("");
            t3.setText("");
        });
        c1.setOnClickListener(v -> {
            if(!t1.getText().toString().isEmpty())
                t1.setText(t1.getText().toString().substring(0,t1.getText().toString().length()-1));
        });
        b0.setOnClickListener(v -> t1.setText(t1.getText() + "0"));
        b1.setOnClickListener(v -> t1.setText(t1.getText() + "1"));
        b2.setOnClickListener(v -> t1.setText(t1.getText() + "2"));
        b3.setOnClickListener(v -> t1.setText(t1.getText() + "3"));
        b4.setOnClickListener(v -> t1.setText(t1.getText() + "4"));
        b5.setOnClickListener(v -> t1.setText(t1.getText() + "5"));
        b6.setOnClickListener(v -> t1.setText(t1.getText() + "6"));
        b7.setOnClickListener(v -> t1.setText(t1.getText() + "7"));
        b8.setOnClickListener(v -> t1.setText(t1.getText() + "8"));
        b9.setOnClickListener(v -> t1.setText(t1.getText() + "9"));
        b_dot.setOnClickListener(v -> {
            if (t1.getText().toString().isEmpty())
                t1.setText("0.");
            else if(t1.getText().toString().equals("-"))
                t1.setText("-0.");
            else if(!(t1.getText().toString().contains(".")))
                t1.setText(t1.getText() + ".");
        });
        bsm.setOnClickListener(v -> {
            if(t1.getText().toString().isEmpty())
                t1.setText("-");
        });
        ba.setOnClickListener(v -> {
            if(t1.getText().toString().isEmpty() && t2.getText().toString().isEmpty())
                t1.setText(t1.getText());
            else {
                if (t1.getText().toString().equals("-"))
                    t1.setText("-");
                else if (t1.getText().toString().equals("-0.") || t1.getText().toString().equals("0."))
                    t1.setText(t1.getText());
                else if (!t1.getText().toString().isEmpty() && t2.getText().toString().isEmpty()) {
                    t2.setText(t1.getText());
                    t1.setText("");
                    ch = '+';
                } else if (t1.getText().toString().isEmpty() && !t2.getText().toString().isEmpty()) {
                    ch = '+';
                } else {
                    if (!t1.getText().toString().contains(".") && !t2.getText().toString().contains(".")) {
                        int a = Integer.parseInt(t1.getText().toString()), b = Integer.parseInt(t2.getText().toString());
                        if (ch == '+')
                            t2.setText(Integer.toString((a + b)));
                        else if (ch == '-')
                            t2.setText(Integer.toString((b - a)));
                        else if (ch == '*')
                            t2.setText(Integer.toString((a * b)));
                        else {
                            if (a == 0) {
                                Toast.makeText(MainActivity.this, "Can not divide by 0", Toast.LENGTH_SHORT).show();
                            } else if (b % a == 0)
                                t2.setText(Integer.toString((b / a)));
                            else
                                t2.setText(Float.toString((float) b / (float) a));
                        }
                    } else {
                        float a = Float.parseFloat(t1.getText().toString()), b = Float.parseFloat(t2.getText().toString());
                        if (ch == '+')
                            t2.setText(Float.toString((a + b)));
                        else if (ch == '-')
                            t2.setText(Float.toString((b - a)));
                        else if (ch == '*')
                            t2.setText(Float.toString((a * b)));
                        else {
                            if (a == 0) {
                                Toast.makeText(MainActivity.this, "Can not divide by 0", Toast.LENGTH_SHORT).show();
                            } else if (b % a == 0)
                                t2.setText(Integer.toString((int)(b / a)));
                            else
                                t2.setText(Float.toString((b / a)));
                        }
                    }
                    t1.setText("");
                    ch = '+';
                }
                t3.setText("" + ch);
            }
        });
        bs.setOnClickListener(v -> {
            if(t1.getText().toString().isEmpty() && t2.getText().toString().isEmpty())
                t1.setText(t1.getText());
            else {
                if (t1.getText().toString().equals("-"))
                    t1.setText("-");
                else if (t1.getText().toString().equals("-0.") || t1.getText().toString().equals("0."))
                    t1.setText(t1.getText());
                else if (!t1.getText().toString().isEmpty() && t2.getText().toString().isEmpty()) {
                    t2.setText(t1.getText());
                    t1.setText("");
                    ch = '-';
                } else if (t1.getText().toString().isEmpty() && !t2.getText().toString().isEmpty()) {
                    ch = '-';
                } else {
                    if (!t1.getText().toString().contains(".") && !t2.getText().toString().contains(".")) {
                        int a = Integer.parseInt(t1.getText().toString()), b = Integer.parseInt(t2.getText().toString());
                        if (ch == '+')
                            t2.setText(Integer.toString((a + b)));
                        else if (ch == '-')
                            t2.setText(Integer.toString((b - a)));
                        else if (ch == '*')
                            t2.setText(Integer.toString((a * b)));
                        else {
                            if (a == 0)
                                Toast.makeText(MainActivity.this,"Can not divide by 0",Toast.LENGTH_SHORT).show();
                            else if (b % a == 0)
                                t2.setText(Integer.toString((b / a)));
                            else
                                t2.setText(Float.toString((float) b / (float) a));
                        }
                    } else {
                        float a = Float.parseFloat(t1.getText().toString()), b = Float.parseFloat(t2.getText().toString());
                        if (ch == '+')
                            t2.setText(Float.toString((a + b)));
                        else if (ch == '-')
                            t2.setText(Float.toString((b - a)));
                        else if (ch == '*')
                            t2.setText(Float.toString((a * b)));
                        else {
                            if (a == 0) {
                                Toast.makeText(MainActivity.this, "Can not divide by 0", Toast.LENGTH_SHORT).show();
                            } else if (b % a == 0)
                                t2.setText(Integer.toString((int)(b / a)));
                            else
                                t2.setText(Float.toString((b / a)));
                        }
                    }
                    t1.setText("");
                    ch = '-';
                }
                t3.setText("" + ch);
            }
        });
        bm.setOnClickListener(v -> {
            if(t1.getText().toString().isEmpty() && t2.getText().toString().isEmpty())
                t1.setText(t1.getText());
            else {
                if (t1.getText().toString().equals("-"))
                    t1.setText("-");
                else if (t1.getText().toString().equals("-0.") || t1.getText().toString().equals("0."))
                    t1.setText(t1.getText());
                else if (!t1.getText().toString().isEmpty() && t2.getText().toString().isEmpty()) {
                    t2.setText(t1.getText());
                    t1.setText("");
                    ch = '*';
                } else if (t1.getText().toString().isEmpty() && !t2.getText().toString().isEmpty()) {
                    ch = '*';
                } else {
                    if (!t1.getText().toString().contains(".") && !t2.getText().toString().contains(".")) {
                        int a = Integer.parseInt(t1.getText().toString()), b = Integer.parseInt(t2.getText().toString());
                        if (ch == '+')
                            t2.setText(Integer.toString((a + b)));
                        else if (ch == '-')
                            t2.setText(Integer.toString((b - a)));
                        else if (ch == '*')
                            t2.setText(Integer.toString((a * b)));
                        else {
                            if (a == 0)
                                Toast.makeText(MainActivity.this, "Can not divide by 0", Toast.LENGTH_SHORT).show();
                            else if (b % a == 0)
                                t2.setText(Integer.toString((b / a)));
                            else
                                t2.setText(Float.toString((float) b / (float) a));
                        }
                    } else {
                        float a = Float.parseFloat(t1.getText().toString()), b = Float.parseFloat(t2.getText().toString());
                        if (ch == '+')
                            t2.setText(Float.toString((a + b)));
                        else if (ch == '-')
                            t2.setText(Float.toString((b - a)));
                        else if (ch == '*')
                            t2.setText(Float.toString((a * b)));
                        else {
                            if (a == 0) {
                                Toast.makeText(MainActivity.this, "Can not divide by 0", Toast.LENGTH_SHORT).show();
                            } else if (b % a == 0)
                                t2.setText(Integer.toString((int)(b / a)));
                            else
                                t2.setText(Float.toString((b / a)));
                        }
                    }
                    t1.setText("");
                    ch = '*';
                }
                t3.setText("" + ch);
            }
        });
        bd.setOnClickListener(v -> {
            if(t1.getText().toString().isEmpty() && t2.getText().toString().isEmpty())
                t1.setText(t1.getText());
            else {
                if (t1.getText().toString().equals("-"))
                    t1.setText("-");
                else if (t1.getText().toString().equals("-0.") || t1.getText().toString().equals("0."))
                    t1.setText(t1.getText());
                else if (!t1.getText().toString().isEmpty() && t2.getText().toString().isEmpty()) {
                    t2.setText(t1.getText());
                    t1.setText("");
                    ch = '/';
                } else if (t1.getText().toString().isEmpty() && !t2.getText().toString().isEmpty()) {
                    ch = '/';
                } else {
                    if (!t1.getText().toString().contains(".") && !t2.getText().toString().contains(".")) {
                        int a = Integer.parseInt(t1.getText().toString()), b = Integer.parseInt(t2.getText().toString());
                        if (ch == '+')
                            t2.setText(Integer.toString((a + b)));
                        else if (ch == '-')
                            t2.setText(Integer.toString((b - a)));
                        else if (ch == '*')
                            t2.setText(Integer.toString((a * b)));
                        else {
                            if (a == 0) {
                                Toast.makeText(MainActivity.this, "Can not divide by 0", Toast.LENGTH_SHORT).show();
                            } else if (b % a == 0)
                                t2.setText(Integer.toString((b / a)));
                            else
                                t2.setText(Float.toString((float) b / (float) a));
                        }
                    } else {
                        float a = Float.parseFloat(t1.getText().toString()), b = Float.parseFloat(t2.getText().toString());
                        if (ch == '+')
                            t2.setText(Float.toString((a + b)));
                        else if (ch == '-')
                            t2.setText(Float.toString((b - a)));
                        else if (ch == '*')
                            t2.setText(Float.toString((a * b)));
                        else {
                            if (a == 0) {
                                Toast.makeText(MainActivity.this, "Can not divide by 0", Toast.LENGTH_SHORT).show();
                            } else if (b % a == 0)
                                t2.setText(Integer.toString((int)(b / a)));
                            else
                                t2.setText(Float.toString((b / a)));
                        }
                    }
                    t1.setText("");
                    ch = '/';
                }
                t3.setText("" + ch);
            }
        });
        be.setOnClickListener(v -> {
            if(!t1.getText().toString().isEmpty() && !t2.getText().toString().isEmpty() && !t1.getText().toString().equals("-") && !t1.getText().toString().equals("-0."))
            {
                if(t1.getText().toString().contains(".") || t2.getText().toString().contains("."))
                {
                    Float a=Float.parseFloat(t1.getText().toString()),b=Float.parseFloat(t2.getText().toString());
                    if(ch=='+')
                        t1.setText(Float.toString(b+a));
                    else if(ch=='-')
                        t1.setText(Float.toString(b-a));
                    else if(ch=='*')
                        t1.setText(Float.toString(b*a));
                    else {
                        if(a==0)
                            Toast.makeText(MainActivity.this,"Can not divide by 0",Toast.LENGTH_SHORT).show();
                        else if(b % a==0)
                            t1.setText(Integer.toString((int)(b/a)));
                        else
                            t1.setText(Float.toString(b/a));
                    }
                }
                else
                {
                    int a=Integer.parseInt(t1.getText().toString()),b=Integer.parseInt(t2.getText().toString());
                    if(ch=='+')
                        t1.setText(Integer.toString((a+b)));
                    else if(ch=='-')
                        t1.setText(Integer.toString((b-a)));
                    else if(ch=='*')
                        t1.setText(Integer.toString((a*b)));
                    else
                    {
                        if(a==0)
                        {
                            Toast.makeText(MainActivity.this,"Can not divide by 0",Toast.LENGTH_SHORT).show();
                        }
                        else if(b%a==0)
                            t1.setText(Integer.toString((b/a)));
                        else
                            t1.setText(Float.toString((float)b/(float)a));
                    }
                }
                t2.setText("");
                t3.setText("");
            }

        });
    }
}