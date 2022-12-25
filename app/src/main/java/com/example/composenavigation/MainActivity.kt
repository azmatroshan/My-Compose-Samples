package com.example.composenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composenavigation.ui.theme.ComposeNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationTheme {
                MainComponent()
            }
        }
    }
}

sealed class Screen(val route: String){
    object Home: Screen(route = "Home_Screen")
    object Final: Screen(route = "Final_Screen/{name}")
}
/*
enum class Screens(val title:String){
    HomeP(title = "HomePage"),
    FinalP(title = "FinalPage")
}
*/
@Composable
fun MainComponent(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(
            route = Screen.Home.route
        ){
            HomeScreenPage(navController = navController)
        }
        composable(
            route = Screen.Final.route,
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                }

            )
        ){
            val name = it.arguments?.getString("name")
            if (name != null) {
                FinalScreenPage(name = name)
            }
        }
    }
}