package com.chaen.dailycheckmiraclemorning.ui.setting

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chaen.dailycheckmiraclemorning.ui.theme.DailyCheckMiracleMorningTheme

@Composable
fun SettingDrawer() {
	Column(Modifier.padding(start = 16.dp, end = 16.dp, top = 60.dp)) {
		Text(
			"환경 설정",
			Modifier.padding(bottom = 20.dp),
			style = MaterialTheme.typography.body1
		)

		Divider(Modifier.padding(bottom = 10.dp))

		SettingMenu(Icons.Default.Notifications, "PUSH 알림 설정") {
		}

		SettingMenu(Icons.Default.Star, "기상 시간 설정") {
		}

		SettingMenu(Icons.Default.DateRange, "월뷰 시작 요일 설정") {
		}

		SettingMenu(Icons.Default.Warning, "오류신고 및 문의사항") {
		}
	}
}

@Composable
fun SettingMenu(icon: ImageVector, title: String, onClickSetting: () -> Unit) {
	Row(
		Modifier
			.fillMaxWidth()
			.defaultMinSize(minHeight = 70.dp)
			.clickable(onClick = { onClickSetting() })
			.padding(vertical = 3.dp)
	) {
		Icon(
			icon,
			contentDescription = icon.name,
			modifier = Modifier
				.align(Alignment.CenterVertically)
		)

		Text(
			title,
			Modifier
				.align(Alignment.CenterVertically)
				.padding(start = 12.dp),
			style = MaterialTheme.typography.subtitle2
		)
	}
}

@Preview(showBackground = true)
@Composable
fun Drawer_Preview() {
	DailyCheckMiracleMorningTheme {
		SettingDrawer()
	}
}