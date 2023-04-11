package com.example.tortilla;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class HistoryPage extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.history_page,container,false);
        ListView listView = view.findViewById(R.id.historyListDisplay);
        List<String> list=new ArrayList<>();
        list.add("Dummy Data");
        list.add("Dummy Data");
        list.add("Dummy Data");
        list.add("Dummy Data");
        list.add("Dummy Data");
        list.add("Dummy Data");
        list.add("Dummy Data");
        list.add("Dummy Data");
        list.add("Dummy Data");
        list.add("Dummy Data");
        ArrayAdapter arrayAdapter=new ArrayAdapter(getActivity(), android.R.layout.simple_expandable_list_item_1,list);
        listView.setAdapter(arrayAdapter);
        return view;
    }




}

