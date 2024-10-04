import com.studiohartman.jamepad.ControllerManager
import kotlin.system.exitProcess

// https://github.com/williamahartman/Jamepad
fun main() {
    val controllers = ControllerManager().apply {
        initSDLGamepad()
    }

    while (true) {
        Thread.sleep(TICK_TIME_MILLISECONDS)

        val state = controllers.getState(0)

        if (!state.isConnected) {
            Thread.sleep(1000)
        } else if (state.startJustPressed) {
            exit()
        }

        XBoxToPCController.control(state = state)
    }
}

private fun exit() {
    exitProcess(0)
}

private const val TICK_TIME_MILLISECONDS = 16L // 60 frames per second
