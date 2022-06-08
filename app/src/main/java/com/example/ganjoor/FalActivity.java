package com.example.ganjoor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FalActivity extends AppCompatActivity {
    ApiInterface request;
TextView t1,t2,t3,t4,textView7;
    Call<Fal> call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fal);
        t1=findViewById(R.id.textView2);
        t2=findViewById(R.id.textView3);
        t3=findViewById(R.id.textView4);
        t4=findViewById(R.id.textView5);
        textView7=findViewById(R.id.textView7);
        request = ApiClient.getApiclient().create(ApiInterface.class);
        call = request.getFal();
        call.enqueue(new Callback<Fal>() {
            @Override
            public void onResponse(Call<Fal> call, Response<Fal> response) {
                if (response.isSuccessful()) {
                    Log.i("Example", "onResponse: " + response.body());
                    t1.setText(response.body().getFullTitle());
                    t2.setText(response.body().getPlainText());



                }
            }

            @Override
            public void onFailure(Call<Fal> call, Throwable t) {
                Log.i("Example", "onError: " + t.getMessage());

            }
        });

t3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        call = request.getFal();
        call.enqueue(new Callback<Fal>() {
            @Override
            public void onResponse(Call<Fal> call, Response<Fal> response) {
                if (response.isSuccessful()) {
                    Log.i("Example", "onResponse: " + response.body());
                    t1.setText(response.body().getFullTitle());
                    t2.setText(response.body().getPlainText());



                }
            }

            @Override
            public void onFailure(Call<Fal> call, Throwable t) {
                Log.i("Example", "onError: " + t.getMessage());

            }
        });


    }
});



        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
         finish();

            }
        });
    }
}