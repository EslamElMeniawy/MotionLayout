package elmeniawy.eslam.motionlayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.motion.MotionLayout
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        motion_container.setTransitionListener(
                object : MotionLayout.TransitionListener {
                    override fun onTransitionChange(motionLayout: MotionLayout?,
                                                    startId: Int,
                                                    endId: Int,
                                                    progress: Float) {
                        seekBar.progress = ceil(progress * 100).toInt()
                    }

                    override fun onTransitionCompleted(motionLayout: MotionLayout?,
                                                       currentId: Int) {
                        if (currentId == R.id.ending_set) {
                            // Return to original constraint set
                            motion_container.transitionToStart()
                        }
                    }
                }
        )
    }

    fun start(v: View) {
        motion_container.transitionToEnd()
    }
}
