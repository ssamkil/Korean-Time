package com.example.koreantime

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.koreantime.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        var binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var btn_create = binding.create
        var btn_back   = binding.back
        var name_space = binding.name
        var username_space = binding.username
        var password_space = binding.password

        var dbHelper = DBHelper(applicationContext)
        var db = dbHelper.writableDatabase

        var intent = Intent(this, MainActivity::class.java)

        btn_create.setOnClickListener{
            var name = name_space.text.toString()
            var username = username_space.text.toString()
            var password = password_space.text.toString()
            var passwordConfirm = binding.confirmPassword.text.toString()
            var ad = AlertDialog.Builder(this)
            if(password != passwordConfirm) {
                ad.setTitle("Message")
                ad.setMessage("비밀번호가 일치하지 않습니다")
                ad.setPositiveButton("OK", null)
                ad.show()
            } else if(name.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty()){
                var query = "SELECT username FROM user WHERE username = ?"
                var qr = db.rawQuery(query, arrayOf(username))
                if (qr.count > 0) {
                    ad.setTitle("Message")
                    ad.setMessage("존재하는 닉네임입니다")
                    ad.setPositiveButton("OK", null)
                    ad.show()
                } else {
                    var data = ContentValues()
                    data.put("name", name)
                    data.put("username", username)
                    data.put("password", password)
                    var rs = db.insert("user", null, data)
                    if(!rs.equals(-1)) {
                        Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                }
            } else {
                Toast.makeText(this, "모든 정보를 입력해주세요", Toast.LENGTH_SHORT).show()
            }
        }
        btn_back.setOnClickListener{finish()}

    }
}