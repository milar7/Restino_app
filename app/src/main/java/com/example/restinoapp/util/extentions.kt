package com.example.restinoapp.util

import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.regex.Pattern

fun String.isInteger() = this?.toIntOrNull()?.let { true } ?: false

fun Fragment.toast(msg:String){
    Toast.makeText(this.context,msg,Toast.LENGTH_SHORT).show()
}

fun String.isValidPassword() : Boolean {
    this?.let {
        val passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@\$!%*#?&]{8,}\$"
        val passwordMatcher = Regex(passwordPattern)
        return passwordMatcher.find(this) != null
    } ?: return false
}
fun String.isValidPassword2(): Boolean {

    val PASSWORD_PATTERN = "(/^(?=.*\\d)(?=.*[A-Z])([@\$%&#])[0-9a-zA-Z]{4,}\$/)";

    //^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$
//    ^                 # start-of-string
//    (?=.*[0-9])       # a digit must occur at least once
//    (?=.*[a-z])       # a lower case letter must occur at least once
//    (?=.*[A-Z])       # an upper case letter must occur at least once
//    (?=.*[@#$%^&+=])  # a special character must occur at least once you can replace with your special characters
//    (?=\\S+$)          # no whitespace allowed in the entire string
//    .{4,}             # anything, at least six places though
//    $                 # end-of-string
    var pattern = Pattern.compile(PASSWORD_PATTERN)
    var matcher=pattern.matcher(this)


    return matcher.matches()
}