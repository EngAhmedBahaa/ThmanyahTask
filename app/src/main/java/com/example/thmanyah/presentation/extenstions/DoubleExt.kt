package com.example.thmanyah.presentation.extenstions


fun Double.fromDoubleToHoursMinFormat(): String {

    val hours = (this / 3600).toInt()

    // Calculate remaining minutes after extracting hours
    val minutes = ((this % 3600) / 60).toInt()

    return "$hours:$minutes"
}