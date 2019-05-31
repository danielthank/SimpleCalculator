package com.example.simplecalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.simplecalculator.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    private lateinit var resultView: TextView

    private lateinit var viewModel: MainViewModel

    private lateinit var btnZero: Button
    private lateinit var btnOne: Button
    private lateinit var btnTwo: Button
    private lateinit var btnThree: Button
    private lateinit var btnFour: Button
    private lateinit var btnFive: Button
    private lateinit var btnSix: Button
    private lateinit var btnSeven: Button
    private lateinit var btnEight: Button
    private lateinit var btnNine: Button

    private lateinit var btnAc: Button
    private lateinit var btnAdd: Button
    private lateinit var btnSub: Button
    private lateinit var btnMul: Button
    private lateinit var btnDiv: Button
    private lateinit var btnResult: Button
    private lateinit var btnDot: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        resultView = findViewById(R.id.text_result)

        btnZero = findButtonAndBindAction(R.id.btn_zero)

        btnOne = findButtonAndBindAction(R.id.btn_one)

        btnTwo = findButtonAndBindAction(R.id.btn_two)

        btnThree = findButtonAndBindAction(R.id.btn_three)

        btnFour = findButtonAndBindAction(R.id.btn_four)

        btnFive = findButtonAndBindAction(R.id.btn_five)

        btnSix = findButtonAndBindAction(R.id.btn_six)

        btnSeven = findButtonAndBindAction(R.id.btn_seven)

        btnEight = findButtonAndBindAction(R.id.btn_eight)

        btnNine = findButtonAndBindAction(R.id.btn_nine)

        btnAc = findButtonAndBindAction(R.id.btn_ac)

        btnAdd = findButtonAndBindAction(R.id.btn_add)

        btnSub = findButtonAndBindAction(R.id.btn_sub)

        btnMul = findButtonAndBindAction(R.id.btn_mul)

        btnDiv = findButtonAndBindAction(R.id.btn_div)

        btnResult = findButtonAndBindAction(R.id.btn_equal)

        btnDot = findButtonAndBindAction(R.id.btn_dot)

        viewModel.displayText.observe(this, Observer<String> {
            resultView.text = it
        })
    }

    private fun findButtonAndBindAction(@IdRes resId: Int) =
        findViewById<Button>(resId).also {
            it.setOnClickListener {
                viewModel.viewAction(resId)
            }
        }
}
