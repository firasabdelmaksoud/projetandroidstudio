package tn.esprit.animaux.entities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tn.esprit.animaux.R;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.MyViewHolder> {
    List<animaux> animauxx;
    Context context;
    public AnimalAdapter(List<animaux> animauxx, Context context)
    {
        this.animauxx = animauxx;
        this.context = context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemanimal,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        animaux b =animauxx.get(position) ;
        holder.animauximage.setImageResource(b.getImage());
        holder.animauxname.setText(b.getNom());


    }

    @Override
    public int getItemCount() {
        return animauxx.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView animauximage;
        TextView animauxname;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            animauximage=itemView.findViewById(R.id.animauximage);
            animauxname=itemView.findViewById(R.id.animauxname);


        }
    }
}
