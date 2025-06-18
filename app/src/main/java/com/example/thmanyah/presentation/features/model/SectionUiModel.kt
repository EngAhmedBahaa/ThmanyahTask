package com.example.thmanyah.presentation.features.model

import android.annotation.SuppressLint

data class SectionUiModel(
    val title: String,
    val type: ItemType,
    val content: List<ItemUiModel>,
    val order: Int,
)

enum class ItemType(val type: String) {
    Queue("queue"),
    Square("square"),
    BigSquare("big_square"),
    TwoLinesGrid("2_lines_grid");

    // Companion object to handle String to Enum conversion
    companion object {
        @SuppressLint("SuspiciousIndentation")
        fun fromString(type: String): ItemType? {
            return try {
                // Convert the string to the corresponding enum constant
                if (type == "big square")
                    return BigSquare
                else
                entries.firstOrNull { it.type == type }
            } catch (e: IllegalArgumentException) {
                // Return null if the string does not match any enum constant
                return Square
            }
        }
    }
}