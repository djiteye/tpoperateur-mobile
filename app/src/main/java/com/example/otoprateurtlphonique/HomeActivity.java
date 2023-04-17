package com.example.otoprateurtlphonique;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
   EditText numT, code;
   TextView messageO, recharg,consult;
   Button brecharg,bconsult;
SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        db= openOrCreateDatabase("bdOT",MODE_PRIVATE,null);
        db.execSQL(" CREATE TABLE IF NOT EXISTS ot(rech varchar primary key);");
        db.execSQL(" CREATE TABLE IF NOT EXISTS od(cons varchar primary key);");
        numT=(EditText) findViewById(R.id.numtelephone);
        code=(EditText) findViewById(R.id.codeR);
        messageO=(TextView) findViewById(R.id.result1);
        recharg=(EditText) findViewById(R.id.recharge);
        consult=(EditText) findViewById(R.id.consulter);
        numT=(EditText) findViewById(R.id.numtelephone);
        brecharg=(Button) findViewById(R.id.brecharge);
        bconsult=(Button) findViewById(R.id.bconsulter);
        String nu= numT.getText().toString();
        if(nu.charAt(1)=='9'){
            messageO.setText("votre ligne est tunisie telecom");
        } else if (nu.charAt(1)=='3') {
            messageO.setText("votre ligne est orange");
        } else if (nu.charAt(0)=='2') {
            messageO.setText("votre ligne est ooredoo");

        }else {
            Toast.makeText(HomeActivity.this,"rien pour le moment",Toast.LENGTH_SHORT).show();
        }
        String co= code.getText().toString();

        if(nu.charAt(1)=='9'){
            recharg.setText("*123*"+String.valueOf(co)+"#");
            consult.setText("*122#");
            brecharg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   db.execSQL("INSERT INTO ot(rech) VALUES ("+ recharg.getText().toString()+");");
                    Toast.makeText(HomeActivity.this,"code de recharge envoyer",Toast.LENGTH_SHORT).show();
                }
            });
            bconsult.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    db.execSQL("INSERT INTO od(cons) VALUES ("+ consult.getText().toString()+");");
                    Toast.makeText(HomeActivity.this,"code de consultation envoyer",Toast.LENGTH_SHORT).show();
                }
            });

            // messageO.setText("votre ligne est tunisie telecom");

        } else if (nu.charAt(1)=='3') {
            //messageO.setText("votre ligne est orange");
            recharg.setText("*100*"+String.valueOf(co)+"#");
            consult.setText("*100#");
            brecharg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    db.execSQL("INSERT INTO ot(rech) VALUES ("+ recharg.getText().toString()+");");
                    Toast.makeText(HomeActivity.this,"code de recharge envoyer",Toast.LENGTH_SHORT).show();
                }
            });
            bconsult.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    db.execSQL("INSERT INTO od(cons) VALUES ("+ consult.getText().toString()+");");
                    Toast.makeText(HomeActivity.this,"code de consultation envoyer",Toast.LENGTH_SHORT).show();
                }
            });
        } else if (nu.charAt(0)=='2') {
            //messageO.setText("votre ligne est ooredoo");
            recharg.setText("*101*"+String.valueOf(co)+"#");
            consult.setText("*101#");
            brecharg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    db.execSQL("INSERT INTO ot(rech) VALUES ("+ recharg.getText().toString()+");");
                    Toast.makeText(HomeActivity.this,"code de recharge envoyer",Toast.LENGTH_SHORT).show();
                }
            });
            bconsult.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    db.execSQL("INSERT INTO od(cons) VALUES ("+ consult.getText().toString()+");");
                    Toast.makeText(HomeActivity.this,"code de consultation envoyer",Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            Toast.makeText(HomeActivity.this,"rien pour le moment",Toast.LENGTH_SHORT).show();
        }
    }
}