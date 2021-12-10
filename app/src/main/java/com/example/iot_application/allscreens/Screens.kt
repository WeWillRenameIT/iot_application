package com.example.iot_application.allscreens

sealed class Screens(val route: String) {
    object AuthoriseScreen : Screens("authorise")
    object UsersScreen : Screens("users")
    object JournalScreen : Screens("journal")
    object InfoScreen : Screens("info")
    object CodeLocksScreen : Screens("codelocks")
    object DetailUserScreen : Screens("userdetail")
    object DetailCodeLockScreen : Screens("codelockdetail")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {
                    arg ->
                append("/$arg")
            }
        }
    }




}
