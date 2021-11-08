package com.elgindy.loginandregisterwithroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.elgindy.loginandregisterwithroom.Data.favoris;

import java.security.PrivateKey;
import java.util.List;

public class favorisListAdapter extends RecyclerView.Adapter<favorisListAdapter.MyviewHolder>{

   private Context context;
   private List<favoris> favorisList ;
   private HandlefavorisClick clickListener;

   public favorisListAdapter(Context context, HandlefavorisClick clickListener)
   {
       this.context=context ;
       this.clickListener = clickListener;
   }
   public void setFavorisList(List<favoris> favorisList)
   {
       this.favorisList= favorisList ;
       notifyDataSetChanged();
   }
    @NonNull
    @Override
    public favorisListAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recyclerview_row,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull favorisListAdapter.MyviewHolder holder, int position) {
    holder.tvfavorisName.setText(this.favorisList.get(position).favorisName);


    holder.itemView.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View view) {
                                               clickListener.itemClick(favorisList.get(position));

                                           }
                                       });
   holder.editfavoris.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           clickListener.editItem(favorisList.get(position));
       }
   });
        holder.removefavoris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.removeItem(favorisList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
       if(favorisList== null || favorisList.size()==0)
        return 0;
       else return favorisList.size() ;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder{
        TextView tvfavorisName;
        ImageView removefavoris;
        ImageView editfavoris;



        public MyviewHolder(View view)
        {
            super(view);
            tvfavorisName = view.findViewById(R.id.tvfavorisName);
            removefavoris = view.findViewById(R.id.removefavoris);
            editfavoris = view.findViewById(R.id.editfavoris);



        }
    }
    public interface HandlefavorisClick{
       void itemClick(favoris f) ;
        void removeItem(favoris f) ;
        void editItem(favoris f) ;




    }



}
