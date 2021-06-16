package com.kazimasum.retrodemo;

import androidx.annotation.Dimension;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
{
  TextView tv;
  String url="https://jsonplaceholder.typicode.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView  display;

        display=(TextView)findViewById(R.id.display);
       /* userid=(TextView)findViewById(R.id.userid);
        title=(TextView)findViewById(R.id.title);
        body=(TextView)findViewById(R.id.body);*/

        display.setText("");
        //userid.setText("");
        //title.setText("");
       // body.setText("");

        Retrofit retrofit=new Retrofit.Builder()
                 .baseUrl(url)
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();

        myapi api=retrofit.create(myapi.class);

        Call<List<model>> call=api.getmodels();

        call.enqueue(new Callback<List<model>>() {
            @Override
            public void onResponse(Call<List<model>> call, Response<List<model>> response) {
              List<model> data=response.body();
               for(int i=0; i<data.size();i++){
                   //title.append("Title"+data.get(i).getTitle()+"\n\n\n");
                   display.append("Data :"+data.get(i).getId()+"\n\n\n"+data.get(i).getBody()+"\n\n\n"+data.get(i).getTitle()+"\n\n\n"+data.get(i).getUserId()+"\n\n\n");
                  // body.append("Body"+data.get(i).getBody()+"\n\n\n");
                  // userid.append("User ID"+data.get(i).getUserId()+"\n\n\n");
               }

            }

            @Override
            public void onFailure(Call<List<model>> call, Throwable t) {

            }
        });

    }
}