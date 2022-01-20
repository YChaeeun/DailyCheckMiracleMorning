package com.chaen.dailycheckmiraclemorning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chaen.dailycheckmiraclemorning.model.Day
import com.chaen.dailycheckmiraclemorning.ui.calendar.DayItem
import com.chaen.dailycheckmiraclemorning.ui.calendar.Header
import com.chaen.dailycheckmiraclemorning.ui.theme.DailyCheckMiracleMorningTheme

class MainActivity : ComponentActivity() {

	private val viewModel by viewModels<MainViewModel>()

	@ExperimentalFoundationApi
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			DailyCheckMiracleMorningTheme {
				CalendarView(viewModel)
			}
		}
	}
}

@ExperimentalFoundationApi
@Composable
fun CalendarView(viewModel: MainViewModel) {
	Column(
		Modifier
			.fillMaxSize()
			.padding(horizontal = 16.dp)
			.padding(top = 45.dp)) {
		Header(viewModel.getHeaderTitle())
		SetCalendarDay(viewModel.getDays())
	}
}


@ExperimentalFoundationApi
@Composable
fun SetCalendarDay(days: List<Day>) {
	LazyVerticalGrid(cells = GridCells.Fixed(7)) {
		items(days) { item ->
			val colorModifier = if (item.isToday) Modifier.background(Color.LightGray) else Modifier
			DayItem(colorModifier, item)
		}
	}
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun CalendarView_Preview() {
	DailyCheckMiracleMorningTheme {
		CalendarView(MainViewModel())
	}
}