package com.umntv.launcher.util.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.google.android.material.textfield.TextInputLayout;

import net.n0ender.com.R;

public class DialogEnterCode extends Dialog {

    public interface OnConfirmListener {
        void onEnterCode(String code);
    }

    public DialogEnterCode(@NonNull Context context) {
        super(context);
    }

    private String buttonEnterText = null;

    public DialogEnterCode(@NonNull Context context, String buttonEnterText) {
        super(context);
        this.buttonEnterText = buttonEnterText;
    }

    private OnConfirmListener onConfirmListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.diaolog_enter_code);

        if (savedInstanceState == null) {
            int width = (int) (getContext().getResources().getDisplayMetrics().widthPixels * 0.65);
            //            int height = (int)(getResources().getDisplayMetrics().heightPixels*0.80);
            getWindow().setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT);
            getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            final TextInputLayout layoutInputPassword = findViewById(R.id.layout_input_password);
            final EditText etPassword = findViewById(R.id.et_input_password);
            etPassword.setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);

            Button btnConfirm = findViewById(R.id.btn_confirm);
            if (buttonEnterText != null) {
                btnConfirm.setText(buttonEnterText);
            }
            btnConfirm.setOnClickListener(v -> {
                String inputPassword = etPassword.getText().toString();
                if (onConfirmListener != null) {
                    onConfirmListener.onEnterCode(inputPassword);
                    cancel();
                }
            });
        }

    }

    public DialogEnterCode setOnConfirmListener(OnConfirmListener onConfirmListener) {
        this.onConfirmListener = onConfirmListener;
        return this;
    }
}
