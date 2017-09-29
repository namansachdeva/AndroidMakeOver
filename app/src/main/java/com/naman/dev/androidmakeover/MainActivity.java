package com.naman.dev.androidmakeover;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.naman.dev.androidmakeover.ui.BodyPartFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BodyPartFragment headFragment = new BodyPartFragment();
        BodyPartFragment bodyFragment = new BodyPartFragment();
        BodyPartFragment legFragment = new BodyPartFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.head_container, headFragment)
                .add(R.id.body_container, bodyFragment)
                .add(R.id.leg_container, legFragment)
                .commit();
    }


}
