package com.vernonsung.android.testactionbar;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {


    public OneFragment() {
        // Required empty public constructor
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
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuitemCamera:
                Toast.makeText(getActivity(), R.string.camera, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuitemPhoto:
                Toast.makeText(getActivity(), R.string.photo, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuitemAdd:
                Toast.makeText(getActivity(), R.string.add, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuitemMinus:
                Toast.makeText(getActivity(), R.string.minus, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuitemRotate90:
                Toast.makeText(getActivity(), R.string.rotate_90, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuitemRotate180:
                Toast.makeText(getActivity(), R.string.rotate_180, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuitemRotate270:
                Toast.makeText(getActivity(), R.string.rotate_270, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuitemCall:
                Toast.makeText(getActivity(), R.string.call, Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
