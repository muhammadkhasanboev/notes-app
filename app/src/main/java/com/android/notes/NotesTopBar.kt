package com.android.notes

import com.android.notes.R
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.android.notes.navigation.NotesNavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun NotesApp(navController: NavHostController = rememberNavController()){
    NotesNavHost(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesTopBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? =null,
    navigateUp: () -> Unit = {}
){
    CenterAlignedTopAppBar(
        title = { Text(title)},
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Filled.ArrowBack,
                        contentDescription = stringResource(id=R.string.back_button)
                    )
                }
            }
        }

    )
}