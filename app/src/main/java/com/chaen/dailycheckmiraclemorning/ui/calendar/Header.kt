package com.chaen.dailycheckmiraclemorning.ui.calendar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.chaen.dailycheckmiraclemorning.ui.theme.DailyCheckMiracleMorningTheme


@Composable
fun YearMonthHeader(yearMonth: String) {
	Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
		Text(
			text = yearMonth,
			style = MaterialTheme.typography.h4
		)
	}
}


@Composable
fun WeekNameHeader() {
	Row(Modifier.fillMaxWidth()) {
		Week.values().forEach {
			Text(modifier = Modifier.weight(1f), text = it.weekName, textAlign = TextAlign.Center, style = MaterialTheme.typography.caption)

		}
	}
}


@Composable
@Preview(showBackground = true)
fun YearMonthHeader_Preview() {
	DailyCheckMiracleMorningTheme {
		YearMonthHeader("2022 JAN")
	}
}

@Composable
@Preview(showBackground = true)
fun WeekHeader_Preview() {
	DailyCheckMiracleMorningTheme {
		WeekNameHeader()
	}
}