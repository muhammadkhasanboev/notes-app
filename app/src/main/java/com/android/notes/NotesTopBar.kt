package com.android.notes

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.android.notes.navigation.NotesNavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun NotesApp(navController: NavHostController = rememberNavController()){
    NotesNavHost(navController = navController)
}

@Composable
fun NotesTopBar(){

}