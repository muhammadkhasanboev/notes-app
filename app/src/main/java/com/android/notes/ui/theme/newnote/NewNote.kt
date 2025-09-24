package com.android.notes.ui.theme.newnote

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.android.notes.R
import com.android.notes.data.Note
import com.android.notes.navigation.NavigationDestination

object NewNoteScreenDestination : NavigationDestination {
    override val route = "newNote"
    override val titleRes = R.string.new_note
}

@Composable
fun NewNoteScreen(
    navigateBack: () -> Unit,
    canNavigateBack: Boolean = true
){
   var titleOfNote by rememberSaveable { mutableStateOf("") }


}
