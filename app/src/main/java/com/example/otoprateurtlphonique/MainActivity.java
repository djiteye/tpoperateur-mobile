package com.example.otoprateurtlphonique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, password;

    Button connexion;
    DBH db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText)  findViewById(R.id.ulogin);
        password=(EditText)  findViewById(R.id.password);
        connexion=(Button)  findViewById(R.id.connexion);
        db=new DBH(this);
        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= username.getText().toString();
                String pass= password.getText().toString();
                if(user.equals("")|| pass.equals("")){
                    Toast.makeText(MainActivity.this,"please entrer les données corrects",Toast.LENGTH_SHORT).show();
                }else{
                    boolean checkupa= db.checkup(user,pass);
                    if(checkupa==true){
                        Toast.makeText(MainActivity.this,"connexion approuvée",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                    }else{
                        Toast.makeText(MainActivity.this,"donnée invalid",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}