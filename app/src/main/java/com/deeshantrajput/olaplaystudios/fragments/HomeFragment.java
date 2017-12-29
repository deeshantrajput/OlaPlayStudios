package com.deeshantrajput.olaplaystudios.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.deeshantrajput.olaplaystudios.R;
import com.deeshantrajput.olaplaystudios.adapters.SongAdapter;
import com.deeshantrajput.olaplaystudios.models.Result;
import com.deeshantrajput.olaplaystudios.network.OlaAPI;
import com.deeshantrajput.olaplaystudios.utils.FontUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    SongAdapter songAdapter;
    RecyclerView sList;
    EditText search;
    List<Result> songs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        sList = (RecyclerView)rootView.findViewById(R.id.songList);

        search = (EditText)rootView.findViewById(R.id.search_bar);
        search.setTypeface(FontUtils.getMediumTypeface());

        Call<List<Result>> songsCall = OlaAPI.getApplicationService().getSongs();
        new SongTask(songsCall).execute();

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = search.getText().toString().toLowerCase(Locale.getDefault());
                songAdapter = new SongAdapter(getActivity(),songs);
                sList.setLayoutManager(new LinearLayoutManager(getActivity()));
                sList.setAdapter(songAdapter);
                songAdapter.getFilter().filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });


        return rootView;
    }

    private class SongTask extends AsyncTask<Void, Void,List<Result>> {

        private Call<List<Result>> songCall;
        Response<List<Result>> response;

        SongTask(Call<List<Result>> songCall) {
            this.songCall = songCall;
        }


        @Override
        protected void onPreExecute() {
        }

        @Override
        protected List<Result> doInBackground(Void... voids) {
            try {
                response = songCall.execute();
                return response.body();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Result> result) {
            if (result != null) {
                songs = new ArrayList<>();
                songs = result;
                songAdapter = new SongAdapter(getActivity(),result);
                sList.setLayoutManager(new LinearLayoutManager(getActivity()));
                sList.setAdapter(songAdapter);
                songAdapter.notifyDataSetChanged();
            }
            else{
            }
        }
    }

}
