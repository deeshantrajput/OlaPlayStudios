package com.deeshantrajput.olaplaystudios.adapters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;

import com.deeshantrajput.olaplaystudios.R;
import com.deeshantrajput.olaplaystudios.activities.MainActivity;
import com.deeshantrajput.olaplaystudios.fragments.SongFragment;
import com.deeshantrajput.olaplaystudios.helpers.StringConstants;
import com.deeshantrajput.olaplaystudios.models.Result;
import com.deeshantrajput.olaplaystudios.views.TextView;
import com.squareup.picasso.Picasso;

import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by deeshantrajput on 12/17/17.
 */

    public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> implements Filterable{

        private Context context;
        private List<Result> results;
        private List<Result> songsFiltered;

        public SongAdapter(Context context, List<Result> results) {
            this.context = context;
            this.results = results;
            this.songsFiltered = results;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.song_row, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            holder.name.setText(songsFiltered.get(position).getSong());
            holder.artist.setText(songsFiltered.get(position).getArtists());

        }

        @Override
        public int getItemCount() {
            return songsFiltered.size();
        }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    songsFiltered = results;
                } else {
                    List<Result> filteredList = new ArrayList<>();
                    for (Result row : results) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getSong().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    songsFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values =songsFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                songsFiltered = (ArrayList<Result>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

            TextView name,artist;

            ImageView imageView;

            public ViewHolder(View itemView) {
                super(itemView);
                name = (TextView) itemView.findViewById(R.id.name);
                artist = (TextView)itemView.findViewById(R.id.artist);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int position = getAdapterPosition();
                            Bundle bundle = new Bundle();
                            bundle.putString("url",songsFiltered.get(position).getUrl());
                            bundle.putString("image",songsFiltered.get(position).getCover_image());
                            bundle.putString("name",songsFiltered.get(position).getSong());

                            MainActivity myActivity = (MainActivity) context;
                            FragmentManager fragmentManager = myActivity.getFragmentManager();

                            Fragment songFragment = new SongFragment();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            songFragment.setArguments(bundle);
                            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                            fragmentTransaction.replace(R.id.fragmentholder, songFragment, StringConstants.FRAGMENT_Home_TAG);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                    }
                });

            }
        }
    private class DownloadWebPageTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            URL url = null;
            try {
                url = new URL(urls[0]);
                // open connection
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);

                // stop following browser redirect
                httpURLConnection.setInstanceFollowRedirects(false);

                // extract location header containing the actual destination URL
                String expandedURL = httpURLConnection.getHeaderField("Location");
                httpURLConnection.disconnect();

                return expandedURL;
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String result) {

        }}
    }
