package edu.quinnipiac.ser210.assignment2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.collection.intIntMapOf
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.quinnipiac.ser210.assignment2.ui.theme.Assignment2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment2Theme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                }
            }
        }
    }
}

@Composable
fun FinalOut(movieName: String, length: String,
             lang: String, rating: Double, review: String,
             modifier: Modifier = Modifier) {
    Box() {
        Row {
            BackgroundImage()
        }

        Row (modifier = Modifier.fillMaxSize()) {
            MovieBody(movieName, length, lang, rating,
                review, modifier = modifier)
        }
    }
}

@Composable
fun MovieBody(movieName:String, length:String, lang: String, rating: Double, review: String, modifier: Modifier) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Row(modifier = modifier,
            verticalAlignment = Alignment.CenterVertically) {
            MoviePic()
            MovieNameRate(movieName)
        }

        Row() {
            MovieDetails(length, lang, rating, review)
        }
    }
}

@Composable
fun MovieDetails(length: String, lang: String, rating: Double, review: String) {
    Row(
        modifier = Modifier)
     {
        Column(
            modifier = Modifier
                .offset(y=90.dp)
                .offset(x=-70.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Length",
                fontSize = 20.sp,
                color = Color.DarkGray)

            Spacer(modifier = Modifier.heightIn(10.dp))
            Text(text = "$length",
                fontSize = 20.sp,
                color = Color.Black)
        }

        Column(
            modifier = Modifier
                .offset(y=90.dp)
                .offset(x=-30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Lang",
                fontSize = 20.sp,
                color = Color.DarkGray)

            Spacer(modifier = Modifier.heightIn(10.dp))
            Text(text = "$lang",
                fontSize = 20.sp,
                color = Color.Black)
        }

         Column(
             modifier = Modifier
                 .offset(y=90.dp)
                 .offset(x=10.dp),
             horizontalAlignment = Alignment.CenterHorizontally
         ) {
             Text(text = "Rating",
                 fontSize = 20.sp,
                 color = Color.DarkGray)

             Spacer(modifier = Modifier.heightIn(10.dp))
             Text(text = "$rating",
                 fontSize = 20.sp,
                 color = Color.Black)
         }

         Column(
             modifier = Modifier
                 .offset(y=90.dp)
                 .offset(x=50.dp),
             horizontalAlignment = Alignment.CenterHorizontally
         ) {
             Text(text = "Review",
                 fontSize = 20.sp,
                 color = Color.DarkGray)

             Spacer(modifier = Modifier.heightIn(10.dp))
             Text(text = "$review",
                 fontSize = 20.sp,
                 color = Color.Black)
         }
    }
}


@Composable
fun BackgroundImage() {
    Image(painter = painterResource(R.drawable.bg10), null,
    modifier = Modifier
        .width(700.dp)
        .height(580.dp)
        .clip(RoundedCornerShape(50.dp)))
}

@Composable
fun MovieNameRate(movieName: String) {
    Column(modifier = Modifier
        .padding(top = 350.dp)
        .offset(x = -80.dp)
        .offset(y = 35.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "$movieName",
            fontSize = 20.sp,
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row() {
            repeat(5) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    null,
                    modifier = Modifier
                        .size(20.dp),
                    Color.Yellow
                )
            }
        }
    }
}

@Composable
fun MoviePic(modifier: Modifier = Modifier) {
    Image(painter = painterResource(R.drawable.bg10), null,
        contentScale = ContentScale.Fit, modifier = modifier
            .size(150.dp)
            .padding(1.dp)
            .offset(x = -80.dp)
            .offset(y = 170.dp))
}

@Preview(showBackground = true)
@Composable
fun FinalOutPreview() {
    FinalOut("Spider Man", "1:37", "Eng", 6.4, "45+")
}
