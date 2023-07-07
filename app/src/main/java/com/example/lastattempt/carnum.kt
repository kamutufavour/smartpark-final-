package com.example.lastattempt

import android.graphics.Bitmap
import android.graphics.Point
import android.os.Bundle
import android.text.TextUtils
import android.view.Display
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.BarcodeFormat


class carnum(name: String, idNum: String, phoneNumber: String, numberPlate: String, carType: String) : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carnum)
        // Get the references to the UI elements
        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val idNumEditText = findViewById<EditText>(R.id.idNumEditText)
        val phoneNumberEditText = findViewById<EditText>(R.id.phoneNumberEditText)
        val numberPlateEditText = findViewById<EditText>(R.id.numberPlateEditText)
        val Typecar = findViewById<TextView>(R.id.Typecar)


                // Get the user input
                val windowManager: WindowManager = getSystemService(WINDOW_SERVICE) as WindowManager
                val display: Display = windowManager.defaultDisplay
                val point: Point = Point()
                val name = nameEditText.text.toString()
                val idNum = idNumEditText.text.toString()
                val phoneNumber = phoneNumberEditText.text.toString()
                val numberPlate = numberPlateEditText.text.toString()
                val carType = Typecar.text.toString()
                // Create a new car registration object
                val carnum = carnum(name, idNum, phoneNumber, numberPlate,carType)
                // Save the car registration to the database
                // TODO: Implement this
                // Show a success message
                Toast.makeText(this, "Car registration successful!", Toast.LENGTH_SHORT).show()

            }
        }


