package com.chaen.dailycheckmiraclemorning.ui.main

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.chaen.dailycheckmiraclemorning.ui.theme.DailyCheckMiracleMorningTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun MainBottomAppBar(scope: CoroutineScope, scaffoldState: ScaffoldState) {
	BottomAppBar(
		cutoutShape = MaterialTheme.shapes.small.copy(
			CornerSize(percent = 50)
		)
	) {
		BottomMenu(Icons.Default.Menu) {
			scope.launch {
				scaffoldState.drawerState.apply {
					if (isClosed) open() else close()
				}
			}
		}

		BottomMenu(Icons.Default.DateRange) {
		}
	}
}

@Composable
fun BottomMenu(icon: ImageVector, onClickAction: () -> Unit) {
	IconButton(onClick = { onClickAction() }) {
		Icon(
			icon,
			contentDescription = icon.name
		)
	}
}

@Composable
fun MainFloatingButton(onClickAction: () -> Unit) {
	FloatingActionButton(onClick = { onClickAction() }) {
		Icon(
			Icons.Default.Add,
			contentDescription = "Add"
		)
	}
}

@Preview(showBackground = true)
@Composable
fun MainBottomAppBar_Preview() {
	val scaffoldState = rememberScaffoldState()
	val scope = rememberCoroutineScope()

	DailyCheckMiracleMorningTheme {
		MainBottomAppBar(scope, scaffoldState)
	}
}