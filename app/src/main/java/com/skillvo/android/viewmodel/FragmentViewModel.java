package com.skillvo.android.viewmodel;

import android.content.Intent;
import android.support.v4.app.Fragment;

public interface FragmentViewModel {

    void onCreateView(Fragment fragment);

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onResume(Fragment activity);

    void onPause(Fragment activity);

    void onDestroy();
}
