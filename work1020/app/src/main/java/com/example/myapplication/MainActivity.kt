package com.example.myapplication

import android.annotation.SuppressLint

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    /*private val ed_name: EditText? = null
    private val tv_text: TextView? = null
    private var tv_name:TextView? = null
    private var tv_winner:TextView? = null
    private var tv_mmora:TextView? = null
    private var tv_cmora:TextView? = null
    private val btn_scissor: RadioButton? = null
    private var btn_stone:RadioButton? = null
    private var btn_paper:RadioButton? = null
    private val btn_mora: Button? = null*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ed_name = findViewById<EditText>(R.id.ed_name)
        val tv_text = findViewById<TextView>(R.id.tv_text)
        val tv_mmora = findViewById<TextView>(R.id.tv_mmora)
        val tv_cmora = findViewById<TextView>(R.id.tv_cmora)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        val tv_winner = findViewById<TextView>(R.id.tv_winner)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val btn_scissor = findViewById<RadioButton>(R.id.btn_scissor)
        val btn_stone = findViewById<RadioButton>(R.id.btn_stone)
        val btn_paper = findViewById<RadioButton>(R.id.btn_paper)
        val btn_mora = findViewById<Button>(R.id.btn_mora)


        btn_mora.setOnClickListener{
            if(ed_name.length()<1)
                tv_text.text = "請輸入玩家姓名"
            else{
                tv_name.text = "名字\n${ed_name.text}"
                tv_mmora.text = "我方出拳\n${if(btn_scissor.isChecked)"剪刀"
                else if(btn_stone.isChecked)"石頭" else "布"}"

                val computer = (Math.random()*3).toInt()
                tv_cmora.text = "電腦出拳\n${if(computer==0)"剪刀"
                else if(computer==1)"石頭" else "布"}"

                when{
                    btn_scissor.isChecked && computer==2 ||
                            btn_stone.isChecked && computer==0 ||
                            btn_paper.isChecked && computer==1 ->{
                        tv_winner.text="勝利者\n${ed_name.text}"
                        tv_text.text = "恭喜你獲勝了!!!"
                    }
                    btn_scissor.isChecked && computer==1 ||
                            btn_stone.isChecked && computer==2 ||
                            btn_paper.isChecked && computer==0 ->{
                        tv_winner.text="勝利者\n電腦"
                        tv_text.text = "可惜，電腦獲勝了!"
                    }
                    else ->{
                        tv_winner.text = "勝利者\n平手"
                        tv_text.text  ="平局，請再試一次"
                    }
                }
            }
        }
    }
}