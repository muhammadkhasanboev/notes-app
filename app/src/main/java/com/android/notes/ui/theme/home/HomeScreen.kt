package com.android.notes.ui.theme.home


import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.android.notes.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
){
    var scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            scrollBehavior = scrollBehavior
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(20.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.add_button_description)
                )
            }
        }
    ) { innerPadding ->
       HomeBody(
           modifier = modifier
               .padding(innerPadding)
       )

    }
}

@Composable
private fun HomeBody(
    modifier : Modifier = Modifier
){

}