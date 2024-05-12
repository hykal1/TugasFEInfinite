package com.example.tugasfeinfinite.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugasfeinfinite.R
import com.example.tugasfeinfinite.model.Teacher
import com.example.tugasfeinfinite.ui.theme.TugasFEInfiniteTheme

@Composable
fun TeacherItem(
    teacher: Teacher,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable {
            onItemClicked(teacher.id)
        }
    ){
        Image(
            painter = painterResource(id = teacher.photo),
            contentDescription = teacher.name, modifier = Modifier
                .clip(CircleShape)
                .size(80.dp)
        )
        Text(
            text = teacher.name,
            style = MaterialTheme.typography.titleMedium,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(80.dp),
            maxLines = 1
        )
        Text(
            text = teacher.role,
            color = MaterialTheme.colorScheme.primary,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.width(80.dp),
            maxLines = 1
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MentorItemHorizontalPreview() {
    TugasFEInfiniteTheme {
        TeacherItem(
            teacher = Teacher(1, "Kakashi Hatake", "Kakashi", "Teacher", "Kakashi Hatake (派竹 歌々子, Hatake Kakashi) adalah shinobi Konohagakure dari klan Hatake.", R.drawable.kakashi),
            onItemClicked = { teacherId ->
                println("Teacher Id : $teacherId")
            }
        )
    }
}