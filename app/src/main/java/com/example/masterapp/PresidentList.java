package com.example.masterapp;

import android.app.FragmentContainer;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class PresidentList extends Fragment {

    ListView listView;
    ArrayAdapter<CharSequence> prezNames;

    public PresidentList() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View listFragment = inflater.inflate(R.layout.fragment_president_list, container, false);

        listView = listFragment.findViewById(R.id.list);
        prezNames = ArrayAdapter.createFromResource(
                requireContext(), R.array.president_names, android.R.layout.simple_list_item_1);
        listView.setAdapter(prezNames);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            String name = listView.getItemAtPosition(i).toString();

            FragmentManager fm = requireActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentContainerView, new PresidentDetails(name));
            ft.commit();
        });

        return listFragment;
    }
}