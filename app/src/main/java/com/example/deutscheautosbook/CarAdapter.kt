package com.example.deutscheautosbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deutscheautosbook.databinding.CarItemBinding

class CarAdapter : RecyclerView.Adapter<CarAdapter.CarHolder>() {
    val carList = ArrayList<Car>() // список заполняемых данных с класса Car

    class CarHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = CarItemBinding.bind(item)
        fun bind(car: Car) = with(binding) {
            im.setImageResource(car.imageId)
            tvTitle.text = car.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarHolder { // функция надувает наш шаблон (берет нашу разметку, которая находится в файле и превращает ее в VIEW, который хранится в памяти
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_item, parent, false)
        return CarHolder(view)
    }

    override fun onBindViewHolder(holder: CarHolder, position: Int) {
        holder.bind(carList[position])
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    fun addCar(car: Car) {
        carList.add(car)
        notifyDataSetChanged() // уведомляем адаптер, что список обновился (перерисовывает)
    }
}