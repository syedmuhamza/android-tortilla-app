package com.example.tortilla;

import android.app.ActionBar;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import com.example.tortilla.ui.main.SectionsPagerAdapter;
import com.example.tortilla.databinding.ActivityMainDashboardBinding;

public class MainDashboard extends AppCompatActivity {

    private ActivityMainDashboardBinding binding;
    private String nameOfUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(MainDashboard.this);
        if (acct != null) {
            nameOfUser = new String(acct.getDisplayName().toString());
        }


        binding = ActivityMainDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = binding.fab;


//        fab.setVisibility(View.INVISIBLE);

        Toast.makeText(this,"HELLO",Toast.LENGTH_LONG).show();


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



    }


}