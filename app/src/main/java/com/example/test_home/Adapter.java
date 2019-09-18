package com.example.test_home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.CustomViewHolder> {
    private ArrayList<Data> arrayList;

    public Adapter(ArrayList<Data> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override //리스트뷰 처음 생성 될 떄의 생명주기
    public Adapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_view,parent,false);
        CustomViewHolder holder =new CustomViewHolder(view);
        return holder;
    }

    @Override //추가 될 떄의 생명주기
    public void onBindViewHolder(@NonNull final Adapter.CustomViewHolder holder, int position) {
        holder.iv_profile.setImageResource(arrayList.get(position).getIv_profile());
        holder.tv_name.setText(arrayList.get(position).getTv_name());

        //리스트 클릭됐을 떄
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String curName=holder.tv_name.getText().toString();
                Toast.makeText(view.getContext(),curName,Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                remove(holder.getAdapterPosition());//remove 구현 활용
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size():0);
    }

    public void remove(int position){
        try{
            arrayList.remove(position);
            notifyItemRemoved(position); //새로고침 -> 리스트뷰 지우면 새로고침
        }catch(IndexOutOfBoundsException ex){
            ex.printStackTrace(); //예외 발생시 강제실행
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView iv_profile;
        protected TextView tv_name;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile=(ImageView)itemView.findViewById(R.id.iv_profile);
            this.tv_name=(TextView)itemView.findViewById(R.id.tv_name);
        }
    }
}
