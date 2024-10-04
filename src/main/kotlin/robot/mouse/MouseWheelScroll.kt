package robot.mouse

import extensions.normalized
import java.awt.Robot
import kotlin.math.absoluteValue

private var verticalScrollSkipCounter = 0

fun Robot.mouseWheelScrollVertical(value: Float) {
    if (verticalScrollSkipCounter > 0) {
        verticalScrollSkipCounter -= 1
    } else if (verticalScrollSkipCounter < 0) {
        verticalScrollSkipCounter = 0
    } else {
        if (value.normalized(0.1f)) {
            val wheelAmt = if (value > 0) -1 else 1
            mouseWheel(wheelAmt)

            val valuePositive = value.absoluteValue
            verticalScrollSkipCounter = when {
                valuePositive >= 1f -> 1
                valuePositive >= 0.66f -> 2
                valuePositive >= 0.33f -> 3
                else -> 4
            }
        }
    }
}
