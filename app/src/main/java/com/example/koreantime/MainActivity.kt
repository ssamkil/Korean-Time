package com.example.koreantime

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
import com.kakao.sdk.common.KakaoSdk

class MainActivity : AppCompatActivity() {
    lateinit var dbHelper: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        installSplashScreen()
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var username_space = binding.username
        var password_space = binding.password

        var btn_register = binding.register
        var btn_login    = binding.login

        var intent = Intent(this, RegisterActivity::class.java)
        btn_register.setOnClickListener{startActivity(intent)}

        dbHelper = DBHelper(applicationContext)
        var db = dbHelper.readableDatabase

        btn_login.setOnClickListener{
            var username = username_space.text.toString()
            var password = password_space.text.toString()
            if (username.trim().isEmpty() || password.trim().isEmpty()) {
                Toast.makeText(this, "아이디 혹은 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                val query = "SELECT * FROM user WHERE username = ? AND password = ?"
                val rs = db.rawQuery(query, arrayOf(username, password))
                if (rs.count <= 0) {
                    Toast.makeText(this, "아이디 혹은 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                    intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                }
            }
        }

        KakaoSdk.init(this, "{b9756b5fd3fa6a0d308496b22423130f}")

    }
}