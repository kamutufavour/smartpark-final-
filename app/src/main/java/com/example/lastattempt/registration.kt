package com.example.lastattempt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.lastattempt.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class registration : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    lateinit var Txt_login:TextView
     lateinit var Edtregmail:TextView
     lateinit var Edtpass:TextView
     lateinit var Edtregconfirmpass:TextView
     lateinit var Btn_Registration:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        Txt_login = findViewById(R.id.Tv_back)
        Edtregmail=findViewById(R.id.EditRegEmail)
        Edtpass=findViewById(R.id.EditRegPass)
        Edtregconfirmpass=findViewById(R.id.EditConfPass)
        Btn_Registration=findViewById(R.id.btn_reg)
        auth= Firebase.auth
        Txt_login.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        Btn_Registration.setOnClickListener {
            Signupuser()
        }
    }
    private fun Signupuser(){
        val email=Edtregmail.text.toString()
        val pass=Edtpass.text.toString()
        val confirmpass=Edtregconfirmpass.text.toString()

        if (email.isBlank()|| pass.isBlank()||confirmpass.isBlank() ){
            Toast.makeText(this,"Password and email can't be blank!", Toast.LENGTH_LONG).show()
            return
        }else if (pass !=confirmpass){
            Toast.makeText(this,"Password does not match", Toast.LENGTH_LONG).show()

        }
        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this){
            if (it.isSuccessful){
                Toast.makeText(this,"singed up succesfully", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Failed to create user", Toast.LENGTH_LONG).show()
            }
        }
    }
}


