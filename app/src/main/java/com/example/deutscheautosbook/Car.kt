package com.example.deutscheautosbook

import java.io.Serializable

data class Car(val imageId: Int, val title: String, val desc: String) : Serializable // Класс для хранения данных одного элемента
