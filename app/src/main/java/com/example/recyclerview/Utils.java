package com.example.recyclerview;

import android.content.Context;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Utils {
    public static void toast(Context context, String message) {
        Toast.makeText(context, message,
                Toast.LENGTH_SHORT).show();
    }

    public static void showAlertDialog(Context context) {
        AlertDialog.Builder alertDialog = new
                AlertDialog.Builder(context)
                .setTitle(R.string.alert_title)
                .setMessage(R.string.alert_message)
                .setPositiveButton("Ok", (d, w) -> toast(context, "Ok clicked"))
                .setNegativeButton("Cancel", (d, w) -> toast(context, "which " + w));
        alertDialog.show();
    }
}
