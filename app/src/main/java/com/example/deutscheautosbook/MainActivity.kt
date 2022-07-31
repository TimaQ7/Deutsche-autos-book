package com.example.deutscheautosbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deutscheautosbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = CarAdapter()
    private val imageIdList = listOf(
        R.drawable.audi,
        R.drawable.audi2,
        R.drawable.bmw,
        R.drawable.bmw2,
        R.drawable.mercedes,
        R.drawable.porsche,
        R.drawable.volkswagen
    )
    private var index = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            rcView.adapter = adapter
            buttonAdd.setOnClickListener {
                if (index > 6) index = 0
                val car = Car(imageIdList[index], "Car $index")
                adapter.addCar(car)
                index++
            }
        }
    }
}