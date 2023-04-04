package ru.touchin.bottomsheets

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.touchin.bottomsheets.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
