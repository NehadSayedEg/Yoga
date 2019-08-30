package com.nehad.android.yoga;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import io.paperdb.Paper;

public class ExerciseViewActivity extends AppCompatActivity {

    String  image_id ;
    String name ;
    TextView timer , title;
    ImageView image_position;
    Button start_btn ;
    boolean isRunning = false ;
       RelativeLayout relativeLayout ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_view);

        timer =(TextView)findViewById(R.id.timer);
        title =(TextView)findViewById(R.id.exercise_title);
        image_position =(ImageView)findViewById(R.id.position_detial);


        Paper.init(this);
        relativeLayout = findViewById(R.id.poseView);

        Intent intent = getIntent();
        image_id = intent.getStringExtra("image_id");
        Picasso.get().load(image_id).into(image_position);


        name = intent.getStringExtra("name");
        title.setText(name);




        timer.setText(" ");

        start_btn =(Button)findViewById(R.id.start_btn);
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(! isRunning){
                    start_btn.setText("DONE");

                    new CountDownTimer(30000 ,1000){

                        @Override
                        public void onTick(long l) {
                            timer.setText(" "+l/1000);

                        }

                        @Override
                        public void onFinish() {
                            Toast.makeText(ExerciseViewActivity.this ,"Finish !!!", Toast.LENGTH_LONG ).show();

                            finish();
                        }
                    }.start();

                }
                else {
                    Toast.makeText(ExerciseViewActivity.this ,"Finish !!!", Toast.LENGTH_LONG ).show();

                    finish();

                }
                isRunning =!isRunning ;

            }
        });




    }
}
