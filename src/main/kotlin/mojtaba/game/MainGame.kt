package mojtaba.game

import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage

/**
 * Created by mojtab23 on 9/29/16.
 */
class MainGame : Application() {
    override fun start(primaryStage: Stage?) {
        if (primaryStage != null) {
            val root = GameLoop.canvas
            primaryStage.width = GameLoop.P_WIDTH
            primaryStage.height = GameLoop.P_HEIGHT
            primaryStage.scene = Scene(root)
            primaryStage.show()
            GameLoop.start()
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(MainGame::class.java)
        }

    }
}

