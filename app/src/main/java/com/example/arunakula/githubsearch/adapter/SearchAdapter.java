package com.example.arunakula.githubsearch.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.arunakula.githubsearch.R;
import com.example.arunakula.githubsearch.model.Search;
import com.squareup.picasso.Picasso;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    private List<Search> searches;

    public List<Search> getSearches() {
        return searches;
    }

    public void setSearches(List<Search> searches) {
        this.searches = searches;
    }

    private Context getApplicationContext;

    public Context getGetApplicationContext() {
        return getApplicationContext;
    }

    public void setGetApplicationContext(Context getApplicationContext) {
        this.getApplicationContext = getApplicationContext;
    }

    private int rowLayout;


    public int getRowLayout() {
        return rowLayout;
    }

    public void setRowLayout(int rowLayout) {
        this.rowLayout = rowLayout;
    }

    public SearchAdapter(List<Search> searches, Context getApplicationContext, int rowLayout) {
        this.searches = searches;
        this.getApplicationContext = getApplicationContext;
        this.rowLayout = rowLayout;
    }





    public static class SearchViewHolder extends RecyclerView.ViewHolder{

        private RelativeLayout searchLayout;
        private TextView name;
        private TextView fullname;
        private TextView privates;
        private TextView description;
        private ImageView avatar;
        private TextView starcount;


        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            searchLayout = (RelativeLayout) itemView.findViewById(R.id.repoLayout);
            name = (TextView) itemView.findViewById(R.id.name);
            fullname = (TextView) itemView.findViewById(R.id.fullname);
            privates = (TextView) itemView.findViewById(R.id.privates);
            description = (TextView) itemView.findViewById(R.id.description);
            avatar = (ImageView) itemView.findViewById(R.id.avatar);
            starcount = (TextView) itemView.findViewById(R.id.startcount);

        }


    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(rowLayout, viewGroup, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder searchViewHolder, int position) {

        searchViewHolder.name.setText("Name: "+searches.get(position).getName());
        searchViewHolder.fullname.setText("Full Name: " + searches.get(position).getFull_Name());
        searchViewHolder.privates.setText("Private: " + searches.get(position).getPrivate());
        searchViewHolder.description.setText("Description: " + searches.get(position).getDescription());
        searchViewHolder.starcount.setText( getApplicationContext.getString(R.string.black_rect)+ searches.get(position).getStar_Count());



        Iterator<Map.Entry<String,String>> it  = searches.get(position).getOwner().entrySet().iterator();

        while (it.hasNext()){
            Map.Entry<String, String> pair = it.next();
            if(pair.getKey().equals("avatar_url")) {
                Picasso.get().load(pair.getValue()).into(searchViewHolder.avatar);
            }
        }


    }

    @Override
    public int getItemCount() {
        return searches.size();
    }
}
