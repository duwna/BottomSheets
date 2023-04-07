package ru.touchin.bottomsheets

import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import ru.touchin.roboswag.bottomsheet.HeightStatesOptions
import ru.touchin.roboswag.components.utils.px

class NonCancelableBottomSheet : TestBottomSheet() {
    override val bottomSheetOptions = super.bottomSheetOptions.copy(canDismiss = false)
}

class TouchOutsideBottomSheet : TestBottomSheet() {
    override val bottomSheetOptions = super.bottomSheetOptions.copy(canTouchOutside = true)
}

class CollapsingBottomSheet : TestBottomSheet() {
    override val bottomSheetOptions = super.bottomSheetOptions.copy(isSkipCollapsed = false)
}

class FullscreenBottomSheet : TestBottomSheet() {
    override val bottomSheetOptions = super.bottomSheetOptions.copy(isFullscreen = true)
}

class DimmedBottomSheet : TestBottomSheet() {
    override val bottomSheetOptions = super.bottomSheetOptions.copy(defaultDimAmount = 0.8f)
}

class AnimatedDimmedBottomSheet : TestBottomSheet() {
    override val bottomSheetOptions = super.bottomSheetOptions.copy(animatedMaxDimAmount = 0.7f)
}

class ShiftWithKeyboardBottomSheet : TestBottomSheet() {
    override val bottomSheetOptions = super.bottomSheetOptions.copy(isShiftedWithKeyboard = true)
}

class StatesSheetBottomSheet : TestBottomSheet() {
    override val bottomSheetOptions = super.bottomSheetOptions.copy(
        isSkipCollapsed = false,
        heightStatesOptions = HeightStatesOptions(
            collapsedHeightPx = 50.px,
            halfExpandedHalfPx = 125.px
        )
    )
}

class ExampleBottomSheet(
    val name: String,
    val showAction: (FragmentManager) -> Unit
)

val BottomSheetCreateList = listOf(
    ExampleBottomSheet("Default BottomSheet") {
        TestBottomSheet().show(it, null)
    },
    ExampleBottomSheet("Non Cancelable BottomSheet") {
        NonCancelableBottomSheet().setItemCount(1).show(it, null)
    },
    ExampleBottomSheet("Touch Outside BottomSheet") {
        TouchOutsideBottomSheet().setItemCount(2).show(it, null)
    },
    ExampleBottomSheet("Collapsing BottomSheet") {
        CollapsingBottomSheet().setItemCount(30).show(it, null)
    },
    ExampleBottomSheet("Fullscreen BottomSheet") {
        FullscreenBottomSheet().show(it, null)
    },
    ExampleBottomSheet("Dark Dimmed BottomSheet") {
        DimmedBottomSheet().show(it, null)
    },
    ExampleBottomSheet("Animated Dimmed BottomSheet") {
        AnimatedDimmedBottomSheet().show(it, null)
    },
    ExampleBottomSheet("Shift with keyboard BottomSheet") {
        ShiftWithKeyboardBottomSheet().setItemCount(0).show(it, null)
    },
    ExampleBottomSheet("3 States BottomSheet") {
        StatesSheetBottomSheet().setItemCount(20).show(it, null)
    },
)

private fun TestBottomSheet.setItemCount(count: Int) = apply {
    arguments = bundleOf("itemCount" to count)
}
