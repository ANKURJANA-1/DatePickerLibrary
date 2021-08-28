package com.example.datepicker.date_picker

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.datepicker.databinding.DatePickerLayoutBinding
import com.example.datepicker.date_picker.adapter.MonthAdapter
import com.example.datepicker.date_picker.adapter.MonthAndDateAdapter
import com.example.datepicker.date_picker.adapter.YearAdapter
import com.example.datepicker.date_picker.model.AllMonths
import com.example.datepicker.date_picker.model.YearData
import java.util.*
import kotlin.collections.ArrayList

class DatePicker(
    private val context: Context
) {

    private val calendar: Calendar = Calendar.getInstance()
    private val dialog = Dialog(context)
    private lateinit var yearAdapter: YearAdapter
    private lateinit var monthAdapter: MonthAdapter
    private lateinit var monthsAdapter: MonthAndDateAdapter
    private lateinit var monthList: ArrayList<AllMonths>
    private lateinit var yearList: ArrayList<YearData>

    private var todayDate: Int = calendar.get(Calendar.DATE)
    private var todayYear: Int = calendar.get(Calendar.YEAR)
    private var todayMonth: Int = calendar.get(Calendar.MONTH)
    private var todayDay: Int = calendar.get(Calendar.DAY_OF_WEEK)


    private var binding = DatePickerLayoutBinding.inflate(
        LayoutInflater.from(context),
        null,
        false
    )

    init {
        dialog.apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(binding.root)
            window
                ?.setLayout(
                    CoordinatorLayout.LayoutParams.MATCH_PARENT,
                    CoordinatorLayout.LayoutParams.WRAP_CONTENT
                )
            window?.setBackgroundDrawableResource(android.R.color.transparent)
            setCancelable(false)

            setOnCancelListener {

            }
        }.show()
        junk()
        setInitialDateMonthAndYear()
        showYear(yearList)
        showDates()
        showMonths()
    }

    @SuppressLint("SetTextI18n")
    private fun setInitialDateMonthAndYear() {

        val calenderNew = Calendar.getInstance()
        prepareYearsAndMonth(todayYear, todayYear + 100)
        prepareYearList(todayYear, todayYear + 100)

        calenderNew.set(todayYear, todayMonth, todayDate)
        Log.d(
            "day",
            ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
        )
        todayDate = calenderNew.get(Calendar.DATE)
        Log.d("day", todayDate.toString())

        todayMonth = calenderNew.get(Calendar.MONTH)
        Log.d("day", todayMonth.toString())

        todayYear = calenderNew.get(Calendar.YEAR)
        Log.d("day", todayYear.toString())

        todayDay = calenderNew.get(Calendar.DAY_OF_WEEK)
        Log.d("day", todayDay.toString())

        Log.d(
            "day",
            ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
        )
        binding.detailsDate.text =
            daySelector(todayDay) + ", " + monthSelector(todayMonth) + " " + todayDate.toString() + " " + todayYear.toString()


        binding.currentDate.text = monthSelector(todayMonth) + " " + todayDate.toString()
    }

    private fun junk() {
        binding.cancelButton.setOnClickListener {
            dialog.cancel()
        }
        binding.okButton.setOnClickListener {
            dialog.dismiss()
        }
    }

    private fun daySelector(dayIndex: Int): String {
        var day = ""
        when (dayIndex) {
            1 -> day = "Sun"
            2 -> day = "Mon"
            3 -> day = "Tue"
            4 -> day = "Wed"
            5 -> day = "Thu"
            6 -> day = "Fri"
            7 -> day = "Sat"
        }

        return day
    }

    private fun monthSelector(monthIndex: Int): String {
        var month = ""
        when (monthIndex) {
            0 -> month = "Jan"
            1 -> month = "Feb"
            2 -> month = "Mar"
            3 -> month = "Apr"
            4 -> month = "May"
            5 -> month = "Jun"
            6 -> month = "Jul"
            7 -> month = "Aug"
            8 -> month = "Sep"
            9 -> month = "Oct"
            10 -> month = "Nov"
            11 -> month = "Dec"
        }
        return month
    }

    private fun showYear(yearList: ArrayList<YearData>) {
        binding.year.setOnClickListener {
            binding.two.visibility = View.GONE
            setInitialDateMonthAndYear()
            yearAdapter = YearAdapter(
                context, {
                    binding.year.text = it
                    todayYear = it.toInt()
                    setInitialDateMonthAndYear()
                    binding.yearGrid.visibility = View.GONE
                    binding.monthGrid.visibility = View.VISIBLE
                    binding.two.visibility = View.VISIBLE

                }, yearList
            )
            binding.yearGrid.visibility = View.VISIBLE
            binding.monthGrid.visibility = View.GONE
            binding.yearGrid.layoutManager = LinearLayoutManager(context)
            binding.yearGrid.adapter = yearAdapter
            binding.yearGrid.hasFixedSize()
            binding.yearGrid.smoothScrollBy(0, 100)
        }
    }

    private fun showDates() {
        monthAdapter = MonthAdapter(
            context,
            monthList
        ) {
            todayDay = it
            setInitialDateMonthAndYear()
        }
        binding.monthGrid.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.monthGrid.adapter = monthAdapter
        PagerSnapHelper().attachToRecyclerView(binding.monthGrid)
        binding.monthGrid.hasFixedSize()

        binding.nextMonth.setOnClickListener {

        }

        binding.previousMonth.setOnClickListener {

        }

    }

    private fun showMonths() {
        binding.currentDate.setOnClickListener {
            binding.two.visibility = View.GONE
            binding.yearGrid.visibility = View.VISIBLE
            binding.monthGrid.visibility = View.GONE
            monthsAdapter = MonthAndDateAdapter(
                context
            ) {
                binding.currentDate.text = monthSelector(it)
                todayDate = it
                setInitialDateMonthAndYear()
                binding.two.visibility = View.VISIBLE
                binding.yearGrid.visibility = View.GONE
                binding.monthGrid.visibility = View.VISIBLE
            }
            binding.yearGrid.layoutManager =
                LinearLayoutManager(context)
            binding.yearGrid.adapter = monthsAdapter
            binding.yearGrid.hasFixedSize()
        }
    }

    private fun prepareYearsAndMonth(from: Int, to: Int) {
        monthList = ArrayList()
        val calender1 = Calendar.getInstance()
        calender1.set(Calendar.YEAR, from)
        for (i in from..to) {
            calender1.set(Calendar.YEAR, i)
            for (j in 0..11) {
                calender1.set(Calendar.MONTH, j)
                calender1.set(Calendar.DATE, 1)
                val dayCount = calender1.getActualMaximum(Calendar.DATE)
                val getDay = calender1.get(Calendar.DAY_OF_WEEK)
                val getYear = calender1.get(Calendar.YEAR)
                val getMonth = calender1.get(Calendar.MONTH)
                monthList.add(
                    AllMonths(
                        getDay,
                        dayCount,
                        year = getYear,
                        months = getMonth,
                        month = calender1.clone() as Calendar
                    )
                )
            }
        }
    }

    private fun prepareYearList(from: Int, to: Int) {
        yearList = ArrayList()
        for (i in from..to) {
            yearList.add(YearData(i))
        }
    }

}