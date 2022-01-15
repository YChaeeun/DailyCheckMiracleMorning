package com.chaen.dailycheckmiraclemorning.ui.calendar

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chaen.dailycheckmiraclemorning.ui.theme.DailyCheckMiracleMorningTheme

@Composable
fun Header() {
	Column(
		Modifier
			.fillMaxWidth()
			.padding(bottom = 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
		YearMonthTitle()
		Spacer(modifier = Modifier.height(25.dp))
		WeekTitle()
		Divider(
			Modifier
				.padding(top = 7.dp)
				.padding(horizontal = 5.dp))
	}
}

@Composable
fun YearMonthTitle() {
	Row {
		Text(text = "2022 JAN", style = MaterialTheme.typography.h6)
	}
}

@Composable
fun WeekTitle() {
	val weekTitle = listOf("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT")

	Row(Modifier.fillMaxWidth()) {
		for (title in weekTitle) {
			Text(modifier = Modifier.weight(1f), text = title, textAlign = TextAlign.Center, style = MaterialTheme.typography.caption)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun Header_Preview() {
	DailyCheckMiracleMorningTheme {
		Header()
	}
}