package com.ldcoding.rime

sealed class Screen(val route: String) {
    object PoemListScreen : Screen("poem_list_screen")
}