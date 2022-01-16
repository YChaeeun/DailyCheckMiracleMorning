package com.chaen.dailycheckmiraclemorning

import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel : ViewModel() {

	private val calendar = Calendar.getInstance()

	fun getHeaderTitle(): String {
		return SimpleDateFormat("yyyy  MMM", Locale.ENGLISH).format(calendar.time) // 2022 Jan
	}

	fun getDays(): List<Int> {
		val days = mutableListOf<Int>()

		calendar.set(Calendar.DAY_OF_MONTH, 1)
		val beginningCell = calendar.get(Calendar.DAY_OF_WEEK) - 1

		for (i in 0 until beginningCell) {
			days.add(0)
		}

		val lastDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
		(1..lastDayOfMonth).forEach { days.add(it) }

		return days.toList()
	}
}