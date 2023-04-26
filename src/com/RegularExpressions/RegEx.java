package com.RegularExpressions;

public class RegEx {
    public static boolean matchesTelephone(String telephone) {
        String pattern = "^\\d{10}$"; // phone number pattern with 10 digits
        return telephone.matches(pattern) || telephone.equals("");
    }

    public static boolean matchesDateFormat(String date) {
        String pattern = "^\\d{2}[-/]\\d{2}[-/]\\d{4}|\\d{4}[-/]\\d{2}[-/]\\d{2}$"; // date YYYY-MM-DD, DD-MM-YYYY and DD/MM/YYYY are all accepted
        return date.matches(pattern)|| date.equals("");
    }

    public static boolean matchesNameFormat(String nom){
        String pattern = "^[a-zA-Z_]*$";
        return (nom.matches(pattern))|| nom.equals("");
    }




}
