 package com.example.planingpokeradmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

 public class MainActivity extends AppCompatActivity {

    EditText name,group;
    Button login,create;
    TextView text;
    DatabaseReference databaseAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.txt_welcome);
        databaseAdmin = FirebaseDatabase.getInstance().getReference("admins");

        name=findViewById(R.id.edt_name);
        group=findViewById(R.id.edt_groupName);
        login=findViewById(R.id.btn_login);
        create=findViewById(R.id.btn_createG);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAdmin();
               // openFragment();
                openActivity();
            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent openIntent = new Intent(MainActivity.this,AdminAdder.class);
                startActivity(openIntent);
            }
        });
    }



    private void openActivity(){//ezzel megnyitok egy adott activity-it
        Intent openIntent = new Intent(MainActivity.this,AdminAdder.class);
        startActivity(openIntent);
    }

    private void addAdmin()//Itt adok hozza egy uj admint az adatbazishoz
    {
        String  adminname=name.getText().toString().trim();
        String groupcode=group.getText().toString().trim();
        if(!TextUtils.isEmpty(adminname) )
        {



                String id=databaseAdmin.push().getKey();
                Admin admin=new Admin(id,adminname,groupcode);
                databaseAdmin.child(id).setValue(admin);
                Toast.makeText(this,"Admin added",Toast.LENGTH_LONG).show();




        }else
        {
            Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
        }
    }







}
