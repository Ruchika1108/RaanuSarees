package com.ruchika.raanusarees;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
Button b;
    private FirebaseAuth firebaseAuth;
       FirebaseUser firebaseUser;
       NavigationView mNavigationView;
       TextView mName,mID;
       DatabaseReference databaseReference;
 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
     b=(Button)findViewById(R.id.signout);
        firebaseAuth =firebaseAuth.getInstance();
        //firebaseUser = firebaseAuth.getCurrentUser();
       // databaseReference = FirebaseDatabase.getInstance().getReference().child("raanusarees").child(firebaseUser.getUid());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

     /*   mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mName   = (TextView)mNavigationView.getHeaderView(0).findViewById(R.id.textViewHeaderTitle);
        mID   = (TextView)mNavigationView.getHeaderView(0).findViewById(R.id.textViewHeaderSID);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (DataSnapshot dataSnapshot){

                //Fetch values from you database child and set it to the specific view object.
                mName.setText(dataSnapshot.child("name").getValue().toString());
                mID.setText(dataSnapshot.child("sid").getValue().toString());

                // String link = dataSnapshot.child("profile_picture").getValue().toString();
                //Picasso.with(getBaseContext()).load(link).into(mImageView);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        }); */

    }




    public void fbpage(View view)
    {
        try{

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/777697915652222"));
            startActivity(intent);

        }catch(Exception e){

            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/RAANU-Sarees-777697915652222/?ref=br_tf")));

        }
    }

    public void pcall(View view) {
        try {
            Intent ci = new Intent(Intent.ACTION_DIAL);
            ci.setData(Uri.parse("tel:8888979199"));
            startActivity(ci);
            }
            catch (SecurityException e)
            {

            }
    }
    public void whopen(View view)
    {
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


   /* public void regmet(View view)
    {
        Intent intent =new Intent(this,Main4Activity.class);
        startActivity(intent);
    } */

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent =new Intent(this,Bridal.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
           Intent intent =new Intent(this,non_bridal.class);
            startActivity(intent);

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {
            Intent i = new Intent(this, Main5Activity.class);
            startActivity(i);

        } else if (id == R.id.nav_send) {
            Intent intent =new Intent(this,Main4Activity.class);
            startActivity(intent);
        } else if (id == R.id.signout)
        {
            Toast.makeText(this, "Signing out", Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,Main5Activity.class));
          /*  Intent intent =new Intent(this,signout.class);
            startActivity(intent); */
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }






    }

