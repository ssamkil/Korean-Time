package com.example.koreantime

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.koreantime.databinding.ActivityMapBinding
import com.kakao.vectormap.MapView
import com.kakao.vectormap.MapViewInfo
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.NaverMapSdk
import com.naver.maps.map.OnMapReadyCallback
import com.kakao.vectormap.KakaoMapSdk

class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_map)

        val fm = supportFragmentManager
        val mapFragment = fm.findFragmentById(R.id.map_fragment) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.map_fragment, it).commit()
            }

        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(naverMap: NaverMap) {
        val locationOverlay = naverMap.locationOverlay
        locationOverlay.isVisible = true

        // 나의 위치 기준 크기
        locationOverlay.iconWidth = 50
        locationOverlay.iconHeight = 50

        // 나의 위치 기준 반경 표시
        locationOverlay.circleRadius = 100
        locationOverlay.circleOutlineWidth = 10
        locationOverlay.circleOutlineColor = Color.parseColor("#F8AA5C")
    }
}