package com.example.zhiyong.food;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

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
    private List<Food> lists_food;
    private List<Food> lists_found;
    private Person person;
    private RadioGroupListener radioGroupListener;
    private boolean isSpicy, isSeafood, isSour; //定义筛选项
    private CheckBoxListener checkBoxListener;
    private int price = 30;
    private SeekBarListener seekBarListener;
    private ButtonListener buttonListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
//        初始化控件
        initView();
//        初始化数据
        initDate();
//        为控件添加监听器
        setListener();
    }

    private void setListener(){

        radioGroupListener = new RadioGroupListener();
//        这个sex, 是 --> private RadioGroup sex;
        sex.setOnCheckedChangeListener(radioGroupListener);
        checkBoxListener = new CheckBoxListener();
        spicy.setOnCheckedChangeListener(checkBoxListener);
        seafood.setOnCheckedChangeListener(checkBoxListener);
        sour.setOnCheckedChangeListener(checkBoxListener);
        seekBarListener = new SeekBarListener();
        seekBar.setOnSeekBarChangeListener(seekBarListener);
        buttonListener = new ButtonListener();
        find.setOnClickListener(buttonListener);
        toggleButton.setOnClickListener(buttonListener);
    }

    private void initView() {
        name = findViewById(R.id.edittext);
        sex = findViewById(R.id.rg_sex);
        spicy = findViewById(R.id.spicy);
        seafood = findViewById(R.id.seafood);
        sour = findViewById(R.id.sour);
        seekBar = findViewById(R.id.sb_01);
//        给seekBar一个默认值
        seekBar.setProgress(30);
        find = findViewById(R.id.btn_01);
        toggleButton = findViewById(R.id.togglebutton);

    }

    private void initDate() {
        person = new Person();
        lists_food = new ArrayList<>();
        lists_found = new ArrayList<>();
        lists_food.add(new Food("麻辣香锅", 55, R.drawable.malahuoguo, true,
                false, false));
        lists_food.add(new Food("上汤娃娃菜", 28, R.drawable.wawacai, false,
                false, false));
        lists_food.add(new Food("水煮鱼", 48, R.drawable.shuizhuyu, true,
                true, false));
        lists_food.add(new Food("清蒸鲈鱼", 68, R.drawable.malahuoguo, false,
                true, false));
        lists_food.add(new Food("麻辣火锅", 80, R.drawable.malahuoguo, true,
                true, false));
        lists_food.add(new Food("桂林米粉", 15, R.drawable.malahuoguo, false,
                false, false));
        lists_food.add(new Food("红烧肉", 60, R.drawable.malahuoguo, false,
                false, false));
        lists_food.add(new Food("木须肉", 40, R.drawable.malahuoguo, false,
                false, false));
        lists_food.add(new Food("西芹炒百合", 38, R.drawable.malahuoguo, false,
                false, false));
        lists_food.add(new Food("酸菜牛肉面", 35, R.drawable.malahuoguo, false,
                false, true));
        lists_food.add(new Food("酸辣汤", 40, R.drawable.malahuoguo, true,
                false, true));

    }

    class RadioGroupListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
//            当用户选择当前radio group的button时触发
            switch (checkedId){

                case R.id.rb_man:
                    person.setSex("男");
                    break;

                case R.id.rb_woman:
                    person.setSex("女");
                    break;
            }
        }
    }

    class CheckBoxListener implements android.widget.CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//            当控件状态改变时触发
            CheckBox cbb = (CheckBox) buttonView;
            switch (cbb.getId()){

                case R.id.spicy:
                    if (isChecked){
                        isSpicy = true;
                    }else {
                        isSpicy = false;
                    }
                    break;

                case R.id.seafood:
                    if (isChecked){
                        isSeafood = true;
                    }else {
                        isSeafood = false;
                    }
                    break;

                case R.id.sour:
                    if (isChecked){
                        isSour = true;
                    }else {
                        isSour = false;
                    }
                    break;

            }

        }
    }

    class SeekBarListener implements SeekBar.OnSeekBarChangeListener{

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

//            当用户停止拖拽的时候触发
            price = seekBar.getProgress();
            Toast.makeText(MainActivity.this, "价格" + price, Toast.LENGTH_SHORT).show();


        }
    }

    class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){

                case R.id.btn_01:
//                    当用户点击寻找时, 需要筛查信息
//                    并把结果显示在imageView上
                    checkDate();
                    break;

                case R.id.togglebutton:

                    break;
            }
        }
    }

    private void checkDate() {

//        找出菜品
//        通过循环遍历, 当前所有原始数据, 找出数据中符合用户选择条件的内容
        for (int i = 0;i<lists_food.size(); i++){
            Food food = lists_food.get(i);
//            菜品价格, 小于等于预算
            if ((food.getPrice()<=price)&&(food.isSeafood()==isSeafood)&&(food.isSour()==
                    isSour) && (food.isSpicy() == isSpicy)){
                lists_found.add(food);

            }
        }
        System.out.println("**************" + lists_found.size());


    }


}
