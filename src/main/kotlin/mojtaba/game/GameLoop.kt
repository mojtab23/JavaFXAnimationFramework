package mojtaba.game

import javafx.animation.AnimationTimer
import javafx.beans.property.SimpleBooleanProperty
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color

/**
 * Created by mojtab23 on 9/29/16.
 */
object GameLoop : AnimationTimer() {


    const val P_WIDTH = 800.0
    const val P_HEIGHT = 600.0

    @Volatile var running = false

    val pausedProperty = SimpleBooleanProperty(true)
    val canvas = StackPane()
    val debugInfo = Label("N/A")
    var beforeTime: Long = 0

    init {
        canvas.alignment = Pos.TOP_LEFT
        canvas.background = Background(BackgroundFill(Color.AZURE, CornerRadii(0.0), Insets(0.0)))

        canvas.children.add(debugInfo)
        pausedProperty.addListener({ value, old, new ->
            if (new != null)
                if (new) {
                    stop()
                    HUD.isVisible = true
                } else {
                    running = true
                    HUD.isVisible = false
                    super.start()
                }
        })
        debugInfo.padding = Insets(10.0)
    }

    override fun handle(now: Long) {
        if (running) {
            val now = System.nanoTime()
            val timeDiff = now - beforeTime
            val fps = 1000000000.0 / timeDiff
//            gameUpdate()


            debugInfo.text = "Fps: $fps"
            beforeTime = System.nanoTime()
        }
    }

    override fun start() {
        throw UnsupportedOperationException("Do not use this method!")
    }

    override fun stop() {
        running = false
        super.stop()
    }


    fun togglePause() {
        pausedProperty.value = !pausedProperty.value
    }

}