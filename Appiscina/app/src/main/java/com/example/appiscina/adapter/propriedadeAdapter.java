package com.example.appiscina.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appiscina.R;
import com.example.appiscina.dominio.propriedade;

import org.w3c.dom.Text;

import java.util.List;

public class propriedadeAdapter extends RecyclerView.Adapter<propriedadeAdapter.propriedadeHolder> {

    private List<propriedade> propriedades;
    private Context context;

    private OnPropriedadeListener onPropriedadeListener;

    public propriedadeAdapter(List<propriedade> propriedades, Context context) {
        this.propriedades = propriedades;
        this.context = context;
        this.onPropriedadeListener = onPropriedadeListener;
    }

    @NonNull
    @Override
    public propriedadeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.propriedades, parent, false);
        propriedadeHolder propriedadeHolder = new propriedadeHolder(view, onPropriedadeListener);

        return propriedadeHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull propriedadeHolder holder, int position) {

        propriedade propriedade = propriedades.get(position);


        holder.ic_imagem.setImageResource(R.drawable.pis2);
        holder.nomePropriedade.setText(propriedade.getNomePropriedade());
        holder.localizacao.setText(propriedade.getLocalizacao());
        holder.precoDiaria.setText(propriedade.getDiaria());



//        if(propriedade.getFavorito() == 1){
//            holder.favorito.setColorFilter(Color.RED);
//        }



        //holder.ic_imagem.setImageAlpha(propriedade.ge);

        //FALTA IMAGEM
        //holder.ic_imagem.setText(propriedade.getNomePropriedade());


    }

    @Override
    public int getItemCount() {
        return propriedades.size();
    }

    public void setItems(List<propriedade> propriedades){
        this .propriedades = propriedades;
    }

    public propriedade getItem(int posicao){
        return propriedades.get(posicao);
    }

    public class propriedadeHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{


        public TextView nomePropriedade;
        public TextView localizacao;
        public TextView precoDiaria;
        public ImageView ic_imagem;
        public ImageView favorito;
        public OnPropriedadeListener onPropriedadeListener;




public propriedadeHolder(View view, OnPropriedadeListener onPropriedadeListener){
            super(view);
            ic_imagem = view.findViewById(R.id.ic_imagem);

            favorito = view.findViewById(R.id.favorito);
            nomePropriedade = view.findViewById(R.id.nomePropriedade);
            precoDiaria = view.findViewById(R.id.precoDiaria);
            localizacao = view.findViewById(R.id.localizacao);
            ic_imagem = view.findViewById(R.id.ic_imagem);

            this.onPropriedadeListener = onPropriedadeListener;

            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
           // int pos = getAdapterPosition();

            onPropriedadeListener.onPropriedadeClick(getAdapterPosition());

            //Toast.makeText(context, "On click "+ pos, Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onLongClick(View view) {
            int pos = getAdapterPosition();
            //Toast.makeText(context, "OnLongclick" + pos, Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    public interface    OnPropriedadeListener{
        void onPropriedadeClick(int posicao);
        //void onLivroLongClick(int posicao);
    }

}
