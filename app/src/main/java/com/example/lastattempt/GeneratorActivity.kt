package com.example.lastattempt

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter

class GeneratorActivity : AppCompatActivity() {

    private lateinit var qrIV: ImageView
    private lateinit var msgEdt: EditText
    private lateinit var generateQRBtn: Button

    private lateinit var bitmap: Bitmap
    private val qrCodeWriter = QRCodeWriter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generator)

        qrIV = findViewById(R.id.idIVQrcode)
        msgEdt = findViewById(R.id.idEdt)
        generateQRBtn = findViewById(R.id.idBtnGenerateQR)




        generateQRBtn.setOnClickListener {
            val windowManager = getSystemService(WINDOW_SERVICE) as WindowManager
            val display = windowManager.defaultDisplay
            val point = Point()
            display.getSize(point)


            val width = point.x
            val height = point.y
            var dimen = if (width < height) width else height
            dimen *= 3 / 4


            val carnum = carnum("car" , "0","07" ,"kc","pr" )
            val contents=
               "carnum: ${carnum.componentName}\nphonenumber: ${carnum.componentName}\nnumplate:${carnum.componentName}"


            try {
                val bitMatrix = qrCodeWriter.encode(contents, BarcodeFormat.QR_CODE, width, height)
                bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)

                val qrCodeImageView = findViewById<ImageView>(R.id.idIVQrcode)
                qrCodeImageView.setImageBitmap(bitmap)
                qrIV.setImageBitmap(bitmap)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            val intent = Intent(this, carnum::class.java)
            startActivity(intent)
        }
    }
}