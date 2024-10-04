package robot.keyboard

import java.awt.Robot
import java.awt.event.KeyEvent

private var arrowsKeyboardSkipCounter = 0
private var arrowsKeyboardSkipCount = 6

fun Robot.arrowButtons(
    left: Boolean,
    right: Boolean,
    up: Boolean,
    down: Boolean,
) {
    if (arrowsKeyboardSkipCounter > 0) {
        arrowsKeyboardSkipCounter -= 1
    } else if (arrowsKeyboardSkipCounter < 0) {
        arrowsKeyboardSkipCounter = 0
    } else {
        if (left) {
            keyPress(KeyEvent.VK_LEFT)
            keyRelease(KeyEvent.VK_LEFT)
            arrowsKeyboardSkipCounter = arrowsKeyboardSkipCount
        }
        if (right) {
            keyPress(KeyEvent.VK_RIGHT)
            keyRelease(KeyEvent.VK_RIGHT)
            arrowsKeyboardSkipCounter = arrowsKeyboardSkipCount
        }
        if (up) {
            keyPress(KeyEvent.VK_UP)
            keyRelease(KeyEvent.VK_UP)
            arrowsKeyboardSkipCounter = arrowsKeyboardSkipCount
        }
        if (down) {
            keyPress(KeyEvent.VK_DOWN)
            keyRelease(KeyEvent.VK_DOWN)
            arrowsKeyboardSkipCounter = arrowsKeyboardSkipCount
        }
    }
}
