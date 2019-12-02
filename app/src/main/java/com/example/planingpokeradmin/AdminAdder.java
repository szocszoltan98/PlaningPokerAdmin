package com.example.planingpokeradmin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.acl.Group;

public class AdminAdder extends AppCompatActivity {
    public Button create,createQuest;
    EditText grpname,questname,questCode;
    DatabaseReference databaseGroup;
    DatabaseReference databaseQuest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_adder);

        create=findViewById(R.id.btn_create);
        createQuest=findViewById(R.id.btn_createQest);
        questname=findViewById(R.id.edt_quest);
        questCode=findViewById(R.id.edt_QuestCode);
        grpname=findViewById(R.id.grp_name);
        databaseGroup= FirebaseDatabase.getInstance().getReference("groups");
        databaseQuest= FirebaseDatabase.getInstance().getReference("quests");
       /* create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addGroup();
            }
        });*/
        createQuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addQuest();
            }
        });
    }
    /*private void addGroup()
    {
        String groupcode=groupCode.get
        String  groupname=grpname.getText().toString().trim();

        if(!TextUtils.isEmpty(groupname))
        {
            String id=databaseGroup.push().getKey();
            Group groups=new groups(id,groupname,grou);
            databaseGroup.child(id).setValue(groups);
            Toast.makeText(this,"Group added",Toast.LENGTH_LONG).show();

        }else
        {
            Toast.makeText(AdminAdder.this,"Error",Toast.LENGTH_SHORT).show();
        }
    }*/

    private void addQuest()
    {
        String  questName=questname.getText().toString().trim();
        String questcode=questCode.getText().toString().trim();

        if(!TextUtils.isEmpty(questName))
        {
            String id=databaseQuest.push().getKey();
            Quest quest =new Quest(id,questName,questcode);
            databaseQuest.child(id).setValue(quest);
            Toast.makeText(this,"Quest added",Toast.LENGTH_LONG).show();

        }else
        {
            Toast.makeText(AdminAdder.this,"Error",Toast.LENGTH_SHORT).show();
        }
    }


}
