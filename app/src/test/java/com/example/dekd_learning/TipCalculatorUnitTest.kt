package com.example.dekd_learning

import com.example.dekd_learning.ui.calculateTip
import org.junit.Test

import org.junit.Assert.*
import java.text.NumberFormat

class TipCalculatorUnitTest {
    @Test
    fun calculateNormalTipNoDecimal() {
        val amount = "100"
        val tip = "20"
        val actualRounded = NumberFormat.getCurrencyInstance().format(
            calculateTip(
                amount,
                tip,
                true
            )
        )
        val actualNotRounded = NumberFormat.getCurrencyInstance().format(
            calculateTip(
                amount,
                tip,
                false
            )
        )

        assertEquals(NumberFormat.getCurrencyInstance().format(120), actualRounded)
        assertEquals(NumberFormat.getCurrencyInstance().format(120), actualNotRounded)
    }
}