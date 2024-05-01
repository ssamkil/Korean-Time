package com.example.koreantime

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.koreantime.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var name = binding.myName
        var username = binding.myUsername
        var password = binding.myPassword
        var changePassword = binding.myPasswordChange
    }
}