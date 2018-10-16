package com.example.zhiyong.food;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.ToggleButton;

/*
步骤:
1. 初始化控件
2. 初始化数据
3. 为控件添加监听器

 */
public class MainActivity extends AppCompatActivity {
    private EditText name;
    private RadioGroup sex;
    private CheckBox spicy, seafood, sour;
    private SeekBar seekBar;
    private Button find;
    private ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        initView();
    }

    private void initView() {
        name = findViewById(R.id.edittext);
        sex = findViewById(R.id.rg_sex);
        spicy = findViewById(R.id.spicy);
        seafood = findViewById(R.id.seafood);
        sour = findViewById(R.id.sour);
        seekBar = findViewById(R.id.sb_01);
        find = findViewById(R.id.btn_01);
        toggleButton = findViewById(R.id.togglebutton);
    }
}
