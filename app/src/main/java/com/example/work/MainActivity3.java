package com.example.work;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    ImageView imageView;

    Button button;

    float xDown=0, yDown=0;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        imageView = findViewById(R.id.img1);

        button = findViewById(R.id.btnNext);

        List<String> test = getIntent().getStringArrayListExtra("test");
        Log.e("aaa", "onCreate: "+test );


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                startActivity(intent);
                Log.e(String.valueOf(1111), "onClick: pressed");

            }
        });

        imageView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getActionMasked()){
                    case MotionEvent.ACTION_DOWN:
                            xDown=event.getX();
                            yDown=event.getY();

                        break;
                    case MotionEvent.ACTION_MOVE:
                            float movedX,movedY;
                            movedX=event.getX();
                            movedY=event.getY();

                            //calculating how much moved

                            float distanceX=movedX-xDown;
                            float distanceY=movedY-yDown;

                            //move the view to that position

                            imageView.setX(imageView.getX()+distanceX);
                            imageView.setY(imageView.getY()+distanceY);



                        break;
                }
                return true;
            }
        });
    }

}