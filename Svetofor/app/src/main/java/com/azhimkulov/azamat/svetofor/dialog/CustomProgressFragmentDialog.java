package com.azhimkulov.azamat.svetofor.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;

import com.azhimkulov.azamat.svetofor.R;

/**
 * Created by azamat  on 03.04.18.
 */

public class CustomProgressFragmentDialog extends Dialog {
    public CustomProgressFragmentDialog(@NonNull Context context) {
        super(context, R.style.TransparentProgressDialog);
        setContentView(R.layout.custom_dialog);
        setCancelable(false);
        setOnCancelListener(null);
    }
}
