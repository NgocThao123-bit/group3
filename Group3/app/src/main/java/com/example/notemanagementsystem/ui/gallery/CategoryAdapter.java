package com.example.notemanagementsystem.ui.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notemanagementsystem.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<Category> categoryList;
    private Context context;
    public CategoryAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.item_category, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {

        holder.tvName.setText( categoryList.get(position).getName());
        holder.tvCreatedDate.setText(categoryList.get(position).getCreated_date());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public void setTasks(List<Category> mcategoryList)
    {
        categoryList = mcategoryList;
        notifyDataSetChanged();
    }
    public List<Category> getTasks() {
        return categoryList;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvCreatedDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvCreatedDate = itemView.findViewById(R.id.tvCreatedDate);
        }
    }
}
