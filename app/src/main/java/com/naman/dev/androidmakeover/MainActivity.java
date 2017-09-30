package com.naman.dev.androidmakeover;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.naman.dev.androidmakeover.data.AndroidImageAssets;
import com.naman.dev.androidmakeover.ui.BodyPartFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = getIntent();
        int headIndex = i.getIntExtra("headIndex",0);
        int bodyIndex = i.getIntExtra("bodyIndex",0);
        int legIndex = i.getIntExtra("legIndex",0);

        if (savedInstanceState == null) {
            BodyPartFragment headFragment = new BodyPartFragment();
            headFragment.setImagesIds(AndroidImageAssets.getHeads());
            headFragment.setListIndex(headIndex);

            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setImagesIds(AndroidImageAssets.getBodies());
            bodyFragment.setListIndex(bodyIndex);

            BodyPartFragment legFragment = new BodyPartFragment();
            legFragment.setImagesIds(AndroidImageAssets.getLegs());
            legFragment.setListIndex(legIndex);

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .add(R.id.body_container, bodyFragment)
                    .add(R.id.leg_container, legFragment)
                    .commit();
        }
    }


}
