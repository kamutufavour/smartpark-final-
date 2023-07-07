package com.example.lastattempt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.lastattempt.R
import com.example.smartpark.registration
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var Txt_gotoreg: TextView
    lateinit var Edtemail: EditText
    lateinit var Edtpass: EditText
    lateinit var Btnlogin: Button
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Txt_gotoreg=findViewById(R.id.TV_login)
        Edtemail=findViewById(R.id.EditlogEmail)
        Edtpass=findViewById(R.id.EditlogPass)
        Btnlogin=findViewById(R.id.btn_login)
        auth= Firebase.auth
        Txt_gotoreg.setOnClickListener {
            val intent= Intent(this, registration::class.java)
            startActivity(intent)
        }
        Btnlogin.setOnClickListener {

        }

    }
    private fun login(){
        val email=Edtemail.text.toString()
        val pass=Edtpass.text.toString()
        auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this){
            if(it.isSuccessful){
                Toast.makeText(this,"Successfully logged in", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"log in failed", Toast.LENGTH_LONG).show()
            }
        }
    }
}