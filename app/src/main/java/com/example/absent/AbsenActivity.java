package com.example.absent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.makeText;

public class AbsenActivity extends AppCompatActivity {
    ApiIntAbsen apiIntAbsen;
    List<Absen>absens;
    StatusAbsen statusAbsen;
    TextView idsis,idpengabsen,ket;
    Button btnpilih;
    int ab;
    RadioButton ckSakit,ckIjin,ckAlpa;
    RadioGroup radioGroup;
    RadioButton radioButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absen);


        radioGroup=findViewById(R.id.r_group);
        Button buttonPilih=findViewById(R.id.btn_pilih);
        buttonPilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pilihRadio=radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(pilihRadio);
                Toast.makeText(getApplicationContext(),"Keterangan yang dipilih: " + radioButton.getText(),Toast.LENGTH_SHORT).show();

            }

        });

        idsis=(TextView)findViewById(R.id.idsis);
        idpengabsen=(TextView)findViewById(R.id.idpengbabsen);
        ket=(TextView)findViewById(R.id.keterangan);
        ckSakit=(RadioButton)findViewById(R.id.rb_sakit);
        ckIjin=(RadioButton) findViewById(R.id.rb_ijin);
        ckAlpa=(RadioButton) findViewById(R.id.rb_alpa);
        btnpilih=(Button)findViewById(R.id.btn_pilih);
        btnpilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pilih="";
                if (ckSakit.isChecked()){
                    pilih+="sakit \n";
                }if (ckIjin.isChecked()){
                    pilih+="ijin \n";
                }if (ckAlpa.isChecked()){
                    pilih+="alpa ?  \n";
                }
                Toast.makeText(getApplicationContext(),"Keterangannya",Toast.LENGTH_SHORT).show();
            }
        });

        Intent intent=getIntent();
        ab=intent.getIntExtra("idpengab",1);
        apiIntAbsen=ApiClient.getApiClient().create(ApiIntAbsen.class);
        Call<StatusAbsen> call= apiIntAbsen.getAbsen();
        call.enqueue(new Callback<StatusAbsen>() {
            @Override
            public void onResponse(Call<StatusAbsen> call, Response<StatusAbsen> response) {
                statusAbsen=response.body();





            }

            @Override
            public void onFailure(Call<StatusAbsen> call, Throwable t) {


            }
        });
    }
}
