package com.example.absent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityLogin extends AppCompatActivity {

    RelativeLayout rellay1, rellay2;
    ApiInterfaceLogIn apiInterfacelogin,apiInterfaceLogIn2;
    List<Password>passwords;
    StatusAbsen statusAbsen;
    Absen absen;
    Button btn_login;
    Token tokennya;
    EditText edt_email,edt_pass;
    String email,pass,passwordnya,tokendapat;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVerticalGravity(View.VISIBLE);
            rellay2.setVerticalGravity(View.VISIBLE);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        rellay1=(RelativeLayout)findViewById(R.id.rellay1);
        rellay2=(RelativeLayout)findViewById(R.id.rellay2);

        edt_email=(EditText)findViewById(R.id.email);
        edt_pass=(EditText)findViewById(R.id.pass);
        btn_login=(Button)findViewById(R.id.log_in);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = edt_email.getText().toString();
                pass = edt_pass.getText().toString();
                apiInterfacelogin = ApiClient.getApiClient().create(ApiInterfaceLogIn.class);
                Call<List<Password>> call = apiInterfacelogin.getPass(email);
                call.enqueue(new Callback<List<Password>>() {
                    @Override
                    public void onResponse(Call<List<Password>> call, Response<List<Password>> response) {
                        passwords = response.body();
                        passwordnya = passwords.get(0).getPassword();

                    }

                    @Override
                    public void onFailure(Call<List<Password>> call, Throwable t) {

                    }
                });
                if (pass.equals(passwordnya)) {
                    apiInterfaceLogIn2=ApiClient.getApiClient().create(ApiInterfaceLogIn.class);
                    Call<Token>callnya=apiInterfaceLogIn2.getToken(email,pass);
                    callnya.enqueue(new Callback<Token>() {
                        @Override
                        public void onResponse(Call<Token> call, Response<Token> response) {
                            tokennya=response.body();
                            tokendapat=tokennya.getToken();
                            Intent pindah1=new Intent(ActivityLogin.this,JurusanActivity.class);
                            pindah1.putExtra("pesan",tokendapat);
                            startActivity(pindah1);

                        }

                        @Override
                        public void onFailure(Call<Token> call, Throwable t) {

                        }
                    });

                }else{
                    Toast.makeText(getApplicationContext(),"anda tidak berhak masuk",Toast.LENGTH_LONG).show();
                    edt_email.setText("");
                    edt_pass.setText("");
                }
            }

        });

                handler.postDelayed(runnable, 0); //2000 is the timeout for the splash

            }
        }
