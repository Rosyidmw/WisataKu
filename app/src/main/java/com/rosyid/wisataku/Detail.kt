package com.rosyid.wisataku

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

class Detail : AppCompatActivity() {

    companion object {
        const val key_wisata = "key_wisata"
    }



    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataWisata = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Wisata>(key_wisata, Wisata::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Wisata>(key_wisata)
        }



        if (dataWisata != null) {
            val tvJudul: TextView = findViewById(R.id.tvJudul)
            val tvDesc: TextView = findViewById(R.id.tvDesc)
            val ivImg: ImageView = findViewById(R.id.imageView)

            tvJudul.text = dataWisata.name
            tvDesc.text = dataWisata.description
            ivImg.setImageResource(dataWisata.photo)
        }

        val actionBar = supportActionBar
        actionBar!!.title = "Detail Wisata"

        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}