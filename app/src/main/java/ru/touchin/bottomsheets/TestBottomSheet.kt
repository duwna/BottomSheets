package ru.touchin.bottomsheets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.children
import androidx.core.view.setPadding
import androidx.core.view.updatePadding
import ru.touchin.bottomsheets.databinding.TestBottomSheetBinding
import ru.touchin.roboswag.bottomsheet.DefaultBottomSheet
import ru.touchin.roboswag.components.utils.px
import ru.touchin.roboswag.navigation_base.fragments.viewBinding

open class TestBottomSheet : DefaultBottomSheet() {

    private val contentBinding by viewBinding { TestBottomSheetBinding.bind(contentView) }

    override fun createContentView(inflater: LayoutInflater) = TestBottomSheetBinding.inflate(inflater).root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(rootBinding.topIcon) {
            setImageResource(R.drawable.baseline_arrow_drop_down_24)
            updatePadding(top = 8.px)
        }

        with(rootBinding.closeText) {
            setText(R.string.close_text)
            setPadding(16.px)
        }

        repeat(arguments?.getInt("itemCount") ?: 3) {
            TextView(requireContext()).apply {
                text = getString(R.string.item_text, it)
                setPadding(16.px)
                contentBinding.linearContainer.addView(this)
            }
        }

        EditText(requireContext()).apply {
            setPadding(16.px)
            hint = "text field"
            contentBinding.linearContainer.addView(this)
        }

        Button(requireContext()).apply {
            setPadding(16.px)
            text = context.getString(R.string.add_item)
            setOnClickListener {
                TextView(requireContext()).apply {
                    val count = itemsCount() + 1
                    text = getString(R.string.item_text, count)
                    setPadding(16.px)
                    contentBinding.linearContainer.addView(this, count)
                }
            }
            contentBinding.linearContainer.addView(this)
        }

        Button(requireContext()).apply {
            setPadding(16.px)
            text = context.getString(R.string.remove_item)
            setOnClickListener {
                val count = itemsCount()
                if (count != 0) contentBinding.linearContainer.removeViewAt(count)
            }
            contentBinding.linearContainer.addView(this)
        }
    }

    private fun itemsCount(): Int = contentBinding.linearContainer.children.count {
        it is TextView && it.text.startsWith("Item")
    }
}
