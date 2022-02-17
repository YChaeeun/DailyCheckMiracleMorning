package com.chaen.dailycheckmiraclemorning.ui.calendar

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chaen.dailycheckmiraclemorning.ui.theme.DailyCheckMiracleMorningTheme


@Composable
fun YearMonthHeader(year: String, month: Int) {
	Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
		Text(
			text = year,
			style = MaterialTheme.typography.h4
		)

		Spacer(modifier = Modifier.width(10.dp))

		Text(
			text = month.toString(),
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
		YearMonthHeader("2022", 1)
	}
}

@Composable
@Preview(showBackground = true)
fun WeekHeader_Preview() {
	DailyCheckMiracleMorningTheme {
		WeekNameHeader()
	}
}