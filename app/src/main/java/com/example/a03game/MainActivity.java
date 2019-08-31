/*
package com.example.a03game;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.BufferUnderflowException;


public class MainActivity extends AppCompatActivity {

    private Button mrightbutton = null;//按安卓标准命名
    private Button mleftbutton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mleftbutton = findViewById(R.id.left_button); //寻找xml文件build后R文件里面的按钮控件
        mleftbutton.setText(gamesnum.GetLift());//对按钮里面写入生成的随机数
        mleftbutton.setOnClickListener(MyButton);//设置左边按键的监听
        mrightbutton = findViewById(R.id.right_button);
        mrightbutton.setOnClickListener(When_click2);
        mrightbutton.setText(gamesnum.GetRight());

    }

*/
/*    private View.OnClickListener When_click1 = new View.OnClickListener() {
        //创建一个匿名内部类，因为一个按钮只有这一个事件
        @Override
        public void onClick(View v) {
           flags(1);
        }
    };

    private View.OnClickListener When_click2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            flags(2);
        }
    };
*//*



    private int scores = 0;
    private GamesNum gamesnum = new GamesNum();

    private void flags(int x) {
        if (gamesnum.Which_big() == x) {
            //判断点击是否正确，给予反馈
            Toast.makeText(getApplicationContext(), R.string.you_right, Toast.LENGTH_SHORT).show();
            scores++;
        } else {
            Toast.makeText(getApplicationContext(), R.string.error, Toast.LENGTH_SHORT).show();
            scores--;
        }
        TextView score = findViewById((R.id.score));
        score.setText(getString(R.string.scores) + scores);
        gamesnum.Next();//事件驱动，导致下一个事件触发
     */
/*   mleftbutton = findViewById(R.id.left_button);
        mleftbutton.setText(gamesnum.GetLift());
        mrightbutton = findViewById(R.id.right_button);
        mrightbutton.setText(gamesnum.GetRight());*//*

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mleftbutton = findViewById(R.id.left_button);
        mrightbutton = findViewById(R.id.right_button);
        mleftbutton.setText(gamesnum.GetLift());
        mrightbutton.setText(gamesnum.GetRight());
        //按钮绑定接口
        mleftbutton.setOnClickListener();
        mrightbutton.setOnClickListener(this);
    }
    private class MyButton implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.left_button:
                    flags(1);
                    break;
                case R.id.right_button:
                    flags(2);
                    break;
            }
        }
    }


    class GamesNum {
        private int LiftNumber;
        private int RightNumber;

        public GamesNum() {
            Next();
        }

        public void Next() {
            //生成随机数
            LiftNumber = (int) (Math.random() * 100);
            RightNumber = (int) (Math.random() * 100);
            if (LiftNumber == RightNumber){
                RightNumber++;
            }
            //while (SecondNumber == FirstNumber);
        }

        public String GetLift() {
            return Integer.toString(LiftNumber);
        }

        public String GetRight() {
            return Integer.toString(RightNumber);
        }

        public int Which_big() {
            // 判断生成数哪个大，
            if (LiftNumber > RightNumber)
                return 1;
            else return 2;//设置flag
        }
    }


}
*/
package com.example.a03game;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button mrightbutton = null;//按安卓标准命名
    private Button mleftbutton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mleftbutton = findViewById(R.id.left_button); //寻找xml文件build后R文件里面的按钮控件
        mleftbutton.setText(gamesnum.GetFirst());//对按钮里面写入生成的随机数
        mleftbutton.setOnClickListener(When_click1);//设置左边按键的监听
        mrightbutton = findViewById(R.id.right_button);
        mrightbutton.setOnClickListener(When_click2);
        mrightbutton.setText(gamesnum.GetSecond());

    }

    private View.OnClickListener When_click1 = new View.OnClickListener() {
        //创建一个匿名内部类，因为只有这一个事件
        @Override
        public void onClick(View v) {
            Process(1);
        }
    };

    private View.OnClickListener When_click2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Process(2);
        }
    };

    private int scores = 0;
    private GamesNum gamesnum = new GamesNum();

    private void Process(int x) {
        if (gamesnum.Which_big() == x) {
            //判断点击是否正确，给予反馈
            Toast.makeText(getApplicationContext(), R.string.you_right, Toast.LENGTH_SHORT).show();
            scores++;
        } else {
            Toast.makeText(getApplicationContext(), R.string.error, Toast.LENGTH_SHORT).show();
            scores--;
        }
        // TextView correct = findViewById((R.id.correct));
        TextView score = findViewById((R.id.score));
        score.setText(getString(R.string.scores) + scores);
        gamesnum.Next();
        mleftbutton = findViewById(R.id.left_button);
        mleftbutton.setText(gamesnum.GetFirst());
        mrightbutton = findViewById(R.id.right_button);
        mrightbutton.setText(gamesnum.GetSecond());
    }


    class GamesNum {
        private int FirstNumber;
        private int SecondNumber;

        public GamesNum() {
            Next();
        }

        public void Next() {
            //生成随机数
            FirstNumber = (int) (Math.random() * 100);
            SecondNumber = (int) (Math.random() * 100);
            if (FirstNumber == SecondNumber){
                SecondNumber++;
            }
            //while (SecondNumber == FirstNumber);
        }

        public String GetFirst() {
            return Integer.toString(FirstNumber);
        }

        public String GetSecond() {
            return Integer.toString(SecondNumber);
        }

        public int Which_big() {
            // 判断生成数哪个大，
            if (FirstNumber > SecondNumber)
                return 1;
            else return 2;//设置flag
        }
    }


}