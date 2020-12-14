package com.example.appiscina.adapter;

import android.content.Context;
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

    public propriedadeAdapter(List<propriedade> propriedades, Context context) {
        this.propriedades = propriedades;
        this.context = context;
    }

    @NonNull
    @Override
    public propriedadeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.propriedades, parent, false);
        propriedadeHolder propriedadeHolder = new propriedadeHolder(view);

        return propriedadeHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull propriedadeHolder holder, int position) {

        propriedade propriedade = propriedades.get(position);


        holder.ic_imagem.setImageResource(R.drawable.pis2);
        holder.nomePropriedade.setText(propriedade.getNomePropriedade());
        holder.localizacao.setText(propriedade.getLocalizacao());
        holder.precoDiaria.setText(propriedade.getDiaria());


        //holder.ic_imagem.setImageAlpha(propriedade.ge);

        //FALTA IMAGEM
        //holder.ic_imagem.setText(propriedade.getNomePropriedade());


    }

    @Override
    public int getItemCount() {
        return propriedades.size();
    }

    public class propriedadeHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{


        public TextView nomePropriedade;
        public TextView localizacao;
        public TextView precoDiaria;
        public ImageView ic_imagem;
        public ImageView favorito;


        public propriedadeHolder(View view){
            super(view);
            ic_imagem = view.findViewById(R.id.ic_imagem);

            favorito = view.findViewById(R.id.favorito);
            nomePropriedade = view.findViewById(R.id.nomePropriedade);
            precoDiaria = view.findViewById(R.id.precoDiaria);
            localizacao = view.findViewById(R.id.localizacao);
            ic_imagem = view.findViewById(R.id.ic_imagem);

            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int pos = getAdapterPosition();
            //Toast.makeText(context, "On click "+ pos, Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onLongClick(View view) {
            int pos = getAdapterPosition();
            //Toast.makeText(context, "OnLongclick" + pos, Toast.LENGTH_SHORT).show();
            return true;
        }
    }

}
