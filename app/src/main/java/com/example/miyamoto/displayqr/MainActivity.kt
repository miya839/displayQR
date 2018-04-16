package com.example.miyamoto.displayqr

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel
import com.journeyapps.barcodescanner.BarcodeEncoder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)

        button.setOnClickListener(){
            generateQR(editText.getText().toString())
        }

    }

    private fun generateQR(text: String){
        val format = BarcodeFormat.QR_CODE
        val width = 1000
        val height = width

        val hint = HashMap<EncodeHintType, Any>()
        hint.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M)
        hint.put(EncodeHintType.MARGIN, 0)

        val barcode = BarcodeEncoder()
        val bitmap = barcode.encodeBitmap(text, format, width, height, hint)
        val imageViewQRCode = findViewById<ImageView>(R.id.imageView)
        imageViewQRCode.setImageBitmap(bitmap)
    }
}
