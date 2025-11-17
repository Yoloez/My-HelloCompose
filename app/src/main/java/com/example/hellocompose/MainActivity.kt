package com.example.hellocompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hellocompose.ui.theme.HelloComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Column(modifier = Modifier.fillMaxSize()){
                CountView(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                )

                CountView(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                )


            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun CountView(modifier: Modifier = Modifier){

    //ambil context dari compose
    val context = LocalContext.current

    //bikin state
    var count by rememberSaveable { mutableStateOf(0) }

    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp, 16.dp, 16.dp, 50.dp)) {
        Box(
            modifier = Modifier.fillMaxWidth()
                .weight(1f)
                .background(color = Color.Magenta),
            Alignment.Center,
        ){
            Text(text = "Count: $count",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(.8.dp)
        ){

        Button(
            onClick = {
                Toast.makeText(context,
                    "Count $count",
                    Toast.LENGTH_SHORT)
                    .show()
            },
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Toast",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
            Button(
                onClick = { count++ },
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Count",
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CountView()
}
