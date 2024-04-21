package com.example.koreantime

import android.content.ContentValues
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
        val binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val btn_create = binding.create
        val btn_back   = binding.back
        val name_space = binding.name
        val username_space = binding.username
        val password_space = binding.password

        var dbHelper = DBHelper(applicationContext)
        var db = dbHelper.writableDatabase

        btn_create.setOnClickListener{
            var name = name_space.text.toString()
            var username = username_space.text.toString()
            var password = password_space.text.toString()
            if(name.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty()){
                var data = ContentValues()
                data.put("name", name)
                data.put("username", username)
                data.put("password", password)
                var rs:Long = db.insert("user", null, data)
                if(!rs.equals(-1)) {
                    var ad = AlertDialog.Builder(this)
                    ad.setTitle("Message")
                    ad.setMessage("Account registered successfully")
                    ad.setPositiveButton("OK", null)
                    ad.show()
                    name_space.text.clear()
                    username_space.text.clear()
                    password_space.text.clear()
                } else {
                    var ad = AlertDialog.Builder(this)
                    ad.setTitle("Message")
                    ad.setMessage("Record not added")
                    ad.setPositiveButton("OK", null)
                    ad.show()
                    name_space.text.clear()
                    username_space.text.clear()
                    password_space.text.clear()
                }
            } else {
                Toast.makeText(this, "All fields required", Toast.LENGTH_SHORT).show()
            }
        }
        btn_back.setOnClickListener{finish()}

    }
}