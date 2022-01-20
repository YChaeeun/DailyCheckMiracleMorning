package com.chaen.dailycheckmiraclemorning

import androidx.lifecycle.ViewModel
import com.chaen.dailycheckmiraclemorning.model.Day
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

class MainViewModel : ViewModel() {

	private val today = SimpleDateFormat("d", Locale.ENGLISH).format(System.currentTimeMillis())

	fun getHeaderTitle(): String {
		return SimpleDateFormat("yyyy  MMM", Locale.ENGLISH).format(System.currentTimeMillis()) // 2022 Jan
	}

	fun getDays(): List<Day> {
		val calendar = Calendar.getInstance()

		val days = mutableListOf<Day>()

		calendar.set(Calendar.DAY_OF_MONTH, 1)
		val beginningCell = calendar.get(Calendar.DAY_OF_WEEK) - 1
		calendar.clear()

		for (i in 0 until beginningCell) {
			days.add(Day(0, 0))
		}

		// test
		val randomDots = Random.nextInt(0, 5)

		val lastDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
		(1..lastDayOfMonth).forEach { days.add(Day(it, randomDots, it.toString() == today)) }

		return days.toList()
	}
}