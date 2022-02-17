package com.chaen.dailycheckmiraclemorning.ui.calendar

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.chaen.dailycheckmiraclemorning.ui.theme.DailyCheckMiracleMorningTheme

@Composable
fun Day(icon: ImageVector, day: Int, openState: MutableState<Boolean>) {
	Column(
		Modifier
			.padding(6.dp)
			.clickable { openState.value = true }) {

		DayDetailDialog(openState)

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
fun DayDetailDialog(openState: MutableState<Boolean>) {
	if (openState.value) {
		Dialog(onDismissRequest = { openState.value = false }) {
			DayDetailDialogUi(openState)
		}
	}
}

@Composable
fun DayDetailDialogUi(openState: MutableState<Boolean>) {
	Card(
		modifier = Modifier
			.width(300.dp)
			.padding(top = 10.dp)) {
		Column {
			Icon(
				Icons.Default.AccountBox,
				contentDescription = Icons.Default.AccountBox.name,
				modifier = Modifier
					.align(Alignment.CenterHorizontally)
					.defaultMinSize(100.dp, 100.dp)
			)

			Spacer(modifier = Modifier.height(80.dp))


			TextButton(
				onClick = { openState.value = false },
				modifier = Modifier
					.fillMaxWidth()
					.background(Color.Blue)
					.height(40.dp)) {
				Text(
					text = "기상시간 체크",
					color = Color.White,
					fontSize = 13.sp,
					textAlign = TextAlign.Center)
			}
		}
	}
}

@SuppressLint("UnrememberedMutableState")
@Composable
@Preview(showBackground = true)
fun Day_Preview() {
	DailyCheckMiracleMorningTheme {
		Day(Icons.Default.AccountBox, 1, mutableStateOf(false))
	}
}

@SuppressLint("UnrememberedMutableState")
@Composable
@Preview(showBackground = true)
fun DayDetail_Preview() {
	DailyCheckMiracleMorningTheme {
		DayDetailDialogUi(mutableStateOf(false))
	}
}