package com.project.java.belajarretrofit.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.project.java.belajarretrofit.R;
import com.project.java.belajarretrofit.data.ListSports;
import com.project.java.belajarretrofit.network.ApiClient;
import com.project.java.belajarretrofit.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SportAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_sport);
        adapter = new SportAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        getDataArticle();
    }

    private void getDataArticle() {
        ApiInterface service = ApiClient.getRetrofitInstance().create(ApiInterface.class);
        Call<ListSports> call = service.getSports();
        call.enqueue(new Callback<ListSports>() {
            @Override
            public void onResponse(Call<ListSports> call, Response<ListSports> response) {
                if (response.isSuccessful()) {
                    ListSports sports = response.body();
                    if (sports != null && sports.getSports() != null) {
                        adapter.setData(sports.getSports());
                    }
                }
            }

            @Override
            public void onFailure(Call<ListSports> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Connection Failed" , Toast.LENGTH_SHORT).show();
                System.out.println(t.getMessage());
            }
        });
    }
}