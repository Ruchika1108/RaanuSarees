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

public class description_bridal extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener{
    Spinner spinner;
    TextView tv;
    private int mYear, mMonth, mDay;
    Calendar myCalendar;
    DatePicker datePicker;
    Button b1, btn_date;
    static ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_bridal);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sizes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tv = (TextView) findViewById(R.id.textView);
        iv = (ImageView) findViewById(R.id.imageView2);
        //  datePicker = (DatePicker) findViewById(R.id.datePicker);
        b1 = (Button) findViewById(R.id.buttonfirst);
        btn_date = (Button) findViewById(R.id.btnscnd);
        btn_date.setOnClickListener((View.OnClickListener) this);
        Bundle bundle = getIntent().getExtras();
        int value = bundle.getInt("pos");
        switch (value) {

            case 0:
                iv.setImageResource(R.drawable.gha1bri);
                break;
            case 1:
                iv.setImageResource(R.drawable.ghabri2);
                break;
            case 2:
                iv.setImageResource(R.drawable.ghabri3);
                break;
            case 3:
                iv.setImageResource(R.drawable.ghabri4);
                break;
            case 4:
                iv.setImageResource(R.drawable.ghabri5);
                break;
            case 5:
                iv.setImageResource(R.drawable.ghabri6);
                break;
            case 6:
                iv.setImageResource(R.drawable.ghabri7);


        }
    }


        @Override
        public void onItemSelected (AdapterView < ? > adapterView, View view,int i, long l){
            String item = adapterView.getItemAtPosition(i).toString();
            Toast.makeText(this, "Selected" + item, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected (AdapterView < ? > adapterView){

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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        if (view == btn_date) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            tv.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }
}

