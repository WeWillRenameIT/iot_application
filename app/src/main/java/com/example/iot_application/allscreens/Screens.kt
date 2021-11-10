package com.example.iot_application.allscreens

sealed class Screens(val route: String) {
    object  AuthoriseScreen : Screens("authorise")
    object UsersScreen : Screens("users")
    object JournalsScreen : Screens("journals")
    object CodeLocksScreen : Screens("codelocks")

//    fun withArgs(vararg args: String): String {
//        return buildString {
//            append(route)
//            args.forEach {
//                    arg ->
//                append("/$arg")
//            }
//        }
//    }
//


}
