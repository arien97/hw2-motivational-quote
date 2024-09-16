package com.example.hw2motivationalquote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hw2motivationalquote.ui.theme.HW2MotivationalQuoteTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            displayQuote()

        }
    }
}

@Composable
fun displayQuote() {

    var q by remember { mutableStateOf(generateQuote()) }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(onClick = { q = generateQuote() }) {
            Text(text = "New Quote")
        }

        Text(
            text = q
        )
    }

}

fun generateQuote(): String {

    var quotes = arrayOf("It takes courage to grow up and become who you really are. — E.E. Cummings",
        "Your self-worth is determined by you. You don't have to depend on someone telling you who you are. — Beyoncé",
    "Nothing is impossible. The word itself says 'I'm possible!' — Audrey Hepburn",
    "Keep your face always toward the sunshine, and shadows will fall behind you. — Walt Whitman",
    "Attitude is a little thing that makes a big difference. — Winston Churchill",
    "To bring about change, you must not be afraid to take the first step. We will fail when we fail to try. — Rosa Parks",
    "All our dreams can come true, if we have the courage to pursue them. — Walt Disney",
    "Don't sit down and wait for the opportunities to come. Get up and make them. — Madam C.J. Walker",
    "I am lucky that whatever fear I have inside me, my desire to win is always stronger. — Serena Williams",
    "You are never too old to set another goal or to dream a new dream. — C.S. Lewis",
    "It is during our darkest moments that we must focus to see the light. — Aristotle",
    "Believe you can and you're halfway there. — Theodore Roosevelt",
    "If you don't like the road you're walking, start paving another one. — Dolly Parton",
    "Real change, enduring change, happens one step at a time. — Ruth Bader Ginsburg",
    "All dreams are within reach. All you have to do is keep moving towards them. — Viola Davis",
    "It is never too late to be what you might have been. — George Eliot",
    "It always seems impossible until it's done. — Nelson Mandela",
    "Don’t count the days, make the days count. — Muhammad Ali",
    "Definitions belong to the definers, not the defined. — Toni Morrison",
    "When you have a dream, you've got to grab it and never let go. — Carol Burnett",
    "Never allow a person to tell you no who doesn’t have the power to say yes. — Eleanor Roosevelt"
    )

    val randomIndex = Random.nextInt(0, quotes.size)
    return quotes[randomIndex]
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HW2MotivationalQuoteTheme {
        displayQuote()
        generateQuote()
    }
}