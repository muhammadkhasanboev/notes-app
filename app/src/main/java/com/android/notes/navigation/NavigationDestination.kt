package com.android.notes.navigation

//interface to describe the navigation destination for the app
interface NavigationDestination {
    //unique name to define the path for a composable
    val route: String
    //string resource id to that contains title to be displayed for the screen
    val titleRes: Int
}