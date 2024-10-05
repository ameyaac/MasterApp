package com.example.masterapp;

import android.app.FragmentContainer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class PresidentList extends Fragment {

    View listFragment;
    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> prezNames;

    public PresidentList() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        listFragment = inflater.inflate(R.layout.fragment_president_list, container, false);

        String[] names = {"ABC", "PQR", "XYZ"};

        listView = listFragment.findViewById(R.id.list_prez_names);
        arrayList = new ArrayList<String>();
        prezNames = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1, arrayList);
        listView.setAdapter(prezNames);
        arrayList.add("abc");
        arrayList.add("ijk");

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            PresidentDetails presidentDetails = new PresidentDetails();
            Bundle args = new Bundle();
            String name = listView.getItemAtPosition(i).toString();

            args.putString("prezName", name);
            presidentDetails.setArguments(args);
        });

        return listFragment;
    }
}