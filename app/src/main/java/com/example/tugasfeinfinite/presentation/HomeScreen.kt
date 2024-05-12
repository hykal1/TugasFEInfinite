package com.example.tugasfeinfinite.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tugasfeinfinite.data.DummyData
import com.example.tugasfeinfinite.model.Student
import com.example.tugasfeinfinite.model.Teacher
import com.example.tugasfeinfinite.navigation.Screen
import com.example.tugasfeinfinite.presentation.component.StudentItem
import com.example.tugasfeinfinite.presentation.component.TeacherItem
import com.example.tugasfeinfinite.ui.theme.TugasFEInfiniteTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    teachers: List<Teacher> = DummyData.Sensei,
    students: List<Student> = DummyData.KonohaStudent,
) {
    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text("Home Screen") }
            )
        }
    ){ innerPadding ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding)
        ) {
            item {
                LazyRow(
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = modifier
                ) {
                    items(teachers, key = { it.id }) {
                        TeacherItem(teacher = it) { teacherId ->
                            navController.navigate(Screen.Detail.route + "/$teacherId")
                        }
                    }
                }
            }
            items(students, key = { it.id }) {
                StudentItem(student = it) { studentId ->
                    navController.navigate(Screen.StudentDetail.route + "/$studentId")
                }
            }
        }
    }

}