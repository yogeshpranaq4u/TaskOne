package receivers;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.quantum.taskone.MainActivity;
import com.quantum.taskone.R;

public class PhoneReceiver extends BroadcastReceiver {
    public static final String TAG="MainPhoneReceiver";
    public String phonenumbers;
    @Override
    public void onReceive(Context context, Intent intent) {


        try {
            System.out.println("Recevier started");
            Toast.makeText(context,"Ringing State Number is - ", Toast.LENGTH_SHORT).show();

            if(intent.getAction().equals("android.intent.action.PHONE_STATE")){
                String state=intent.getStringExtra(TelephonyManager.EXTRA_STATE);
                if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
                    phonenumbers = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
                    Log.d(TAG, "onReceive: "+phonenumbers);
                    Toast.makeText(context,"Incoming call number- "+phonenumbers,Toast.LENGTH_SHORT).show();

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.cancel_dialog);
                    TextView number=dialog.findViewById(R.id.get_number);
                    number.setText(phonenumbers);
                    TextView cancel=dialog.findViewById(R.id.cancelDialog);
                    cancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                }

                else if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)){
                    Toast.makeText(context,"Phone idle", Toast.LENGTH_SHORT).show();
                }

                else if(state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)){
                    Toast.makeText(context,"Phone off Hook", Toast.LENGTH_SHORT).show();
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        //showDialog();

    }

    /*public void showDialog(){
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder();
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(activity.getApplicationContext());
        View view = layoutInflaterAndroid.inflate(R.layout.cancel_dialog, null);
        builder.setView(view);
        builder.setCancelable(false);
        final AlertDialog alertDialog = builder.create();

        TextView cancel=view.findViewById(R.id.cancelDialog);
        TextView phonenum=view.findViewById(R.id.get_number);
        phonenum.setText(String.valueOf(phonenumbers));
        builder.setCancelable(false).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.cancel();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                Log.d(TAG, "Dialog cancel: ");
            }
        });

        alertDialog.show();

    }*/

}
