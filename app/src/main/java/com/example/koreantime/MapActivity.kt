package com.example.koreantime

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.koreantime.databinding.ActivityMapBinding
import com.kakao.vectormap.MapView
import com.kakao.vectormap.MapViewInfo

class MapActivity : AppCompatActivity() {
    lateinit var mapView: MapView
    private lateinit var mapViewContainer : ViewGroup

    private var uLatitude : Double = 0.0
    private var uLongitutde : Double = 0.0

    var binding = ActivityMapBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        initMapView()
    }

    fun initMapView() {
        mapView = MapView(this)
        mapViewContainer = binding.mapView.addView(mapView)
    }
}