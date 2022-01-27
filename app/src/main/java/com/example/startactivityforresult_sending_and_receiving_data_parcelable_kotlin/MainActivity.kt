package com.example.startactivityforresult_sending_and_receiving_data_parcelable_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.startactivityforresult_sending_and_receiving_data_parcelable_kotlin.model.User

class MainActivity : AppCompatActivity() {
    lateinit var tv_first: TextView
    lateinit var btn_send: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        tv_first = findViewById(R.id.tv_first)
        btn_send = findViewById(R.id.btn_send)

        btn_send.setOnClickListener {
            openDetailsActivity()
        }
    }

    private fun openDetailsActivity() {
        var intent = Intent(this,DetailsActivity::class.java)
        intent.putExtra("user", User("Sarvar",21,'M'))
        startActivityForResult(intent,1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                tv_first.text = data?.getParcelableExtra<User>("result").toString()
            }
            if(resultCode == RESULT_CANCELED){
                tv_first.text = "Nothing selected"
            }
        }
    }
}