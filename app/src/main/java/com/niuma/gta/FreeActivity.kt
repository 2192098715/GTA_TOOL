package com.niuma.gta

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar

class FreeActivity : AppCompatActivity() {
    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_free)
        //神刀
        val button1: Button = findViewById(R.id.free_button1)
        button1.setOnClickListener {
            Snackbar.make(
                findViewById(R.id.free_button1),
                R.string.activity_main_snackbar1,
                Snackbar.LENGTH_SHORT
            ).show()
        }
        //召唤神剑
        val button2: Button = findViewById(R.id.free_button2)
        button2.setOnClickListener {
            Snackbar.make(
                findViewById(R.id.free_button2),
                R.string.activity_main_snackbar1,
                Snackbar.LENGTH_SHORT
            ).show()
        }
        //手电筒
        val button3: Button = findViewById(R.id.free_button3)
        button3.setOnClickListener {
            Snackbar.make(
                findViewById(R.id.free_button3),
                R.string.activity_main_snackbar1,
                Snackbar.LENGTH_SHORT
            ).show()
        }
        //不会犯罪
        val button4: Button = findViewById(R.id.free_button4)
        button4.setOnClickListener {
            Snackbar.make(
                findViewById(R.id.free_button4),
                R.string.activity_main_snackbar1,
                Snackbar.LENGTH_SHORT
            ).show()
        }
        //主角无敌
        val button5: Button = findViewById(R.id.free_button5)
        button5.setOnClickListener {
            Snackbar.make(
                findViewById(R.id.free_button5),
                R.string.activity_main_snackbar1,
                Snackbar.LENGTH_SHORT
            ).show()
        }
        //金钱全满
        val button6: Button = findViewById(R.id.free_button6)
        button6.setOnClickListener {
            Snackbar.make(
                findViewById(R.id.free_button6),
                R.string.activity_main_snackbar1,
                Snackbar.LENGTH_SHORT
            ).show()
        }
        //绿色按钮
        val button7: Button = findViewById(R.id.free_button7)
        button7.setOnClickListener {
            Snackbar.make(
                findViewById(R.id.free_button7),
                R.string.activity_main_snackbar1,
                Snackbar.LENGTH_SHORT
            ).show()
        }
        //自动驾驶
        val button8: Button = findViewById(R.id.free_button8)
        button8.setOnClickListener {
            Snackbar.make(
                findViewById(R.id.free_button8),
                R.string.activity_main_snackbar1,
                Snackbar.LENGTH_SHORT
            ).show()
        }
        //视频教程
        val button9: Button = findViewById(R.id.free_button9)
        button9.setOnClickListener {
            Snackbar.make(
                findViewById(R.id.free_button9),
                R.string.activity_main_snackbar1,
                Snackbar.LENGTH_SHORT
            ).show()
        }
        //游戏安装
        val button10: Button = findViewById(R.id.free_button10)
        button10.setOnClickListener {
            Snackbar.make(
                findViewById(R.id.free_button10),
                R.string.activity_main_snackbar1,
                Snackbar.LENGTH_SHORT
            ).show()
        }
        //清除已加入技能
        val button11: Button = findViewById(R.id.free_button11)
        button11.setOnClickListener {
            Snackbar.make(
                findViewById(R.id.free_button11),
                R.string.activity_main_snackbar1,
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }
}