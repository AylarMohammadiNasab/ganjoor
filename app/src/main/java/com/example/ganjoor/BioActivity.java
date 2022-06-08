package com.example.ganjoor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BioActivity extends AppCompatActivity {
    ApiInterface request;
    Call<List<Poet>> call;
    BioAdapter bioAdapter;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);

        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rv.setHasFixedSize(true);
        request = ApiClient.getApiclient().create(ApiInterface.class);

        call = request.getPoet();
        call.enqueue(new Callback<List<Poet>>() {
            @Override
            public void onResponse(Call<List<Poet>> call, Response<List<Poet>> response) {
                if (response.isSuccessful()) {
                    Log.e("BiooT", "onResponse: " + response.body());


                    bioAdapter = new BioAdapter(BioActivity.this, response.body());

                    rv.setAdapter(bioAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Poet>> call, Throwable t) {
                Log.i("Example", "onError: " + t.getMessage());

            }
        });
    }
}