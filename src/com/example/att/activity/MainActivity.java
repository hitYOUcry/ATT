package com.example.att.activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.att.R;
import com.example.att.view.LineGraph;

public class MainActivity extends Activity {

    private LineGraph mLineView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mLineView = (LineGraph) findViewById(R.id.linegraph);
        mLineView.addLine(45f);
        mLineView.addLine(150f);
        mLineView.addLine(250f);
        mLineView.setLineNums(6);
    }

}
