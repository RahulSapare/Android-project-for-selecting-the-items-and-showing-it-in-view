package com.example.work;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    public static int pageId=0;


    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        models = new ArrayList<>();
        models.add(new Model(R.drawable.body, "Body", "Body of an Automobile is the part which is integrated on Vehicle chassis."));
        models.add(new Model(R.drawable.roof, "Roof", "An automobile roof or car top is the portion of an automobile that sits above the passenger"));
        models.add(new Model(R.drawable.sidewheel, "Spare Wheel", "The spare wheel is usually placed in the boot of a car but is rarely used and adds to the weight of the vehicle."));
        models.add(new Model(R.drawable.wheel, "Front Wheel", "The entire part on which a tire is mounted. The wheel includes the hub, spokes, and rim."));
        models.add(new Model(R.drawable.wheel, "Back Wheel", "The entire part on which a tire is mounted. The wheel includes the hub, spokes, and rim."));

        adapter = new Adapter(models, this);

        btnNext=findViewById(R.id.btnNext);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color1)
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (adapter.getCount() -1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }

                else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {
                pageId=position;
            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
                //intent.putExtra("Selected",)
                startActivity(intent);
            }
        });



    }
}