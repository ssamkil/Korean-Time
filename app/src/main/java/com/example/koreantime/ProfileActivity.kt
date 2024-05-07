package com.example.koreantime

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.koreantime.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()

        var name = binding.myName
        var email = binding.myEmail
        var changePassword = binding.myPasswordChange
        var back = binding.myBack

        email.text = auth.currentUser?.email
        name.text = auth.currentUser?.displayName

        changePassword.setOnClickListener{
            var intent = Intent(this, ChangePasswordActivity::class.java)
            startActivity(intent)
        }

        back.setOnClickListener{finish()}
    }
}