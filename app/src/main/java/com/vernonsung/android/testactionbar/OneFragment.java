package com.vernonsung.android.testactionbar;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {
    public interface OneFragmentListener {
        void changeFragment();
    }

    private final static String LOG_TAG = "testtest";
    private OneFragmentListener oneFragmentListener;

    // The request code to choose an image
    private static final int REQUEST_IMAGE_BROWSE = 2;
    private Uri mCurrentPhotoUri;
    private ImageView imageViewOne;
    private int rotateDegree = 0;  // 0~270

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
        imageViewOne = (ImageView) view.findViewById(R.id.imageViewOne);
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
                chooseAnImage();
                return true;
            case R.id.menuitemRotate90:
                Log.d(LOG_TAG, getString(R.string.rotate_90));
                rotateImage();
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // The ACTION_GET_CONTENT intent was sent with the request code
        // START_ACTIVITY_ID_CHOOSE_AN_IMAGE. If the request code seen here doesn't match, it's the
        // response to some other intent, and the code below shouldn't run at all.
        switch (requestCode) {
            case REQUEST_IMAGE_BROWSE:
                onActivityResultImageBrowse(resultCode, data);
                break;
            default:
                //
        }
    }

    private void onActivityResultImageBrowse(int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            // The document selected by the user won't be returned in the intent.
            // Instead, a URI to that document will be contained in the return intent
            // provided to this method as a parameter.
            // Pull that URI using resultData.getData().
            if (data != null) {
                mCurrentPhotoUri = data.getData();
                Log.i(LOG_TAG, "Chosen image URI " + mCurrentPhotoUri.toString());
                Picasso.with(getActivity()).load(mCurrentPhotoUri).into(imageViewOne);
            }
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

    private void chooseAnImage() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);

        // Filter to only show results that can be "opened", such as a
        // file (as opposed to a list of contacts or timezones)
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        // Filter to show only images, using the image MIME data type.
        // If one wanted to search for ogg vorbis files, the type would be "audio/ogg".
        // To search for all documents available via installed storage providers,
        // it would be "*/*".
        intent.setType("image/*");

        //第一個問題是Android系統找不到符合指定MIME類型的內容選取器，程式將會因為找不到可執行的Activity而直接閃退，這個問題甚至可能會沒辦法直接用try-catch來解決。第二個可能會遇到的問題是，當Android系統找到兩種以上可用的App或是Activity支援指定的MIME類型時，可能會自動使用其中一種，此時也許就會選到無法正常使用的App或是Activity，連帶使我們的App永遠無法正常使用。
        //要解決第一個找不到Activity的問題，可以事先使用PackageManager查詢可以使用該MIME類型的Activity列表來解決。而要解決第二個可用App或是Activity有兩個以上的問題的話，可以使用系統內建的Intent Chooser，跳出選單讓使用者選擇要使用哪個。
        PackageManager packageManager = getActivity().getPackageManager();
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent, 0);
        if (list.size() > 0) {
            // 如果有可用的Activity
            // 使用Intent Chooser
            Intent destIntent = Intent.createChooser(intent, getString(R.string.load_an_image_from));
            startActivityForResult(destIntent, REQUEST_IMAGE_BROWSE);
        } else {
            // 沒有可用的Activity
            Toast.makeText(getActivity(), getString(R.string.no_app_to_choose_an_image), Toast.LENGTH_SHORT).show();
            Log.d(LOG_TAG, getString(R.string.no_app_to_choose_an_image));
        }
    }

    private void rotateImage() {
        rotateDegree += 90;
        if (rotateDegree >= 360) {
            rotateDegree -= 360;
        }
        Picasso.with(getActivity()).load(mCurrentPhotoUri).rotate((float) rotateDegree).into(imageViewOne);
    }
}
