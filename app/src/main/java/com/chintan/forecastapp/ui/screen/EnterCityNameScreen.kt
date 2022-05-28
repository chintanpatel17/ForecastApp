package com.chintan.forecastapp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.chintan.forecastapp.R
import com.chintan.forecastapp.utils.EMPTY_TEXT
import com.chintan.forecastapp.viewmodels.CityWeatherViewModel

@Composable
fun EnterCityNameScreen(viewModel: CityWeatherViewModel = hiltViewModel()) {

    var cityName by remember {
        mutableStateOf(EMPTY_TEXT)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        TextField(value = cityName,
            label = { Text(stringResource(id = R.string.city_name)) },
            onValueChange = {
                cityName = it
            })

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            viewModel.getGeoCodeDirect(cityName)
        }) {
            Text(text = stringResource(R.string.lookup))
        }

    }
}


@Preview(showBackground = true)
@Composable
fun PreviewEnterCityNameScreen() {
    EnterCityNameScreen()
}