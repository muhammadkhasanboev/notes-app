package com.android.notes.ui.theme.home

import android.graphics.drawable.Icon
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.notes.NotesTopBar
import com.android.notes.navigation.NavigationDestination
import com.android.notes.R
import com.android.notes.data.Note

object HomeDestination : NavigationDestination {
    override val route = "home"
    override val titleRes = R.string.home
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            NotesTopBar(
                title = stringResource(id = R.string.home),
                canNavigateBack = false,
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {}, //adding new note screen should be added
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(20.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.item_entry_title)
                )
            }
        }
    ) {
        innerPadding ->
        HomeBody(
           noteList = listOf(),
            onNoteClick = { },
            modifier = modifier.fillMaxSize(),
            contentPadding = innerPadding
        )
    }
}

@Composable
private fun HomeBody(
    noteList: List<Note>,
    onNoteClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        if(noteList.isNotEmpty()){
            Text(
                text = stringResource(id = R.string.no_note_description),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                modifier = modifier.padding(contentPadding)
            )
        } else {
            notesList(
                noteList = noteList,
                onNoteClick = { onNoteClick(it.id) },
                contentPadding = contentPadding,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
private fun notesList(
    noteList: List<Note>,
    onNoteClick: (Note) -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding
    ){
        items(items = noteList, key = {it.id}) { note ->
            Notes(
                note = note,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { onNoteClick(note) }
            )

        }
    }
}

@Composable
private fun Notes(
    note: Note,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ){
        Column(
            modifier = modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Row(
                modifier = modifier.fillMaxWidth()
            ){
                Text(
                    text = note.title,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(Modifier.weight(1f))
            }

        }
    }
}

