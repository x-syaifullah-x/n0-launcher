package com.umntv.launcher.util.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.google.android.material.textfield.TextInputLayout;
import net.n0ender.com.R;

public class DialogPassword extends Dialog {

    public interface OnConfirmListener {
        void onConfirm();
    }

    private final String passwordConfirm;

    public DialogPassword(@NonNull Context context, String passwordConfirm) {
        super(context);
        this.passwordConfirm = passwordConfirm;
    }

    private OnConfirmListener onConfirmListener;

    private String inputPasswordHint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.diaolog_input_password);

        if (savedInstanceState == null) {
            int width = (int) (getContext().getResources().getDisplayMetrics().widthPixels * 0.65);
            //            int height = (int)(getResources().getDisplayMetrics().heightPixels*0.80);
            getWindow().setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT);
            getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            final TextInputLayout layoutInputPassword = findViewById(R.id.layout_input_password);
            final EditText etPassword = findViewById(R.id.et_input_password);
            etPassword.setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);
            etPassword.setHint(inputPasswordHint);
            etPassword.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    /**/
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (layoutInputPassword.getError() != null) {
                        layoutInputPassword.setError(null);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {
                    /**/
                }
            });

            Button btnConfirm = findViewById(R.id.btn_confirm);
            btnConfirm.setOnClickListener(v -> {
                String inputPassword = etPassword.getText().toString();
                if (inputPassword.equals(passwordConfirm)) {
                    cancel();
                    if (onConfirmListener != null) {
                        onConfirmListener.onConfirm();
                    }
                } else {
                    layoutInputPassword.setError("wrong password");
                }
            });
        }

    }

    public DialogPassword setInputPasswordHint(String hint) {
        inputPasswordHint = hint;
        return this;
    }

    public DialogPassword setOnConfirmListener(OnConfirmListener onConfirmListener) {
        this.onConfirmListener = onConfirmListener;
        return this;
    }
}
