package com.example.masterapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PresidentDetails#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PresidentDetails extends Fragment {

    View prezDetailsInflater;
    ImageView prezImage;
    TextView prezName, prezPeriod, prezQualification, prezExperience, prezLifetime, prezAchievements;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PresidentDetails() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PresidentDetails.
     */
    // TODO: Rename and change types and number of parameters
    public static PresidentDetails newInstance(String param1, String param2) {
        PresidentDetails fragment = new PresidentDetails();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        prezDetailsInflater = inflater.inflate(R.layout.fragment_president_details, container, false);
        prezImage = prezDetailsInflater.findViewById(R.id.prezImage);
        prezName = prezDetailsInflater.findViewById(R.id.prezName);
        prezPeriod = prezDetailsInflater.findViewById(R.id.prezPeriod);
        prezQualification = prezDetailsInflater.findViewById(R.id.prezQualification);
        prezExperience = prezDetailsInflater.findViewById(R.id.prezExperience);
        prezLifetime = prezDetailsInflater.findViewById(R.id.prezLifetime);
        prezAchievements = prezDetailsInflater.findViewById(R.id.prezAchievements);

        if (getArguments() != null) {
            String name = getArguments().getString("prezName");
            assert name != null;
            if (name.equals("Dr. Rajendra Prasad")) {
                prezName.setText("Dr. Rajendra Prasad");
            }
        } else {
            Toast.makeText(getActivity(), "no value was sent!", Toast.LENGTH_SHORT).show();
        }

        return prezDetailsInflater;
    }
}