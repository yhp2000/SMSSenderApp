package com.example.parik.sms_sender_app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText mno,mes;
    Button sms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mno = (EditText)findViewById(R.id.editText);
        mes = (EditText)findViewById(R.id.editText2);
        sms = (Button)findViewById(R.id.button);

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no = mno.getText().toString();
                String msg = mes.getText().toString();

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                PendingIntent pi = PendingIntent.getActivities(getApplicationContext(),0, new Intent[]{intent},0);

                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(no,null,msg,pi,null);

                Toast.makeText(getApplicationContext(),"Message Sent Successfully!",Toast.LENGTH_LONG).show();
            }
        });
    }
}
