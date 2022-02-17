package com.chaen.dailycheckmiraclemorning.ui.calendar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chaen.dailycheckmiraclemorning.ui.theme.DailyCheckMiracleMorningTheme

@Composable
fun Day(icon: ImageVector, day: Int) {
	Column(Modifier.padding(6.dp)) {
		if (day > 0) {
			Icon(
				icon,
				contentDescription = icon.name,
				modifier = Modifier
					.align(Alignment.CenterHorizontally)
					.defaultMinSize(60.dp, 60.dp)
			)

			Text(
				modifier = Modifier.align(Alignment.CenterHorizontally),
				text = day.toString(),
				style = MaterialTheme.typography.body2
			)
		}
	}
}


@Composable
@Preview(showBackground = true)
fun Day_Preview() {
	DailyCheckMiracleMorningTheme {
		Day(Icons.Default.AccountBox, 1)
	}
}