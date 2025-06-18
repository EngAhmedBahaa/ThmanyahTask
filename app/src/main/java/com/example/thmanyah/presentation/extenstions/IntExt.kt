package com.example.thmanyah.presentation.extenstions


fun Int.fromMinsToHoursMinFormat(): String {

    val hours = (this / 3600)

    // Calculate remaining minutes after extracting hours
    val minutes = ((this % 3600) / 60)

    return "$hours:$minutes"
}