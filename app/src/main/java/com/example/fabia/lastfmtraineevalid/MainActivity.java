package com.example.fabia.lastfmtraineevalid;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.fabia.lastfmtraineevalid.adapter.RecyclerViewAdapter;
import com.example.fabia.lastfmtraineevalid.model.Model;
import com.example.fabia.lastfmtraineevalid.red.DataService;
import com.example.fabia.lastfmtraineevalid.red.RetrofitInstance;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.artist_recyclerview)
    RecyclerView myRecyclerView;

    private ProgressDialog mProgressDialog;
    private Model modelo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Butter Knife
        ButterKnife.bind(this);

        //Progress Dialog mientras carga datos
        mProgressDialog = new ProgressDialog(MainActivity.this);
        mProgressDialog.setMessage("Cargando...");
        mProgressDialog.show();

        //Recycler View para presentar datos
        myRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        myRecyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL);
        myRecyclerView.addItemDecoration(itemDecoration);

        //Retrofit
        DataService clienteRetrofit = RetrofitInstance.getRetrofitInstance()
                .create(DataService.class);
        Call<Model> modelCall = clienteRetrofit.getTopArtistsQuery(RetrofitInstance.METHOD,
                RetrofitInstance.FORMAT,
                RetrofitInstance.API_KEY,
                "colombia",
                "1");
        modelCall.enqueue(modelCallback);

        //Picasso
    }

    private Callback<Model> modelCallback = new Callback<Model>() {
        @Override
        public void onResponse(Call<Model> call, Response<Model> response) {
            modelo = response.body();

            RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(modelo);
            myRecyclerView.setAdapter(myAdapter);

            Toast.makeText(MainActivity.this,
                    modelo.getTopArtists().getArtist().get(0).getName(),
                    Toast.LENGTH_SHORT).show();
            mProgressDialog.dismiss();
        }

        @Override
        public void onFailure(Call<Model> call, Throwable t) {
            Toast.makeText(MainActivity.this, "Algo salio mal... " + t.getMessage(),
                    Toast.LENGTH_SHORT)
                    .show();
        }
    };
}
