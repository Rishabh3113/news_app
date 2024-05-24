package com.example.livecricket;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class sports extends Fragment {
    String api="4410e054669349bfbbd030ed546305c8";
    ArrayList<model> arrayList;
    adapter adapter;
    String country="in";
    private RecyclerView recyclerViewofsports;
    private String category="sports";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sports_fragment, null);
        recyclerViewofsports = view.findViewById(R.id.recycler3);
        arrayList = new ArrayList<>();
        recyclerViewofsports.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new adapter(getContext(), arrayList);
        recyclerViewofsports.setAdapter(adapter);
        findnews();
        return view;


    }

    private void findnews() {
        Apiutilities.getapiinterface().getcategorynews(country,100,api,category).enqueue(new Callback<news>() {
            @Override
            public void onResponse(Call<news> call, Response<news> response) {
                if(response.isSuccessful()){
                    arrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<news> call, Throwable t) {

            }
        });
    }
}
