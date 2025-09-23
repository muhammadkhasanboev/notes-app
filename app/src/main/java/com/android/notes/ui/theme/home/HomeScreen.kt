package com.android.notes.ui.theme.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.android.notes.navigation.NavigationDestination
import com.android.notes.R

object HomeDestination : NavigationDestination {
    override val route = "home"
    override val titleRes = R.string.home
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
){

}