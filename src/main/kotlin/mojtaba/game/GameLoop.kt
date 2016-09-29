package mojtaba.game

import javafx.animation.AnimationTimer
import javafx.beans.binding.Bindings
import javafx.beans.property.LongProperty
import javafx.beans.property.SimpleLongProperty
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import java.time.Duration
import java.time.temporal.ChronoUnit

/**
 * Created by mojtab23 on 9/29/16.
 */
object GameLoop : AnimationTimer() {


    const val P_WIDTH = 800.0
    const val P_HEIGHT = 600.0

    @Volatile var running = false

    val canvas = StackPane()
    val debugInfo = Label("...")
    var startTime: LongProperty = SimpleLongProperty(0)
    var beforeTime: Long = 0

    init {
        canvas.alignment = Pos.TOP_LEFT
        canvas.background = Background(BackgroundFill(Color.AZURE, CornerRadii(0.0), Insets(0.0)))
        canvas.children.add(debugInfo)
        debugInfo.padding = Insets(10.0)
    }

    override fun handle(now: Long) {
        if (running) {
            val now = System.nanoTime()
            val timeDiff = now - beforeTime
            Bindings.subtract(SimpleLongProperty(now), startTime)
            val duration = Duration.of(startTime.value, ChronoUnit.NANOS)
            val fps = 1000000000.0 / timeDiff
//            gameUpdate()


            debugInfo.text = "Time: ${duration.toMillis()}, Fps: $fps"
            beforeTime = System.nanoTime()
        }
    }

    override fun start() {
        startTime.value = System.nanoTime()
        running = true
        super.start()
    }

    override fun stop() {
        running = false
        super.stop()
    }

}