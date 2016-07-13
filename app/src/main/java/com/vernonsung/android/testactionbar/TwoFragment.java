package com.vernonsung.android.testactionbar;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment {
    public interface TwoFragmentListener {
        void changeFragment();
    }

    private TwoFragmentListener twoFragmentListener;



    public TwoFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof TwoFragmentListener) {
            twoFragmentListener = (TwoFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement TwoFragmentListener");
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof TwoFragmentListener) {
            twoFragmentListener = (TwoFragmentListener) activity;
        } else {
            throw new RuntimeException(activity.toString() + " must implement TwoFragmentListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        TextView textView = (TextView) view.findViewById(R.id.textViewTwo);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twoFragmentListener.changeFragment();
            }
        });
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        twoFragmentListener = null;
    }

}
