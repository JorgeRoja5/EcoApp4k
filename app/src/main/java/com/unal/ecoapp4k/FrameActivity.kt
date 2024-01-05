package com.unal.ecoapp4k

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.os.Handler
import android.content.Intent


class FrameActivity : AppCompatActivity() {

    private lateinit var logo2: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame)

        logo2 = findViewById(R.id.logo2)
        startRotationAnimation()
    }
    private fun startRotationAnimation() {
        val rotateAnimation = RotateAnimation(
            0f,360f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )

        // Establece la duración de la animación en milisegundos
        rotateAnimation.duration = 3000

        // Establece que la animación se repita indefinidamente
        rotateAnimation.repeatCount = Animation.INFINITE

        // Inicia la animación en el ImageView
        logo2.startAnimation(rotateAnimation)

        // Espera 5 segundos y luego inicia la actividad principal
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Cierra la actividad actual para que no pueda volver atrás
        }, 5000) // 5000 milisegundos = 5 segundos
    }
}


