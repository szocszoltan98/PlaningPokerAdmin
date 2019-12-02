package com.example.planingpokeradmin;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    public Button create;
    EditText grpname;
    DatabaseReference databaseGroup;
    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        databaseGroup = FirebaseDatabase.getInstance().getReference("groups");
       // addGroup();
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    private void addGroup()
    {
        String  groupname=grpname.getText().toString().trim();

        if(!TextUtils.isEmpty(groupname))
        {
            String id=databaseGroup.push().getKey();
/*
            databaseGroup.child(id).setValue(admin);*/
            Toast.makeText(getContext(),"Group added",Toast.LENGTH_LONG).show();

        }else
        {
            Toast.makeText(getActivity(),"Error",Toast.LENGTH_SHORT).show();
        }
    }

}
