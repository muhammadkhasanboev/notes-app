package com.android.notes.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android.notes.ui.theme.home.HomeDestination
import com.android.notes.ui.theme.home.HomeScreen
import com.android.notes.ui.theme.newnote.NewNoteScreen
import com.android.notes.ui.theme.newnote.NewNoteScreenDestination

@Composable
fun NotesNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ){
        composable(route = HomeDestination.route){
            HomeScreen(
                navigateToNoteEntry = { navController.navigate(NewNoteScreenDestination.route) }
            )
        }
        composable(route = NewNoteScreenDestination.route){
            NewNoteScreen(
                navigateBack = {navController.popBackStack()}
            )
        }
    }

}