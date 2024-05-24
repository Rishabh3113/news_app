package com.example.livecricket;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.ktx.Firebase;

public class LOGIN extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private TextView google;
    private TextView facebook;
    private GoogleSignInOptions signInOptions;
    private GoogleSignInClient googleSignInclient;
    private static int code=100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         firebaseAuth=FirebaseAuth.getInstance();
         google=findViewById(R.id.google);
         facebook=findViewById(R.id.facebook);
        signInOptions= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleSignInclient= GoogleSignIn.getClient(this,signInOptions);
        GoogleSignInAccount account=GoogleSignIn.getLastSignedInAccount(this);



        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signin();


            }
        });






    }

    private void signin() {


        Intent signintent = googleSignInclient.getSignInIntent();
        startActivityForResult(signintent, code);
    }




        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==code){
                Task<GoogleSignInAccount> task=GoogleSignIn.getSignedInAccountFromIntent(data);
                handlesignresult(task);
                Intent intent=new Intent(LOGIN.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }

        private void handlesignresult(Task<GoogleSignInAccount> task) {
            try {
                GoogleSignInAccount account=task.getResult(ApiException.class);
            } catch (ApiException e) {
                Toast.makeText(this, "Welcome to app", Toast.LENGTH_LONG).show();
            }
        }}

