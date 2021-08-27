package com.example.datepicker.date_picker.model

import java.util.*
import kotlin.collections.ArrayList

data class AllMonths(
    val startingDayOfWeek: Int,
    val dayCountOfMonth: Int,
    val year: Int,
    val months:Int,
    val days: ArrayList<Day> = ArrayList(),
    val month: Calendar
)
