package com.chaen.dailycheckmiraclemorning.ui.calendar

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chaen.dailycheckmiraclemorning.ui.theme.DailyCheckMiracleMorningTheme
import kotlin.random.Random

@Composable
fun DayItem(day: Int) {
	Column(
		Modifier.padding(vertical = 14.dp),
		verticalArrangement = Arrangement.Center) {
		Text(
			modifier = Modifier.align(Alignment.CenterHorizontally),
			color = Color.DarkGray,
			text = if (day == 0) "" else day.toString(),
			style = MaterialTheme.typography.h6)

		if (day > 0) {
			Spacer(modifier = Modifier.height(10.dp))
			Dots(Modifier.align(Alignment.CenterHorizontally).padding(horizontal = 3.dp))
		}
	}
}

@Composable
fun Dots(modifier: Modifier = Modifier) {
	val colors = listOf(Color.Blue, Color.Gray, Color.Red, Color.Green, Color.Yellow, Color.Cyan)

	val random = Random.nextInt(0, 5)

	Row(modifier) {
		for (i in 0 until random) {
			val randomIdx = Random.nextInt(0, colors.size)
			DrawDot(color = colors[randomIdx])
		}
	}
}

@Composable
fun DrawDot(color: Color) {
	Canvas(Modifier.size(10.dp, 10.dp)) {
		val canvasWidth = this.size.width
		val canvasHeight = this.size.height
		drawCircle(
			color = color,
			center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
			radius = size.minDimension / 4
		)
	}
}


@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DayItem_Preview() {
	DailyCheckMiracleMorningTheme {
		val dayList = (0..31).toList()

		LazyVerticalGrid(cells = GridCells.Fixed(7)) {
			items(dayList) { item ->
				DayItem(item)
			}
		}
	}
}