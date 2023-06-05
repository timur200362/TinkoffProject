package com.example.tinkoffproject.presentation.statisticsPagePackage

import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


class LineChartXAxisValueFormatter : IndexAxisValueFormatter() {
    override fun getFormattedValue(value: Float): String {
        // Convert float value to date string
        // Convert from days back to milliseconds to format time  to show to the user
        val emissionsMilliSince1970Time: Long = value.toLong()
        // Show time in local version
        // Show time in local version
        val timeMilliseconds = Date(emissionsMilliSince1970Time)
        val dateTimeFormat = SimpleDateFormat("yyyy-MM-dd")

        return dateTimeFormat.format(timeMilliseconds)
    }
}