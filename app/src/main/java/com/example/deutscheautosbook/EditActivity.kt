package com.example.deutscheautosbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.deutscheautosbook.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    private var indexImage = 0
    private var imageId = R.drawable.audi
    private val imageIdList = listOf(
        R.drawable.audi,
        R.drawable.audi2,
        R.drawable.bmw,
        R.drawable.bmw2,
        R.drawable.mercedes,
        R.drawable.porsche,
        R.drawable.volkswagen
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButton()
    }

    private fun initButton() = with(binding) {
        bNext.setOnClickListener {
            indexImage++
            if(indexImage > imageIdList.size - 1) indexImage = 0
            imageId = imageIdList[indexImage]
            imageView.setImageResource(imageId)
        }
        bDone.setOnClickListener {
            val car = Car(imageId,edTitle.text.toString(), edDesc.text.toString())
            val editIntent = Intent().apply {
                putExtra("car", car)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }
}