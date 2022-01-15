package com.chaen.dailycheckmiraclemorning

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

	var liveAnimals = MutableLiveData<List<Animal>>()
	private var nextPage = 0

	fun getAnimals() {
		val animals = liveAnimals.value?.toMutableList() ?: mutableListOf()

		when (nextPage % 2) {
			0 -> {
				animals.addAll(
					listOf(
						Animal(1, "cat"),
						Animal(2, "cat"),
						Animal(3, "cat"),
						Animal(4, "cat"),
						Animal(5, "cat"),
						Animal(6, "cat"),
						Animal(7, "cat"),
						Animal(8, "cat"),
						Animal(9, "cat"),
						Animal(10, "cat"),
						Animal(11, "cat"),
						Animal(12, "cat"),
						Animal(13, "cat"),
						Animal(14, "cat"),
						Animal(15, "cat"),
						Animal(16, "cat"),
						Animal(17, "cat"),
						Animal(18, "cat"),
						Animal(19, "cat"),
						Animal(20, "cat")
					)
				)
			}
			1 -> {
				animals.addAll(
					listOf(
						Animal(21, "cat"),
						Animal(22, "cat"),
						Animal(23, "cat"),
						Animal(24, "cat"),
						Animal(25, "cat"),
						Animal(26, "cat"),
						Animal(27, "cat"),
						Animal(28, "cat"),
						Animal(29, "cat"),
						Animal(30, "cat"),
						Animal(31, "cat"),
						Animal(32, "cat"),
						Animal(33, "cat"),
						Animal(34, "cat"),
						Animal(35, "cat"),
						Animal(36, "cat"),
						Animal(37, "cat"),
						Animal(38, "cat"),
						Animal(39, "cat"),
						Animal(40, "cat")
					)
				)
			}
		}

		liveAnimals.value = animals
		nextPage++
	}
}