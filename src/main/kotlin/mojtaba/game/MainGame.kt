package mojtaba.game

import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.layout.StackPane
import javafx.stage.Stage

/**
 * Created by mojtab23 on 9/29/16.
 */
class MainGame : Application() {
    override fun start(primaryStage: Stage?) {
        if (primaryStage != null) {
            val root = StackPane(GameLoop.canvas)
            root.children.add(HUD)
            primaryStage.width = GameLoop.P_WIDTH
            primaryStage.height = GameLoop.P_HEIGHT
            primaryStage.scene = Scene(root)
            buildKeyListening(primaryStage.scene)
            primaryStage.show()
//            GameLoop.start()
        }
    }

    private fun buildKeyListening(scene: Scene) {

        scene.onKeyPressed = EventHandler<KeyEvent> {
            if (it.code == KeyCode.ESCAPE) {
                GameLoop.togglePause()
            }
        }

    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(MainGame::class.java)
        }

    }
}

