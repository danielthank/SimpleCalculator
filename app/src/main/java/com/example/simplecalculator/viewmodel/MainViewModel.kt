package com.example.simplecalculator.viewmodel

import androidx.annotation.IdRes
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simplecalculator.Calculator
import com.example.simplecalculator.DataObserver
import com.example.simplecalculator.R

class MainViewModel : ViewModel(), DataObserver<String> {
    private val calculator = Calculator(this)

    val displayText: MutableLiveData<String> = MutableLiveData()

    override fun onNotify(data: String) {
        displayText.value = data
    }

    fun viewAction(@IdRes buttonId: Int) {
        when(buttonId){
            R.id.btn_zero -> calculator.appendDigit(0)
            R.id.btn_one -> calculator.appendDigit(1)
            R.id.btn_two -> calculator.appendDigit(2)
            R.id.btn_three -> calculator.appendDigit(3)
            R.id.btn_four -> calculator.appendDigit(4)
            R.id.btn_five -> calculator.appendDigit(5)
            R.id.btn_six -> calculator.appendDigit(6)
            R.id.btn_seven -> calculator.appendDigit(7)
            R.id.btn_eight -> calculator.appendDigit(8)
            R.id.btn_nine -> calculator.appendDigit(9)
            R.id.btn_ac -> calculator.reset()
            R.id.btn_add -> calculator.add()
            R.id.btn_sub -> calculator.subtract()
            R.id.btn_mul -> calculator.multiply()
            R.id.btn_div -> calculator.divide()
            R.id.btn_equal -> calculator.calculate()
            R.id.btn_dot -> calculator.appendDot()
        }
    }
}
