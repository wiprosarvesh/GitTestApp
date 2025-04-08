package com.example.gittestapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.domain.model.SchoolDetails
import com.example.gittestapp.viewmodel.SchoolDetailsViewModel

@Composable
fun SchoolDetailsScreen(
    schoolDetailsViewModel: SchoolDetailsViewModel,
    schoolId: Int
){

    LaunchedEffect(true) {
        schoolDetailsViewModel.getSchoolDetails(schoolId)
    }

    when(val result = schoolDetailsViewModel.uiState.collectAsState().value){
        SchoolDetailsViewModel.SchoolDetailsResponseState.Error -> {  }
        SchoolDetailsViewModel.SchoolDetailsResponseState.None -> {  }
        is SchoolDetailsViewModel.SchoolDetailsResponseState.Success -> {
            RenderUI(result.result)
        }
    }

}

@Composable
private fun RenderUI(result: SchoolDetails?) {

    Column(modifier = Modifier
        .padding(16.dp)
    ) {

        result?.let { schoolDet ->

            Text(
                text = schoolDet.schoolId.toString(),
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    fontSize = 24.sp,
                )
            )

            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = "${schoolDet.schoolName} , Test Taken - ${schoolDet.numOfSatTestTakers}, Test Math Avg Score - ${schoolDet.satMathAvgScore}, Test Writing Avg Score - ${schoolDet.satWritingAvgScore}",
                style = TextStyle(
                    fontSize = 16.sp,
                )
            )

        }

    }

}

