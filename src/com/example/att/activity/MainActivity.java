package com.example.att.activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.att.R;
import com.example.att.view.LineView;

public class MainActivity extends Activity {

    private LineView mLineView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mLineView = (LineView) findViewById(R.id.linegraph);
        mLineView.addLine(45f);
        mLineView.addLine(150f);
        mLineView.addLine(250f);
    }

}
