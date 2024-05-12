package com.example.tugasfeinfinite.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugasfeinfinite.R
import com.example.tugasfeinfinite.model.Student
import com.example.tugasfeinfinite.ui.theme.TugasFEInfiniteTheme

@Composable
fun StudentItem(
    student: Student,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth().clickable{
            onItemClicked(student.id)
        }
    ) {
        Image(
            painter = painterResource(id = student.photo),
            contentDescription = student.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(80.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = student.name, style = MaterialTheme.typography.titleMedium)
            Row {
                Text(text = student.role, color = MaterialTheme.colorScheme.primary)
                Text(text = " - ${student.nickname}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MentorItemPreview() {
    TugasFEInfiniteTheme {
        StudentItem(
            student = Student(1,"Naruto Uzumaki",
                "Naruto",
                "Student",
                "Naruto Uzumaki (渦巻 鳴門, Uzumaki Naruto) adalah shinobi dari Konohagakure. Dia menjadi jinchūriki dari Ekor Sembilan pada hari kelahirannya — sebuah nasib yang menyebabkan dia dijauhi oleh sebagian besar penduduk Konoha sepanjang masa kecilnya",
                R.drawable.naruto
            ),
            onItemClicked = { studentId ->
                println("Student Id : $studentId")
            }
        )
    }
}