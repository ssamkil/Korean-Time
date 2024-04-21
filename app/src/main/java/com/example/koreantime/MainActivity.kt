package com.example.koreantime

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.koreantime.ui.theme.KoreanTimeTheme
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.koreantime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var dbHelper: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        installSplashScreen()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btn_register = binding.register
        val btn_login    = binding.login

        val intent = Intent(this, RegisterActivity::class.java)
        btn_register.setOnClickListener{startActivity(intent)}

        dbHelper = DBHelper(applicationContext)
        var db = dbHelper.writableDatabase

        btn_login.setOnClickListener{

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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KoreanTimeTheme {
        Greeting("Android")
    }
}