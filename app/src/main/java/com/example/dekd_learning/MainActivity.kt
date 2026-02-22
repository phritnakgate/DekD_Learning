package com.example.dekd_learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dekd_learning.ui.theme.DekD_LearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DekD_LearningTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadrant()
                }
            }
        }
    }
}

@Composable
fun HappyBirthdayCard(
    modifier: Modifier = Modifier,
    name: String,
    sender: String
){
    Box {
        Image(
            painter = painterResource(R.drawable.androidparty),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {

            Text(
                text = stringResource(R.string.happy_birthday_receiver, name),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 32.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(R.string.happy_birthday_sender, sender),
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = Alignment.End)
            )
        }
    }
}

//Exercise 1: Compose Article
@Composable
fun ComposeArticle(modifier: Modifier = Modifier){
    Column() {
        Image(
            painter = painterResource(R.drawable.bg_compose_background),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = stringResource(R.string.article_title),
            fontSize = 24.sp,
            modifier = modifier
                .padding(16.dp)
        )
        Text(
            text = stringResource(R.string.article_p1),
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = stringResource(R.string.article_p2),
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(16.dp)
        )
    }
}

//Exercise 2: Task Manager
@Composable
fun TaskManager(modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_task_completed),
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.task_manager_text1),
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = stringResource(R.string.task_manager_text2),
            fontSize = 16.sp
        )
    }
}

//Exercise 3: Compose Quadrant
@Composable
fun ComposeQuadrant(modifier: Modifier = Modifier){
    Column() {
        Row(
            modifier = Modifier
                .weight(0.5F)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(color = colorResource(R.color.quadrant1_bg))
                    .weight(0.5F)
                    .fillMaxHeight()
                    .padding(16.dp)
            ) {
                Text(
                    text = stringResource(R.string.quadrant_1_heading),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = stringResource(R.string.quadrant_1_desc),
                    textAlign = TextAlign.Justify
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(color = colorResource(R.color.quadrant2_bg))
                    .weight(0.5F)
                    .fillMaxHeight()
                    .padding(16.dp)
            ) {
                Text(
                    text = stringResource(R.string.quadrant_2_heading),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = stringResource(R.string.quadrant_2_desc),
                    textAlign = TextAlign.Justify
                )
            }
        }
        Row(
            modifier = Modifier
                .weight(0.5F)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(color = colorResource(R.color.quadrant3_bg))
                    .weight(0.5F)
                    .fillMaxHeight()
                    .padding(16.dp)
            ) {
                Text(
                    text = stringResource(R.string.quadrant_3_heading),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = stringResource(R.string.quadrant_3_desc),
                    textAlign = TextAlign.Justify
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(color = colorResource(R.color.quadrant4_bg))
                    .weight(0.5F)
                    .fillMaxHeight()
                    .padding(16.dp)
            ) {
                Text(
                    text = stringResource(R.string.quadrant_4_heading),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = stringResource(R.string.quadrant_4_desc),
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
}

