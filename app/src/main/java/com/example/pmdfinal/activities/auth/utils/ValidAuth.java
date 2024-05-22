package com.example.pmdfinal.activities.auth.utils;

import android.util.Patterns;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidAuth {

    static public boolean isValidEmail(CharSequence email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    static public boolean isValidPassword(CharSequence password) {
        String regexPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!*])(?=\\S+$).{8,}$";

        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }

    static public boolean passwordMatch(CharSequence password, CharSequence confirmPassword) {
        return password.equals(confirmPassword);
    }

}
