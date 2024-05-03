package com.example.koreantime

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.koreantime.databinding.ActivityMapBinding
import com.kakao.vectormap.MapView
import com.kakao.vectormap.MapViewInfo
import com.naver.maps.map.NaverMapSdk

class MapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NaverMapSdk.getInstance(this).client =
            NaverMapSdk.NaverCloudPlatformClient("fkxj9cn3va")
    }
}