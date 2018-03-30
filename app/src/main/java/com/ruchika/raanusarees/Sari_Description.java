package com.ruchika.raanusarees;

import android.app.DatePickerDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Sari_Description extends AppCompatActivity  {

    TextView tv;

    Button b1;
    static ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sari__description);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sizes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tv = (TextView) findViewById(R.id.textView);
        iv = (ImageView) findViewById(R.id.imageView2);
        //  datePicker = (DatePicker) findViewById(R.id.datePicker);
        b1 = (Button) findViewById(R.id.buttonfirst);
        Bundle bundle = getIntent().getExtras();
        int value = bundle.getInt("pos");
        switch (value) {

            case 0:
                iv.setImageResource(R.drawable.saa11);
                break;
            case 1:
                iv.setImageResource(R.drawable.saa12);
                break;
            case 2:
                iv.setImageResource(R.drawable.saa13);
                break;
            case 3:
                iv.setImageResource(R.drawable.saa14);
                break;
            case 4:
                iv.setImageResource(R.drawable.saa15);
                break;
            case 5:
                iv.setImageResource(R.drawable.saa16);
                break;
            case 6:
                iv.setImageResource(R.drawable.saa17);
            case 7:
                iv.setImageResource(R.drawable.saa18);break;


        }
    }

    public void enquiry(View view) {
       /* Intent i = new Intent(this,Main2Activity.class);
        startActivity(i); */

        String smsNumber = "918888979199";
        boolean isWhatsappInstalled = whatsappInstalledOrNot("com.whatsapp");
        if (isWhatsappInstalled) {

            Intent sendIntent = new Intent("android.intent.action.MAIN");
            sendIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
            sendIntent.putExtra("jid", PhoneNumberUtils.stripSeparators(smsNumber) + "@s.whatsapp.net");//phone number without "+" prefix

            startActivity(sendIntent);
        } else {
            Uri uri = Uri.parse("market://details?id=com.whatsapp");
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            Toast.makeText(this, "WhatsApp not Installed",
                    Toast.LENGTH_SHORT).show();
            startActivity(goToMarket);
        }
    }
    private boolean whatsappInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }


}
