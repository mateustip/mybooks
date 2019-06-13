package com.s2start.mybooks.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.s2start.mybooks.R;
import com.s2start.mybooks.model.books;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterWishlist extends BaseAdapter {

    private Context context;
    private List<books> books;

    public AdapterWishlist(Context context, List<books> books) {
        this.context = context;
        this.books = books;
    }
    @Override
    public int getCount() {
        return books.size();
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

        books b = books.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_wishlist, null);


        TextView name = v.findViewById(R.id.name);
        ImageView score = v.findViewById(R.id.image);
        name.setText("" + b.getNome());
        Picasso.get().load(b.getImagem()).into(score);

        return v;
    }
}
