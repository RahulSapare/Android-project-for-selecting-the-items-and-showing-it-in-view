package com.example.work;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MainActivity4 extends AppCompatActivity {

    RelativeLayout relativeLayout;

    Button button, btnredd, btnbluee, btngreenn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        button = findViewById(R.id.btnNext);
        btnredd = findViewById(R.id.btnred);
        btngreenn = findViewById(R.id.btngreen);
        btnbluee = findViewById(R.id.btnblue);

        relativeLayout = findViewById(R.id.RelativeLayout02);


        btnredd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setBackgroundColor(Color.parseColor("#F50B0B"));

                Toast.makeText(MainActivity4.this, "Changed color to Red", Toast.LENGTH_SHORT).show();

            }
        });

        btngreenn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setBackgroundColor(Color.parseColor("#30B900"));

                Toast.makeText(MainActivity4.this, "Changed color to Green", Toast.LENGTH_SHORT).show();

            }
        });

        btnbluee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                relativeLayout.setBackgroundColor(Color.parseColor("#009EB9"));

                Toast.makeText(MainActivity4.this, "Changed color to Blue", Toast.LENGTH_SHORT).show();

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = takeScreenshot();
                Intent intent = new Intent(MainActivity4.this,MainActivity5.class);
                //intent.putExtra("BitmapImage", bitmap);
                ByteArrayOutputStream _bs = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 50, _bs);
                intent.putExtra("byteArray", _bs.toByteArray());
                startActivity(intent);
            }
        });
    }

    private Bitmap takeScreenshot() {
        View rootView = findViewById(android.R.id.content).getRootView();
        rootView.setDrawingCacheEnabled(true);
        return rootView.getDrawingCache();
    }
}