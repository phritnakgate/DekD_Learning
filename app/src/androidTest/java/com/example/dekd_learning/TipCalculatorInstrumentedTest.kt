package com.example.dekd_learning

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.dekd_learning.ui.TipCalculator
import com.example.dekd_learning.ui.theme.DekD_LearningTheme

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class TipCalculatorInstrumentedTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculateTipTest() {
        composeTestRule.setContent {
            DekD_LearningTheme() {
                TipCalculator()
            }
        }
        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")

        composeTestRule.onNodeWithText("Tip Percentage")
            .performTextInput("20")

        composeTestRule.onNodeWithText("Total Amount: $12.00").assertExists()
    }
}