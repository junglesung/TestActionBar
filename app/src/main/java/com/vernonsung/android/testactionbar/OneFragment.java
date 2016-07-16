package com.vernonsung.android.testactionbar;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {
    public interface OneFragmentListener {
        void changeFragment();
    }

    private final static String LOG_TAG = "testtest";
    private OneFragmentListener oneFragmentListener;

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OneFragmentListener) {
            oneFragmentListener = (OneFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OneFragmentListener");
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OneFragmentListener) {
            oneFragmentListener = (OneFragmentListener) activity;
        } else {
            throw new RuntimeException(activity.toString() + " must implement OneFragmentListener");
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
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        TextView textView = (TextView) view.findViewById(R.id.textViewOne);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oneFragmentListener.changeFragment();
            }
        });
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        oneFragmentListener = null;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_one, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuitemCamera:
                Log.d(LOG_TAG, getString(R.string.camera));
                return true;
            case R.id.menuitemPhoto:
                Log.d(LOG_TAG, getString(R.string.photo));
                return true;
            case R.id.menuitemRotate90:
                Log.d(LOG_TAG, getString(R.string.rotate_90));
                return true;
            case R.id.menuitem2:
                Log.d(LOG_TAG, getString(R.string.people_2));
                changePeople(2);
                return true;
            case R.id.menuitem3:
                Log.d(LOG_TAG, getString(R.string.people_3));
                changePeople(3);
                return true;
            case R.id.menuitem4:
                Log.d(LOG_TAG, getString(R.string.people_4));
                changePeople(4);
                return true;
            case R.id.menuitem5:
                Log.d(LOG_TAG, getString(R.string.people_5));
                changePeople(5);
                return true;
            case R.id.menuitem6:
                Log.d(LOG_TAG, getString(R.string.people_6));
                changePeople(6);
                return true;
            case R.id.menuitem7:
                Log.d(LOG_TAG, getString(R.string.people_7));
                changePeople(7);
                return true;
            case R.id.menuitem8:
                Log.d(LOG_TAG, getString(R.string.people_8));
                changePeople(8);
                return true;
            case R.id.menuitem9:
                Log.d(LOG_TAG, getString(R.string.people_9));
                changePeople(9);
                return true;
            default:
                Log.d(LOG_TAG, "default");
                return super.onOptionsItemSelected(item);
        }
    }

    private void changePeople(int people) {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.my_toolbar);
        if (toolbar == null) {
            Log.e(LOG_TAG, "Toolbar is null");
            return;
        }
        int iconId = R.drawable.ic_2_white_24dp;  // default
        switch (people) {
            case 2:
                iconId = R.drawable.ic_2_white_24dp;
                break;
            case 3:
                iconId = R.drawable.ic_3_white_24dp;
                break;
            case 4:
                iconId = R.drawable.ic_4_white_24dp;
                break;
            case 5:
                iconId = R.drawable.ic_5_white_24dp;
                break;
            case 6:
                iconId = R.drawable.ic_6_white_24dp;
                break;
            case 7:
                iconId = R.drawable.ic_7_white_24dp;
                break;
            case 8:
                iconId = R.drawable.ic_8_white_24dp;
                break;
            case 9:
                iconId = R.drawable.ic_9_white_24dp;
                break;
        }
        toolbar.getMenu().findItem(R.id.menuitemPeople).setIcon(iconId);
    }
}
