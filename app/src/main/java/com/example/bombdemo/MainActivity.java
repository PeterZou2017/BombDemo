package com.example.bombdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.ParameterizedType;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.*;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.BmobCallback;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;
//import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity {

    private Button insertbutton;
    private Button getbutton;

    private Button changebutton;
    private Button delbutton;

    private Person p2;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this, "1fdbebaf8a3b65ce6623ce7a52f29a5e");

        p2=new Person();




        insertbutton=(Button)findViewById(R.id.insertdata);
        getbutton=(Button)findViewById(R.id.gettdata);
        insertbutton=(Button)findViewById(R.id.insertdata);
        changebutton=(Button)findViewById(R.id.changedata);
        delbutton=(Button)findViewById(R.id.deldata);

        insertbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Person p2 = new Person();
                p2.setName("lucky");
                p2.setAddress("北京海淀");

                p2.save(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {

                        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();

                    }


                });

            }
        });


        getbutton.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                BmobQuery<Person> bmobQuery=new BmobQuery<Person>();
                bmobQuery.getObject("cc92f3eb48", new QueryListener<Person>() {
                    @Override
                    public void done(Person person, BmobException e) {
                        Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });




        changebutton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                p2.setAddress("上海宝山");

                p2.update("cc92f3eb48", new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        Toast.makeText(MainActivity.this, "success"+p2.getUpdatedAt(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        delbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p2.setObjectId("cc92f3eb48");
                p2.delete("cc92f3eb48", new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        Toast.makeText(MainActivity.this, "del success", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });





    }



}
