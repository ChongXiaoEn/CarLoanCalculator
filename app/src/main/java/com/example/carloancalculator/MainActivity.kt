package com.example.carloancalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonCalculate.setOnClickListener{
            val inputCarPrice:String = editTextCarPrice.text.toString()
            val inputDownPayment:String = editTextDownPayment.text.toString()
            val inputLoanPeriod:String = editTextLoanPeriod.text.toString()
            val inputInterestRate:String = editTextInterestRate.text.toString()

            val carPrice:Double = inputCarPrice.toDouble()
            val downPayment:Double = inputDownPayment.toDouble()
            val loanPeriod:Double = inputLoanPeriod.toDouble()
            val interestRate:Double = inputInterestRate.toDouble()

            val carLoan:Double = carPrice - downPayment
            val interest:Double = carLoan * (interestRate/100) * loanPeriod
            val monthlyRepayment:Double = (carLoan + interest)/loanPeriod/12

            txtLoan.text = "%.2f".format(carLoan)
            txtInterest.text = "%.2f".format(interest)
            txtMonthlyPayment.text = "%.2f".format(monthlyRepayment)
        }

        buttonReset.setOnClickListener{
            editTextCarPrice.setText("")
            editTextDownPayment.setText("")
            editTextLoanPeriod.setText("")
            editTextInterestRate.setText("")
            txtLoan.setText("")
            txtInterest.setText("")
            txtMonthlyPayment.setText("")
        }
    }


}
