package ru.touchin.bottomsheets

import android.os.Bundle
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import ru.touchin.bottomsheets.databinding.ActivityMainBinding
import ru.touchin.roboswag.components.utils.px

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        repeat(20) { index ->
            val btn = Button(this).apply {
                layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                    setMargins(8.px, 4.px, 8.px, 4.px)
                }

                BottomSheetCreateList.getOrNull(index)?.let { type ->
                    text = type.name
                    setOnClickListener { type.showAction.invoke(supportFragmentManager) }
                }
            }

            binding.mainList.addView(btn)
        }
    }
}
