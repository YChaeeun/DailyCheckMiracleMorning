package com.chaen.dailycheckmiraclemorning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chaen.dailycheckmiraclemorning.ui.theme.DailyCheckMiracleMorningTheme

class MainActivity : ComponentActivity() {

	private val viewModel by viewModels<MainViewModel>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		viewModel.getAnimals()

		setContent {
			DailyCheckMiracleMorningTheme {
				Scaffold {
					AnimalList(viewModel)
				}
			}
		}
	}
}

@Composable
fun AnimalList(viewModel: MainViewModel) {
	val animals by viewModel.liveAnimals.observeAsState(initial = emptyList())

	LazyColumn {
		itemsIndexed(animals) { index, item ->
			if (index == animals.lastIndex) {
				viewModel.getAnimals()
			}

			Text(item.number.toString(), modifier = Modifier
				.padding(40.dp)
				.fillMaxWidth())
		}
	}
}
