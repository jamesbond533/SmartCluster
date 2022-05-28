package com.supreme.smartclusters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class MyRecAdapter extends RecyclerView.Adapter<MyRecAdapter.ViewHolder> {

    private ArrayList<MyRecData> RecData;
    static Context cnt;
    private FirebaseFirestore db;
    private FirebaseAuth mAuth;
    private String userId;
    public double f;

    public MyRecAdapter(ArrayList<MyRecData> RecData, Context cnt) {
        this.RecData = RecData;
        this.cnt = cnt;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_applied, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final MyRecData myRecData = RecData.get(position);

        try {


                holder.unicode.setText("Uni Code: " + myRecData.getUnicode());
                holder.coursename.setText("Preffered Course : "+myRecData.getCourse());
                holder.cutoff_21.setText("2021 clusters: " + myRecData.getCutofftwo());
                holder.progcode.setText("ProgCode: " + myRecData.getProgcode());
                holder.myclust.setText("Your Clusters: " + myRecData.getMycluster());





        }
        catch (Exception e){
            Toast.makeText(cnt.getApplicationContext(), "Holder error", Toast.LENGTH_SHORT).show();
        }


    }
    @Override
    public int getItemCount() {
        return RecData.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        View view;
        RecyclerView recycler;
        TextView unicode,progcode,coursename,cutoff_21,myclust;
        
        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            unicode = itemView.findViewById(R.id.uni_code);
            progcode= itemView.findViewById(R.id.progcode);
            coursename = itemView.findViewById(R.id.course_name);
            myclust=itemView.findViewById(R.id.mycluster);
            cutoff_21= itemView.findViewById(R.id.cutoff_2021);
            recycler=itemView.findViewById(R.id.recycerview);


        }
    }

}