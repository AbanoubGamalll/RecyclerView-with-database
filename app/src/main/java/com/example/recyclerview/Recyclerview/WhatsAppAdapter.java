package com.example.recyclerview.Recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class WhatsAppAdapter extends RecyclerView.Adapter<WhatsAppAdapter.ViewHolder> {
    private List<WhatsAppModel> list;
    private OnClickRecyclerView clickRecyclerView;

    public WhatsAppAdapter(List<WhatsAppModel> list, OnClickRecyclerView clickRecyclerView) {
        this.list = list;
        this.clickRecyclerView = clickRecyclerView;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.model_whatsapp_view_layout, parent, false), clickRecyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.image.setImageResource(list.get(position).getImage());
        holder.message.setText(list.get(position).getMessage());
        holder.name.setText(list.get(position).getName());
        holder.date.setText(list.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CircleImageView image;
        TextView message, name, date;

        OnClickRecyclerView onClickRecyclerView;

        public ViewHolder(@NonNull View itemView, OnClickRecyclerView onClickRecyclerView) {
            super(itemView);
            image = itemView.findViewById(R.id.Image);
            message = itemView.findViewById(R.id.Message);
            name = itemView.findViewById(R.id.Name);
            date = itemView.findViewById(R.id.Time);

            this.onClickRecyclerView = onClickRecyclerView;
            itemView.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View view) {
            onClickRecyclerView.onclick(getAdapterPosition());
        }
    }

}
