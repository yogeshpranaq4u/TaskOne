package com.quantum.taskone;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import adapters.CategoryAdapter;
import apiPackage.CategoryApiClient;
import apiPackage.CatergoryApiInterface;
import apiPackage.RequestData;
import categoryapipkg.Category;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryApiActivity extends AppCompatActivity {
    public static final String TAG="MainCategoryApiActivity";
    public RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter=new CategoryAdapter();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_api_activity);
        recyclerView=findViewById(R.id.category_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(categoryAdapter);

        CatergoryApiInterface catergoryApiInterface= CategoryApiClient.getClients().create(CatergoryApiInterface.class);

        Call<Category> calls=catergoryApiInterface.getCategory();

        calls.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                Log.d(TAG, "onResponse: "+response.body().getCatlist());
                Log.d(TAG, "onResponse: "+response.raw().request().url());

                categoryAdapter.setList(response.body().getCatlist());
                categoryAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t);
            }
        });
    }
}
