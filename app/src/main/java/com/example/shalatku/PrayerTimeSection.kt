package com.example.shalatku

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PrayerTimesSection(
    state: PrayerTimesUiState,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Prayer times", style = MaterialTheme.typography.titleLarge)

        when (state) {
            PrayerTimesUiState.Loading -> {
                CircularProgressIndicator()
            }
            is PrayerTimesUiState.Success -> {
                state.times.forEach { prayer ->
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(prayer.name)
                        Text(prayer.time)
                    }
                }
                OutlinedButton(onClick = onRefresh) { Text("Refresh") }
            }
            is PrayerTimesUiState.Error -> {
                Text(state.message, color = MaterialTheme.colorScheme.error)
                Button(onClick = onRefresh) { Text("Retry") }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrayerTimesSectionLoadingPreview() {
    PrayerTimesSection(state = PrayerTimesUiState.Loading, onRefresh = {})
}

@Preview(showBackground = true)
@Composable
fun PrayerTimesSectionSuccessPreview() {
    PrayerTimesSection(
        state = PrayerTimesUiState.Success(samplePrayers),
        onRefresh = {}
    )
}

@Preview(showBackground = true)
@Composable
fun PrayerTimesSectionErrorPreview() {
    PrayerTimesSection(
        state = PrayerTimesUiState.Error("Gagal memuat jadwal salat. Coba lagi."),
        onRefresh = {}
    )
}