package com.example.lastattempt

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Camera
import android.nfc.tech.NfcBarcode
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceHolder
import android.widget.Toast
import com.example.lastattempt.databinding.ActivityScannerBinding
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.barcode.Barcode
import com.google.android.gms.vision.barcode.BarcodeDetector
import com.google.firebase.auth.FirebaseAuth
import com.google.zxing.aztec.detector.Detector
import java.io.IOException


class scanner : AppCompatActivity() {
    lateinit var binding: ActivityScannerBinding
    lateinit var barcodeDetector: BarcodeDetector
    var intentData = ""
    lateinit var cameraSource: Camera
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScannerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth=FirebaseAuth.getInstance()


    }
    private fun iniBc(){
        barcodeDetector= barcodeDetector.Builder(this)
            .setBarcodeFormats(Barcode.ALL_FORMATS)
            .build()
        cameraSource= CameraSource.Builder(this,barcodeDetector)
            .setRequestedPreviewSize(1920,1080)
            .setAutoFocusEnabled(true)
            .setFacing(CameraSource.CAMERA_FACING_BACK)
            .build()

        binding.surfaceview!!.holder.addCallback(object : SurfaceHolder.Callback{
            @SuppressLint("MissingPermission")
            override fun surfaceCreated(p0: SurfaceHolder) {
                try{
                    cameraSource.start(binding.surfaceview!!.holder)
                }catch (e: IOException) {
                    e.printStackTrace()
                }
            }

            override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {

            }

            override fun surfaceDestroyed(p0: SurfaceHolder) {
                cameraSource.stop()
            }

        })
        barcodeDetector.setProcessor(object : Detector.Processor<Barcode>,
            com.google.android.gms.vision.Detector.Processor<Barcode> {
            override fun release() {
                Toast.makeText(
                    applicationContext, "barcode scanner has been stopped",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun receiveDetections(p0: Detector.Detections<Barcode>) {
                var barcodes = p0.detectedItems
                if (barcodes.size()!=0){
                    binding.txtBarcodeValue!!.post{
                        binding.btnAction.text="SEARCH USER"
                        intentData=barcodes.valueAt(0).displayValue
                        binding.txtBarcodeValue.setText(intentData)


                        var intent= Intent(this@scanner, carnum::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        } )
    }

    override fun onPause() {
        super.onPause()
        cameraSource!!.release()
    }

    override fun onResume() {
        super.onResume()
        iniBc()
    }

}
