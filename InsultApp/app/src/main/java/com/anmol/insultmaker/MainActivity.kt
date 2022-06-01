package com.anmol.insultmaker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anmol.insultmaker.ui.theme.InsultMakerTheme
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            var textFieldState by remember {
                mutableStateOf("")
            }
            val scope = rememberCoroutineScope()
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = scaffoldState
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp)
                ) {
                    TextField(
                        value = textFieldState,
                        label = {
                                Text("Enter your name")
                        },
                        onValueChange = {
                            textFieldState = it
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        scope.launch {
//                            scaffoldState.snackbarHostState.showSnackbar("$textFieldState")
                            val output = insultout(textFieldState)
                            scaffoldState.snackbarHostState.showSnackbar("$output")
                        }
                        }
                    )
                    {
                        Text("Please Insult me")
                    }
                }
            }
        }
    }
    fun insultout(name:String): String {
        val insults = arrayOf<String>("Two wrongs don't make a right, take your parents as an example.", "Is your ass jealous of the amount of shit that just came out of your mouth?\n" +
                "\n", "It's better to let someone think you are an Idiot than to open your mouth and prove it.\n" +
                "\n", "You have two parts of brain, 'left' and 'right'. In the left side, there's nothing right. In the right side, there's nothing left.\n" +
                "\n","If I wanted to kill myself I'd climb your ego and jump to your IQ.\n" +
                "\n","You're old enough to remember when emojis were called hieroglyphics.\n" +
                "\n","Talking to a liberal is like trying to explain social media to a 70 years old.\n" +
                "\n","You must have been born on a highway because that's where most accidents happen.\n" +
                "\n","Roses are red, Violets are blue. I've got five fingers, The middle one is for you.\n" +
                "\n","My psychiatrist told me I was crazy and I said I want a second opinion. He said okay, you're ugly too.\n" +
                "\n","You're so ugly, when your mom dropped you off at school she got a fine for littering.\n" +
                "\n","You sound reasonable. It must be time to up my medication!\n" +
                "\n")
        val outputtext:String = name+", "+insults.random()
        return outputtext
    }
}
