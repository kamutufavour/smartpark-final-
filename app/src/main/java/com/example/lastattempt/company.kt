package com.example.lastattempt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class company : AppCompatActivity() {
    lateinit var btn_ind:Button
    lateinit var btn_org:Button
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company)
        btn_ind=findViewById(R.id.btn_ind)
        btn_org=findViewById(R.id.btn_org)

        btn_ind.setOnClickListener {
            val intent=Intent(this,carnum::class.java)
            startActivity(intent)
        }
        btn_org.setOnClickListener {
            val intent=Intent(this,organisation::class.java)
            startActivity(intent)
        }

    }
}