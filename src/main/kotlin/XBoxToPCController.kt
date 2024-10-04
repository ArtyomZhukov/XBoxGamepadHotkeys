import com.studiohartman.jamepad.ControllerState
import robot.keyboard.arrowButtons
import robot.keyboard.holdShift
import robot.mouse.*
import java.awt.Robot
import java.awt.event.KeyEvent

object XBoxToPCController {

    private val robot = Robot()

    fun control(state: ControllerState) {
        robot.moveMouse(x = state.leftStickX, y = state.leftStickY, speed = state.leftTrigger)

        robot.mouseRightClick(pressed = state.lb)
        robot.mouseLeftClick(pressed = state.rb)

        robot.mouseWheelScrollVertical(value = state.rightStickY)

        if (state.leftStickJustClicked) {
            robot.mouseBackClick()
        }
        if (state.rightStickJustClicked) {
            robot.mouseNextClick()
        }

        robot.arrowButtons(left = state.dpadLeft, right = state.dpadRight, up = state.dpadUp, down = state.dpadDown)

        if (state.yJustPressed) {
            muteDiscord()
        }
        if (state.xJustPressed) {
            enterClick()
        }
        if (state.aJustPressed) {
            muteTalk()
        }
        if (state.bJustPressed) {
            turnOffVideoTalk()
        }

        robot.holdShift(value = state.rightTrigger)
    }

    private fun enterClick() {
        robot.keyPress(KeyEvent.VK_ENTER)
        robot.keyRelease(KeyEvent.VK_ENTER)
    }

    private fun muteDiscord() {
        robot.keyPress(KeyEvent.VK_PAUSE)
        robot.keyRelease(KeyEvent.VK_PAUSE)
    }

    private fun muteTalk() {
        robot.keyPress(KeyEvent.VK_M)
        robot.keyRelease(KeyEvent.VK_M)
    }

    private fun turnOffVideoTalk() {
        robot.keyPress(KeyEvent.VK_V)
        robot.keyRelease(KeyEvent.VK_V)
    }
}
