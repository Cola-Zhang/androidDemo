package com.example.zbk.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zbk.data.DataQuestion;
import com.example.zbk.demo.R;
import com.example.zbk.manager.DataManager;

import java.util.List;

/**
 * Created by zhangbaokun on 12/12/2016.
 */

public class ListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("ListFragment","onCreateView");
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = (RecyclerView)v.findViewById(R.id.list_recycleViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        itemAdapter = new ItemAdapter(DataManager.getInstance().getDataQuestions());
        recyclerView.setAdapter(itemAdapter);

        return v;
    }

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;

    private class ItemHolder extends RecyclerView.ViewHolder {
        public TextView titleView;

        public ItemHolder(View itemView){
            super(itemView);
            titleView = (TextView)itemView;
        }
    }

    private class ItemAdapter extends RecyclerView.Adapter<ItemHolder>{
        public ItemAdapter(List<DataQuestion> list){
            this.list = list;
        }

        @Override
        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            return new ItemHolder(view);
        }

        @Override
        public int getItemCount() {
            return this.list.size();
        }

        @Override
        public void onBindViewHolder(ItemHolder holder, int position) {
            DataQuestion dataQuestion = list.get(position);
            Log.d("ListFragment", dataQuestion.getQuestionText());
            holder.titleView.setText(dataQuestion.getQuestionText());
        }

        private List<DataQuestion> list;
    }
}
