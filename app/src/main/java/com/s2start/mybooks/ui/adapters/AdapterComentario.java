package com.s2start.mybooks.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.s2start.mybooks.model.Comentario;
import com.s2start.mybooks.model.ComentariosL;
import com.s2start.mybooks.model.books;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterComentario  extends BaseAdapter {

    private Context context;
    private List<ComentariosL> comentario;

    public AdapterComentario(Context context, List<ComentariosL> comentario) {
        this.context = context;
        this.comentario = comentario;
    }
    @Override
    public int getCount() {
        return comentario.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ComentariosL b = comentario.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(com.s2start.mybooks.R.layout.item_comentario, null);


        TextView nome = v.findViewById(com.s2start.mybooks.R.id.nome);
        TextView descricao = v.findViewById(com.s2start.mybooks.R.id.descricao);
        nome.setText("" + b.getNome());
        descricao.setText("" + b.getComentario());
        return  v;
    }
}
