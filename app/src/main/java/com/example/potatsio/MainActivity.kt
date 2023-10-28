package com.example.potatsio

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val uri = Uri.parse("content://com.example.charlitaeko.SuanfonsonProvider/files/../shared_prefs/")

        val CountryContentProvider = uri
        var pwd: String? = null
        val c = contentResolver.query(CountryContentProvider, null, null, null, null)
        c?.use {
            while (it.moveToNext()) {
                pwd = it.getString(it.getColumnIndex("file_content"))
            }
            Log.i("MainActivity", "Archivo Extraido: $pwd")
        }
    }
}