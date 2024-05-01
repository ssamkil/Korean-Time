package com.example.koreantime

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
        var password = binding.myPassword
        var changePassword = binding.myPasswordChange

        email.text = auth.currentUser?.email
    }
}