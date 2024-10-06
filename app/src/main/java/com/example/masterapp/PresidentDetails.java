package com.example.masterapp;

import android.annotation.SuppressLint;
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
    String name;
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

    public PresidentDetails(String name) {
        this.name = name;
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

    @SuppressLint("SetTextI18n") // for suppressing yellow line for strings
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

        switch (name) {
            case "Dr. Rajendra Prasad":
                prezImage.setImageResource(R.drawable.rajendra_prasad);
                prezName.setText("Name: Dr. Rajendra Prasad");
                prezPeriod.setText("Period: January 26, 1950, to May 13, 1962");
                prezQualification.setText("Qualification: Bachelor's in Arts, Masters in Law");
                prezExperience.setText("Experience: Lawyer, Freedom Fighter, Political Leader, President of the Constituent Assembly");
                prezLifetime.setText("Lifetime: December 3, 1884 to February 28, 1963");
                prezAchievements.setText("Achievements: Role in the Freedom Movement, Bharat Ratna, Literary Contributions, Social Reformer");
                break;
            case "Dr. Sarvepalli Radhakrishnan":
                prezImage.setImageResource(R.drawable.sarvepalli_radhakrishnan);
                prezName.setText("Name: Dr. Sarvepalli Radhakrishnan");
                prezPeriod.setText("Period: May 13, 1962 to May 13, 1967");
                prezQualification.setText("Qualification: Master's in Philosophy");
                prezExperience.setText("Experience: Professor, University Vice-Chancellor, Philosopher and Scholar");
                prezLifetime.setText("Lifetime: September 5, 1888 to April 17, 1975");
                prezAchievements.setText("Achievements: \"Teacher's Day\", Bharat Ratna, Philosopher, Humanitarian and Spiritual Leader");
                break;
            case "Dr. Zakir Husain":
                prezImage.setImageResource(R.drawable.zakir_husain);
                prezName.setText("Name: Dr. Zakir Husain");
                prezPeriod.setText("Period: May 13, 1967, to May 3, 1969");
                prezQualification.setText("Qualification: Doctorate in Economics");
                prezExperience.setText("Experience: Governor of Bihar, Educator & Economist, Vice-President of India");
                prezLifetime.setText("Lifetime: February 8, 1897 to May 3, 1969");
                prezAchievements.setText("Achievements: Educationist and Social Reformer, Bharat Ratna, Role in Freedom Struggle, Contributions to Indian Culture, Advocate for Secularism");
                break;
        }

        return prezDetailsInflater;
    }
}