package com.knowledge.lead.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.knowledge.lead.gadsleaderboard.ViewPagerFragments.FragmentHours;
import com.knowledge.lead.gadsleaderboard.ViewPagerFragments.FragmentSkills;
import com.knowledge.lead.gadsleaderboard.ViewPagerFragments.PagerAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    PagerAdapter fragmentPagerAdapter;
    ViewPager viewPager;
    TabLayout tabLayout;
    Button btnToSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.mainViewPager);

        btnToSubmit = findViewById(R.id.btnToSubmit);
        btnToSubmit.setOnClickListener(this);

        getTabs();
    }

    public void getTabs(){
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                PagerAdapter fragmentPagerAdapter = new PagerAdapter(getSupportFragmentManager());
                fragmentPagerAdapter.addFragment(FragmentHours.newInstance(), "Learning Leaders");
                fragmentPagerAdapter.addFragment(FragmentSkills.newInstance(), "Skill IQ Leaders");
                viewPager.setAdapter(fragmentPagerAdapter);
                tabLayout.setupWithViewPager(viewPager);

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnToSubmit:
                Intent intent = new Intent(this, SubmissionActivity.class);
                startActivity(intent);
                break;
        }
    }
}