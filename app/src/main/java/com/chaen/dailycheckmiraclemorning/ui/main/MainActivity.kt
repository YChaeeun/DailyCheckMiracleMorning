package com.chaen.dailycheckmiraclemorning.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.chaen.dailycheckmiraclemorning.ui.calendar.Day
import com.chaen.dailycheckmiraclemorning.ui.calendar.WeekNameHeader
import com.chaen.dailycheckmiraclemorning.ui.calendar.YearMonthHeader
import com.chaen.dailycheckmiraclemorning.ui.theme.DailyCheckMiracleMorningTheme

class MainActivity : ComponentActivity() {

	private val viewModel by viewModels<MainViewModel>()

	@OptIn(ExperimentalFoundationApi::class)
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
	HeaderView(viewModel)

	LazyVerticalGrid(cells = GridCells.Fixed(7)) {
		items(viewModel.getDays()) { item ->
			Day(Icons.Default.AccountBox, item)
		}
	}
}

@Composable
fun HeaderView(viewModel: MainViewModel) {
	YearMonthHeader(viewModel.getHeaderTitle())
	Spacer(modifier = Modifier.height(20.dp))
	WeekNameHeader()
}

@ExperimentalFoundationApi
@Composable
@Preview(showBackground = true)
fun CalendarView_Preview() {
	DailyCheckMiracleMorningTheme {
		Column {
			CalendarView(MainViewModel())
		}
	}
}