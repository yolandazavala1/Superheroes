package com.example.superheroes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.MyAdapterViewHolder> {

    private Context context;
    private List<Superheroe> data;

    public MyAdapter(Context context, List<Superheroe> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyview,parent,false);
        return new MyAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterViewHolder holder, int position) {
        Superheroe superheroe = data.get(position);
        holder.textView.setText(superheroe.getName());
        Glide.with(holder.imageView.getContext()).load(superheroe.getImageurl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyAdapterViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public MyAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageSuper);
            textView = itemView.findViewById(R.id.superheroe);
        }
    }

}
