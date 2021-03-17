package com.example.testbg.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.testbg.R;
import com.example.testbg.models.Article;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyNewsAdapter extends RecyclerView.Adapter<MyNewsAdapter.ViewHolder> {

    private List<Article> articles;
    private Context mContext;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.Headlines) TextView headlines;
        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.newsImg) ImageView newsimage;
        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.author) TextView author;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            // Define click listener for the ViewHolder's View

        }


        public void bindArticles(Article article) {
            headlines.setText(article.getTitle());
            author.setText(article.getAuthor());
            Picasso.get().load(article.getUrlToImage()).into(newsimage);
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param mArticles List<Article> containing the data to populate views to be used
     * by RecyclerView.
     */
    public MyNewsAdapter(Context context, List<Article> mArticles) {
        mContext = context;
        articles = mArticles;
    }

    // Create new views (invoked by the layout manager)
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_news_list, viewGroup, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.bindArticles(articles.get(position));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return articles.size();
    }
}
