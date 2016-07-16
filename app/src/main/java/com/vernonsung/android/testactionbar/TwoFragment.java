package com.vernonsung.android.testactionbar;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_two, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuitemAdd:
                Toast.makeText(getActivity(), R.string.add, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuitemMinus:
                Toast.makeText(getActivity(), R.string.minus, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuitemCall:
                Toast.makeText(getActivity(), R.string.call, Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
