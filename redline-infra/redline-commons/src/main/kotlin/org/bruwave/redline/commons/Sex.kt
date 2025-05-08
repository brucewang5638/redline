package org.bruwave.redline.commons

enum class Sex {
    MALE,
    FEMALE,
    UNKNOWN;

    companion object {
        fun fromString(value: String): Sex {
            return when (value) {
                "MALE" -> MALE
                "FEMALE" -> FEMALE
                else -> UNKNOWN
            }
        }
    }
}