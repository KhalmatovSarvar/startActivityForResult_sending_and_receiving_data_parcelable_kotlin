package com.example.startactivityforresult_sending_and_receiving_data_parcelable_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.startactivityforresult_sending_and_receiving_data_parcelable_kotlin.model.User

class DetailsActivity : AppCompatActivity() {

    lateinit var tv_second: TextView
    lateinit var btn_sendBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        setTitle("Details Activity")

        initViews()
    }

    private fun initViews() {

        tv_second = findViewById(R.id.tv_second)
        btn_sendBack = findViewById(R.id.btn_sendback)

        var user = intent.getParcelableExtra<User>("user")

        tv_second.text = user.toString()

        btn_sendBack.setOnClickListener {
            returnMain()
        }

    }

    private fun returnMain() {
        var intent = Intent()
        intent.putExtra("result", User("Sherzod", 21, 'M'))
        setResult(RESULT_OK, intent)
        finish()
    }
}