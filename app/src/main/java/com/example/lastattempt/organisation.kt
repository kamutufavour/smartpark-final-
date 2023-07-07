package com.example.lastattempt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class organisation : AppCompatActivity() {
    lateinit var Txt_details: TextView
    lateinit var Edtorg: EditText
    lateinit var Edtemail: EditText
    lateinit var Edtpass: EditText
    lateinit var auth: FirebaseAuth
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organisation)
        Txt_details = findViewById(R.id.orgdetails)
        Edtorg = findViewById(R.id.orgname)
        Edtemail = findViewById(R.id.Edtemail2)
        Edtpass = findViewById(R.id.edword)
        button = findViewById(R.id.btnUpdate)
        auth = Firebase.auth

        Txt_details.setOnClickListener {
            val intent = Intent(this, scanner::class.java)
            startActivity(intent)

             fun login() {
                val email = Edtemail.text.toString()
                val pass = Edtpass.text.toString()
                auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Successfully logged in", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "log in failed", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}