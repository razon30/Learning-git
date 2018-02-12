package com.selise.razonhossain.sugarEntitiy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.selise.razonhossain.eventbus.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by razon.hossain on 2/6/2018.
 */

public class AdapterSugarRecycler extends RecyclerView.Adapter<AdapterSugarRecycler.MyViewHolder> {

    private List<Book> bookList;
    private Context context;
    private LayoutInflater inflater;

    AdapterSugarRecycler(List<Book> bookList, Context context) {
        this.bookList = bookList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(inflater.inflate(R.layout.item_recycler_sugar, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Book book = bookList.get(position);

        holder.bookName.setText(book.getName());
        holder.releaseDate.setText(book.getReleaseDate());
        holder.price.setText(book.getPrice());
        holder.authorName.setText(book.getAuthor().getName());
        holder.authorBithday.setText(book.getAuthor().getBirthday());

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        View rootView;
        TextView bookName;
        TextView releaseDate;
        TextView price;
        TextView authorName;
        TextView authorBithday;

        MyViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.bookName = rootView.findViewById(R.id.book_name);
            this.releaseDate = rootView.findViewById(R.id.release_date);
            this.price = rootView.findViewById(R.id.price);
            this.authorName = rootView.findViewById(R.id.author_name);
            this.authorBithday = rootView.findViewById(R.id.author_bithday);
        }
    }

}
