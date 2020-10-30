package com.project.java.belajarretrofit.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.project.java.belajarretrofit.R;
import com.project.java.belajarretrofit.data.Sport;

import java.util.ArrayList;
import java.util.List;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.ViewHolder> {
    private List<Sport> sports = new ArrayList<>();

    public void setData (List<Sport> sports) {
        this.sports.clear();
        this.sports = sports;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(sports.get(position));
    }

    @Override
    public int getItemCount() {
        return sports.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvFormat;
        private ImageView imgPoster;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.txt_name);
            tvFormat = itemView.findViewById(R.id.txt_format);
            imgPoster = itemView.findViewById(R.id.img_photo);
        }

        public void bind(Sport sport) {
            tvName.setText(sport.getStrSport());
            tvFormat.setText(sport.getStrFormat());
            Glide.with(itemView.getContext())
                    .load(sport.getStrSportThumb())
                    .apply(new RequestOptions())
                    .into(imgPoster);
        }
    }
}
