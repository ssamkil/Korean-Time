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
import com.google.firebase.auth.FirebaseAuth
import com.kakao.sdk.common.KakaoSdk
import com.naver.maps.map.NaverMapSdk

class MainActivity : AppCompatActivity() {
    lateinit var dbHelper: DBHelper
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        auth = FirebaseAuth.getInstance()
        super.onCreate(savedInstanceState)
        installSplashScreen()
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var email_space    = binding.email
        var password_space = binding.password

        var btn_register = binding.register
        var btn_login    = binding.login

        var intent = Intent(this, RegisterActivity::class.java)
        btn_register.setOnClickListener{startActivity(intent)}

        dbHelper = DBHelper(applicationContext)
        var db = dbHelper.readableDatabase

        btn_login.setOnClickListener{
            var email = email_space.text.toString()
            var password = password_space.text.toString()

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                        intent = Intent(this, MapActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "이메일 혹은 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
                    }
                }

            /*if (username.trim().isEmpty() || password.trim().isEmpty()) {
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
            }*/
        }

        // kakao client call
        KakaoSdk.init(this, "b9756b5fd3fa6a0d308496b22423130f")
        // naver client call
        NaverMapSdk.getInstance(this).client =
            NaverMapSdk.NaverCloudPlatformClient("fkxj9cn3va")
    }
}