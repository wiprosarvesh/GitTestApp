package com.example.gittestapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.domain.model.SchoolList
import com.example.gittestapp.navigation.Route
import com.example.gittestapp.viewmodel.SchoolListViewModel

@Composable
fun SchoolListScreen(
    navController: NavController,
    schoolListViewModel: SchoolListViewModel
) {

    LaunchedEffect(true) {
        schoolListViewModel.getSchoolList()
    }

    when (val result = schoolListViewModel.uiState.collectAsState().value) {
        SchoolListViewModel.SchoolListResponseState.Error -> {

        }

        SchoolListViewModel.SchoolListResponseState.None -> {

        }

        is SchoolListViewModel.SchoolListResponseState.Success -> {
            RenderUI(navController, result.result)
        }
    }

}

@Composable
fun RenderUI(
    navController: NavController,
    result: List<SchoolList>
) {

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(result) {
            RowItem(it.schoolId, it.schoolName) { schoolId ->
                println("Clicked School Id - $schoolId")
                navController.navigate(Route.SCHOOL_DETAILS.name + "/$schoolId")
            }
        }
    }

}

@Composable
private fun RowItem(
    schoolId: Int,
    schoolName: String,
    onClick: (Int) -> Unit
) {

    Column(modifier = Modifier
        .padding(8.dp)
        .clickable { onClick(schoolId) }) {

        Text(
            text = schoolId.toString(),
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                fontSize = 16.sp,
            )
        )

        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = schoolName,
            style = TextStyle(
                fontSize = 14.sp,
            )
        )

        HorizontalDivider()

    }

}
