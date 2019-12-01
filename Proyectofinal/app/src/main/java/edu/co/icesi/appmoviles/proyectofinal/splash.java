package edu.co.icesi.appmoviles.proyectofinal;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


                    public class splash extends AppCompatActivity {

                        TextView izi;
                        @Override
                        protected void onCreate(Bundle savedInstanceState) {
                            super.onCreate(savedInstanceState);
                            setContentView(R.layout.splash_layout);

                            izi = findViewById(R.id.textView6);

                            Animation my = AnimationUtils.loadAnimation(this,R.anim.mytransition);

                            izi.startAnimation(my);
                            final Intent intent = new Intent(splash.this, MainActivity.class);


                            Thread time = new Thread(){
                                public void run() {
                                    try {
                                        sleep(3000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    finally {
                                        startActivity(intent);
                                        finish();

                                    }
                                }
                            };
                            time.start();





                        }

                    }