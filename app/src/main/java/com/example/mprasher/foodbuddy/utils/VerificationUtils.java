package com.example.mprasher.foodbuddy.utils;

import android.text.TextUtils;

/**
 * Created by mprasher on 2016-09-30.
 */

public class VerificationUtils {
    public static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
