package robot.mouse

import extensions.normalized
import java.awt.MouseInfo
import java.awt.Point
import java.awt.Robot

private val mousePosition: Point
    get() = MouseInfo.getPointerInfo().location

fun Robot.moveMouse(x: Float, y: Float, speed: Float) {
    if (x.normalized() || y.normalized()) {
        val speedModifier = MOUSE_MOVEMENT_SPEED + (MOUSE_MOVEMENT_EXTRA_SPEED * speed).toInt()

        val newX = mousePosition.x + (speedModifier * x).toInt()
        val newY = mousePosition.y - (speedModifier * y).toInt()

        mouseMove(newX, newY)
    }
}

private const val MOUSE_MOVEMENT_SPEED = 20
private const val MOUSE_MOVEMENT_EXTRA_SPEED = 60
