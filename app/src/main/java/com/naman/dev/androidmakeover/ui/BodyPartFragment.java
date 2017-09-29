package com.naman.dev.androidmakeover.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.naman.dev.androidmakeover.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by naman on 9/30/2017.
 */

public class BodyPartFragment extends Fragment {

    private List<Integer> mImagesIds;
    private int mListIndex;

    public BodyPartFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            mImagesIds = savedInstanceState.getIntegerArrayList("IMAGE_ID_LIST");
            mListIndex = savedInstanceState.getInt("LIST_INDEX");
        }
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        final ImageView imageView = rootView.findViewById(R.id.body_part_image_view);
        if (mImagesIds != null)
            imageView.setImageResource(mImagesIds.get(mListIndex));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mListIndex = (mListIndex + 1) % (mImagesIds.size() - 1);
                imageView.setImageResource(mImagesIds.get(mListIndex));
            }
        });
        return rootView;
    }

    // To save state on rotation
    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putIntegerArrayList("IMAGE_ID_LIST", (ArrayList<Integer>) mImagesIds);
        currentState.putInt("LIST_INDEX", mListIndex);
    }

    public void setImagesIds(List<Integer> mImagesIds) {
        this.mImagesIds = mImagesIds;
    }

    public void setListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }
}
