package com.example.dekd_learning

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.Percent
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DiceRoller(){
    var rnd by remember { mutableIntStateOf(1) }
    Log.d("DiceRoller", "The value is $rnd")
    val displayDice = when(rnd){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(displayDice),
            contentDescription = null
        )
        Spacer(modifier = Modifier.padding(top = 16.dp))
        Button(
            onClick = { rnd = (1..6).random() }
        ) {
            Text(
                text = stringResource(R.string.dice_roll_btn)
            )
        }
    }
}

@Composable
fun Lemonade(){
    var lemonPageState by remember { mutableIntStateOf(0) }
    var squeezingTimes by remember { mutableIntStateOf(0) }
    val totalSqueeze by remember { mutableIntStateOf((2..4).random()) }

    Log.d("Lemonade", "Page State = $lemonPageState | Total Squeeze = $totalSqueeze | Squeezed = $squeezingTimes")

    val display = when(lemonPageState){
        0 -> mapOf("picResource" to R.drawable.lemon_tree, "picCd" to R.string.lemonade_0_cd, "picDesc" to R.string.lemonade_0)
        1 -> mapOf("picResource" to R.drawable.lemon_squeeze, "picCd" to R.string.lemonade_1_cd, "picDesc" to R.string.lemonade_1)
        2 -> mapOf("picResource" to R.drawable.lemon_drink, "picCd" to R.string.lemonade_2_cd, "picDesc" to R.string.lemonade_2)
        else -> mapOf("picResource" to R.drawable.lemon_restart, "picCd" to R.string.lemonade_3_cd, "picDesc" to R.string.lemonade_3)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.lemonade_title),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(colorResource(R.color.lemonade_header))
                .fillMaxWidth()
        )
        Button(
            onClick = {
                if(lemonPageState == 1){
                    if(squeezingTimes == totalSqueeze - 1){
                        lemonPageState += 1
                        squeezingTimes = 0
                    }else{
                        squeezingTimes += 1
                    }
                }else{
                    if(lemonPageState == 3){
                        lemonPageState = 0
                    }else{
                        lemonPageState += 1
                    }
                }
            }
        ) {
            Image(
                painter = painterResource(display["picResource"] as Int),
                contentDescription = stringResource(display["picCd"] as Int)
            )
        }
        Spacer(modifier = Modifier.padding(top = 16.dp))
        Text(
            text = stringResource(display["picDesc"] as Int)
        )
    }
}

@Composable
fun TipCalculator(){

    var billAmount by remember { mutableStateOf("") }
    var tipAmount by remember { mutableStateOf("") }
    var isRound by remember { mutableStateOf(false) }

    val amount = billAmount.toDoubleOrNull() ?: 0.0
    val tip = tipAmount.toDoubleOrNull() ?: 0.0

    val total = if(isRound) kotlin.math.ceil(amount + (amount * tip / 100))
        else amount + (amount * tip / 100)

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(32.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding()
    ) {
        Text(
            text = stringResource(R.string.tip_calc_title),
            modifier = Modifier.padding(bottom = 12.dp)
        )
        EditNumberField(
            label = stringResource(R.string.tip_calc_hint_bill),
            leadingIcon = Icons.Default.Money,
            value = billAmount,
            imeAction = ImeAction.Next,
            onValueChange = { billAmount = it }
        )
        EditNumberField(
            label = stringResource(R.string.tip_calc_hint_percent),
            leadingIcon = Icons.Default.Percent,
            imeAction = ImeAction.Done,
            value = tipAmount,
            onValueChange = { tipAmount = it }
        )
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text = stringResource(R.string.tip_calc_round_up),
            )
            Switch(
                checked = isRound,
                onCheckedChange = { isRound = it }
            )
        }
        Text(
            text = stringResource(R.string.tip_calc_result, String.format("%.2f", total)),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(top=32.dp)
        )
    }
}

@Composable
fun EditNumberField(
    label: String,
    leadingIcon: ImageVector,
    value: String,
    onValueChange: (String) -> Unit,
    imeAction: ImeAction,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(label)
        },
        leadingIcon = {
            Icon(imageVector = leadingIcon, contentDescription = null)
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = imeAction
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
    )
}