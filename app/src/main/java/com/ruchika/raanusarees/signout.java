package com.ruchika.raanusarees;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signout extends AppCompatActivity {

    private static final String TAG = "AccountFragment";

    //firebase
    private FirebaseAuth.AuthStateListener mAuthStateListener;

   //widgets
           private Button mSignOut;

    @Nullable

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
               mSignOut = (Button) view.findViewById(R.id.sign_out);

                        setupFirebaseListener();

                        mSignOut.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                                        Log.d(TAG, "onClick: attempting to sign out the user.");
                                        FirebaseAuth.getInstance().signOut();
                                    }
       });


        return view;
    }


           private void setupFirebaseListener(){
                Log.d(TAG, "setupFirebaseListener: setting up the auth state listener.");
                mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                                FirebaseUser user = firebaseAuth.getCurrentUser();
                                if(user != null){
                                       Log.d(TAG, "onAuthStateChanged: signed_in: " + user.getUid());
                }else{
                                       Log.d(TAG, "onAuthStateChanged: signed_out");
                    Toast.makeText(signout.this, "Signed out", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(signout.this, MainActivity.class);
                                       intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                    }
                            }
       };
          }


           @Override
   public void onStart() {
        super.onStart();
             FirebaseAuth.getInstance().addAuthStateListener(mAuthStateListener);
           }

    @Override
  public void onStop() {
              super.onStop();
               if(mAuthStateListener != null){
                       FirebaseAuth.getInstance().removeAuthStateListener(mAuthStateListener);
                   }
           }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signout);
    }
}
