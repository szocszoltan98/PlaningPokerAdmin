 package com.example.planingpokeradmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

 public class MainActivity extends AppCompatActivity {

    EditText name;
    Button login;
    TextView text;
    DatabaseReference databaseAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseAdmin = FirebaseDatabase.getInstance().getReference("admins");


        name=findViewById(R.id.edt_name);
        login=findViewById(R.id.btn_login);
        text=findViewById(R.id.txt_welcome);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAdmin();
                openFragment();
            }
        });
    }

    private void openFragment()
    {
        login.setVisibility(View.GONE);
        name.setVisibility(View.GONE);
        text.setVisibility(View.GONE);
        FragmentManager fm= getSupportFragmentManager();
        BlankFragment fragment= new BlankFragment();
        fm.beginTransaction().replace(R.id.container,fragment).commit();

    }

    private void addAdmin()
    {
        String  adminname=name.getText().toString().trim();

        if(!TextUtils.isEmpty(adminname))
        {
            String id=databaseAdmin.push().getKey();
            Admin admin=new Admin(id,adminname);
            databaseAdmin.child(id).setValue(admin);
            Toast.makeText(this,"Admin added",Toast.LENGTH_LONG).show();

        }else
        {
            Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
        }
    }
}
