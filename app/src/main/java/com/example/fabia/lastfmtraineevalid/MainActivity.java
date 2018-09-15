package com.example.fabia.lastfmtraineevalid;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.fabia.lastfmtraineevalid.model.Model;
import com.example.fabia.lastfmtraineevalid.red.DataService;
import com.example.fabia.lastfmtraineevalid.red.RetrofitInstance;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView textoPrueba;

    private ProgressDialog mProgressDialog;
    private RecyclerView recyclerView;
    private Callback<Model> topArtistCall = new Callback<Model>() {

        String nombreArtista;

        @Override
        public void onResponse(Call<Model> call, Response<Model> response) {

            mProgressDialog.dismiss();
            Model datos = response.body();
            nombreArtista = datos.getTopartists().getArtist().get(0).getName();
            textoPrueba.setText(nombreArtista);
        }

        @Override
        public void onFailure(Call<Model> call, Throwable t) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoPrueba = (TextView) findViewById(R.id.texto_prueba);

        mProgressDialog = new ProgressDialog(MainActivity.this);
        mProgressDialog.setMessage("Cargando...");
        mProgressDialog.show();

        DataService servicio = RetrofitInstance.getRetrofitInstance().create(DataService.class);
        servicio.getTopartists().enqueue(topArtistCall);
    }
}
