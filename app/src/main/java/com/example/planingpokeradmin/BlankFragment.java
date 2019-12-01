package com.example.planingpokeradmin;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {



    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Button create=(Button) getView().findViewById(R.id.btn_create);
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    public void createGroup()
    {

    }

}
