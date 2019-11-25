package com.example.sqlere;

import android.content.Context;
import android.content.Intent;
import android.text.PrecomputedText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProfessorAdapter  extends RecyclerView.Adapter<ProfessorAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Professor> mlist;
    ProfessorAdapter(Context context, ArrayList<Professor> list){
        mContext =context;
    mlist=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view =layoutInflater.inflate(R.layout.cardview,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Professor ProfessorItem =mlist.get(position);
        final int z = position;
        TextView id1,nome1,escola1,dis2;
        CheckBox tok;
        id1 =holder.id;
        nome1=holder.nome;
        escola1=holder.escola;
        dis2 =holder.dis;
        tok = holder.tok;
        id1.setText(String.valueOf(ProfessorItem.getId()));
        nome1.setText(ProfessorItem.getNome());
        escola1.setText(ProfessorItem.getEscola());
        dis2.setText(ProfessorItem.getDisciplina());
        tok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfessorDAO professorDAO =new ProfessorDAO(mContext);

                if(holder.tok.isChecked()){
                    professorDAO.deletaRegistro(mlist.get(z));
                    Intent s = new Intent(mContext,Fim.class);
                    mContext.startActivity(s);

                }

            }
        });




    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
            TextView id,nome,escola,dis;
            CheckBox tok;
        public ViewHolder(View itemView){
            super(itemView);
            id = itemView.findViewById(R.id.TXTid1);
            nome =itemView.findViewById(R.id.TXTnome1);
            escola =itemView.findViewById(R.id.TXTescola1);
            dis = itemView.findViewById(R.id.TXTdisci1);
            tok =itemView.findViewById(R.id.tok);

        }
    }
}
