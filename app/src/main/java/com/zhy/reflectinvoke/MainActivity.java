package com.zhy.reflectinvoke;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.zhy.reflectinvoke.inject.BindView;
import com.zhy.reflectinvoke.inject.InjectUtils;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_text)
    TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InjectUtils.injectView(this);
        tvText.setText("Hello BindView.......");
    }
}