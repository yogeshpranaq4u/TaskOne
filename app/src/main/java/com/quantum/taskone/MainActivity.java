package com.quantum.taskone;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import receivers.PhoneReceiver;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    PhoneReceiver phoneReceiver;
    IntentFilter intentFilter;
    public String phonenumber=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //phoneReceiver=new PhoneReceiver();

       /* if (ContextCompat.checkSelfPermission(getBaseContext(), "android.permission.READ_PHONE_STATE") == PackageManager.PERMISSION_GRANTED) {

            // Todo : If Permission Granted Then Show SMS


        } else {
            // Todo : Then Set Permission
            final int REQUEST_CODE_ASK_PERMISSIONS = 123;
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_PHONE_STATE"}, REQUEST_CODE_ASK_PERMISSIONS);
        }*/

        buttonClick();
        telephonNumber();
        PhoneReceiver phoneReceiver=new PhoneReceiver();
        //phoneReceiver.showDialog();

    }

    @Override
    protected void onResume() {
        super.onResume();
        //intentFilter=new IntentFilter("android.intent.action.PHONE_STATE");
        //registerReceiver(phoneReceiver,intentFilter);
        telephonNumber();
       // showDialog();
    }

    public void buttonClick() {

        findViewById(R.id.api_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ApiActivity.class));
            }
        });

        findViewById(R.id.doc_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DocumentData.class));
            }
        });
    }

    public void telephonNumber() {
        @SuppressLint("ServiceCast") TelephonyManager telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_NUMBERS) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {

            final int REQUEST_CODE_ASK_PERMISSIONS = 123;
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_NUMBERS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_SMS, Manifest.permission.READ_CALL_LOG}, REQUEST_CODE_ASK_PERMISSIONS);
            return;
        }
        String number=telephonyManager.getLine1Number();
        String numberd=telephonyManager.getVoiceMailNumber();
        Log.d(TAG, "telephonNumberd: "+numberd);
        Log.d(TAG, "telephonNumber: "+number);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==123 && resultCode==RESULT_OK){
            startActivity(new Intent(MainActivity.this, MainActivity.class));
        }
    }

    public void getNumber(String number){
        phonenumber=number;
        Log.d(TAG, "getNumber: "+phonenumber);

    }

    public void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(this);
        View view = layoutInflaterAndroid.inflate(R.layout.cancel_dialog, null);
        builder.setView(view);
        builder.setCancelable(false);
        final AlertDialog alertDialog = builder.create();

        TextView cancel=view.findViewById(R.id.cancelDialog);
        TextView phonenum=view.findViewById(R.id.get_number);

        Intent intent=getIntent();
        String num= intent.getStringExtra("reffeer");
        phonenum.setText(num);
        /*builder.setCancelable(false).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.cancel();
            }
        });*/

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                Log.d(TAG, "Dialog cancel: ");
            }
        });

        alertDialog.show();

    }
}