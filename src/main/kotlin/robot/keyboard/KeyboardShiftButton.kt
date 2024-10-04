package robot.keyboard

import java.awt.Robot
import java.awt.event.KeyEvent

private var shiftPressed = false

fun Robot.holdShift(value: Float) {
    if (value >= SHIFT_HOLD_MIN_VALUE && !shiftPressed) {
        shiftPressed = true
        keyPress(KeyEvent.VK_SHIFT)
    } else if (value < SHIFT_HOLD_MIN_VALUE && shiftPressed) {
        shiftPressed = false
        keyRelease(KeyEvent.VK_SHIFT)
    }
}

private const val SHIFT_HOLD_MIN_VALUE = 0.5f
