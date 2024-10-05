package robot.mouse

import java.awt.Robot
import java.awt.event.InputEvent

private var leftMouseButtonPressed = false

fun Robot.mouseLeftClick(pressed: Boolean) {
    if (pressed && !leftMouseButtonPressed) {
        leftMouseButtonPressed = true
        mousePress(InputEvent.BUTTON1_DOWN_MASK)
    } else if (!pressed && leftMouseButtonPressed) {
        leftMouseButtonPressed = false
        mouseRelease(InputEvent.BUTTON1_DOWN_MASK)
    }
}

private var rightMouseButtonPressed = false

fun Robot.mouseRightClick(pressed: Boolean) {
    if (pressed && !rightMouseButtonPressed) {
        rightMouseButtonPressed = true
        mousePress(InputEvent.BUTTON3_DOWN_MASK)
    } else if (!pressed && rightMouseButtonPressed) {
        rightMouseButtonPressed = false
        mouseRelease(InputEvent.BUTTON3_DOWN_MASK)
    }
}

fun Robot.mouseWheelClick() {
    mousePress(InputEvent.BUTTON2_DOWN_MASK)
    mouseRelease(InputEvent.BUTTON2_DOWN_MASK)
}

private val backButtonMask = InputEvent.getMaskForButton(4)

fun Robot.mouseBackClick() {
    mousePress(backButtonMask)
    mouseRelease(backButtonMask)
}

private val nextButtonMask = InputEvent.getMaskForButton(5)

fun Robot.mouseNextClick() {
    mousePress(nextButtonMask)
    mouseRelease(nextButtonMask)
}
