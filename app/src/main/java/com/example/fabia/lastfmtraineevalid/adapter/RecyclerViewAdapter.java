package com.example.fabia.lastfmtraineevalid.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fabia.lastfmtraineevalid.R;
import com.example.fabia.lastfmtraineevalid.model.Artist;
import com.example.fabia.lastfmtraineevalid.model.Model;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    Model modelo;



    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.row_nombre)
        TextView nombreTextView;
        @BindView(R.id.row_oyentes)
        TextView oyentesTextView;
        @BindView(R.id.row_mbid)
        TextView mbidTextView;
        @BindView(R.id.row_streamable)
        TextView streamableTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public RecyclerViewAdapter(Model modelo) {
        this.modelo = modelo;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                             int viewType) {

        Context myContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(myContext);
        View myView = inflater.inflate(R.layout.custom_row, parent, false);
        ViewHolder myViewHolder = new ViewHolder(myView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        List<Artist> myLista = modelo.getTopArtists().getArtist();

        holder.nombreTextView.setText(myLista.get(position).getName());
        holder.oyentesTextView.setText(myLista.get(position).getListeners());
        holder.mbidTextView.setText(myLista.get(position).getMbid());
        holder.streamableTextView.setText(myLista.get(position).getStreamable());
    }

    @Override
    public int getItemCount() {
        return modelo.getTopArtists().getArtist().size();
    }
}
