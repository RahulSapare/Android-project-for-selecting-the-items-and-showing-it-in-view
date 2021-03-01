package com.example.work;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends PagerAdapter  {

    private List<Model> models;
    private LayoutInflater layoutInflater,layoutInflater1;
    private Context context;
    public List<String> list;
    int pageId=MainActivity2.pageId;
    public Adapter(List<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.items, container, false);

        layoutInflater1 = LayoutInflater.from(context);
        View view1 = layoutInflater1.inflate(R.layout.activity_main2,null);

        ImageView imageView, img;
        TextView title, desc;


        img=view1.findViewById(R.id.roof1);

        imageView = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);
        desc = view.findViewById(R.id.desc);

        imageView.setImageResource(models.get(position).getImage());
        title.setText(models.get(position).getTitle());
        desc.setText(models.get(position).getDesc());

        ///////////////
        list = new ArrayList<String>();
        //////////////


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
                list.add(String.valueOf(position));
                Log.e("aaa", "onClick: "+list );
                ////////////////
                switch (position) {
                    case 0:
                        img.setVisibility(View.INVISIBLE);
                        Toast.makeText(context, "Selected Body", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(context, "Selected Roof", Toast.LENGTH_SHORT).show();
                        break;

                    case 2:
                        Toast.makeText(context, "Selected Spare Wheel", Toast.LENGTH_SHORT).show();
                        break;

                    case 3:
                        Toast.makeText(context, "Selected Front Wheel", Toast.LENGTH_SHORT).show();
                        break;

                    case 4:
                        Toast.makeText(context, "Selected BackWheel", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        break;
                }
                ///////////////
            }
        });

        container.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
