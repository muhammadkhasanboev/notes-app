package com.android.notes.ui.theme.newnote

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.android.notes.R
import com.android.notes.navigation.NavigationDestination

object NewNoteScreenDestination : NavigationDestination {
    override val route = "newNote"
    override val titleRes = R.string.new_note
}

@Composable
fun NewNoteScreen(
    navigateBack: () -> Unit
){
    Text(
        text="Hello",
        fontSize = 40.sp)
}
