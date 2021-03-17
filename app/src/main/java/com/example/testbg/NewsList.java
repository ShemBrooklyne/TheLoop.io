package com.example.testbg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.testbg.Network.NewsApi;
import com.example.testbg.Network.NewsClient;
import com.example.testbg.models.Article;
import com.example.testbg.models.SearchResponse;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsList extends AppCompatActivity {

    private MyAdapter myAdapter;
    public List<Article> articles;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.recyclerView) RecyclerView mRecyclerview;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.progressBar) ProgressBar mProgressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_load);
        ButterKnife.bind(this);

        //Establishing Connection to the Model classes.
        NewsApi client = NewsClient.getClient();

        Call<SearchResponse> call = client.getNews("standardmedia.co.ke", "441e5fea5c6d4f29bee20f551a8cc836", 100);
        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(@NotNull Call<SearchResponse> call, @NotNull Response<SearchResponse> response) {
                if (response.isSuccessful()) {
                    hideProgressBar();
                    articles = response.body().getArticles();
                    myAdapter = new MyAdapter(NewsList.this, articles);
                    mRecyclerview.setAdapter(myAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(NewsList.this);
                    mRecyclerview.setLayoutManager(layoutManager);
                    mRecyclerview.setHasFixedSize(true);
                    showArticles();
                } else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(@NotNull Call<SearchResponse> call, @NotNull Throwable t) {
                hideProgressBar();
                showFailureMessage();

            }
        });
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText(R.string.UnsuccessfulMsg);
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showFailureMessage() {
        mErrorTextView.setText(R.string.FailMsg);
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    private void showArticles() {
        mRecyclerview.setVisibility(View.VISIBLE);
    }
}