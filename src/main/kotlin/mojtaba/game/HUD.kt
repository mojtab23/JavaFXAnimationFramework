package mojtaba.game

import javafx.application.Platform
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.VBox
import javafx.scene.paint.Color

/**
 * Created by mojtab23 on 9/29/16.
 */
object HUD : VBox() {
    val gameLoop = GameLoop

    private val pauseButton = buildResumeButton()

    private val exitButton = buildQuitButton()

    init {
        alignment = Pos.CENTER
        children.add(pauseButton)
        children.add(exitButton)
        background = Background(BackgroundFill(Color.rgb(200, 200, 200, 0.9), CornerRadii.EMPTY, Insets.EMPTY))
    }


    fun buildResumeButton(): Button {
        val button = Button("Resume")
        button.setOnAction { gameLoop.pausedProperty.value = false }
        return button
    }

    fun buildQuitButton(): Button {
        val button = Button("Quit")
        button.setOnAction {
            gameLoop.pausedProperty.value = true
            Platform.exit()
        }
        return button
    }

}
