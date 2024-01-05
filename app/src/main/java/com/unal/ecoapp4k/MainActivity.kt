package com.unal.ecoapp4k

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private lateinit var logo: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logo = findViewById(R.id.logo)
        startRotationAnimation()


        //setup
        setup()


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
        rotateAnimation.repeatCount = Animation.RESTART

        // Inicia la animación en el ImageView
        logo.startAnimation(rotateAnimation)  }

    private fun setup() {
        title = "Autenticación"

        val etcorreo = findViewById<EditText>(R.id.etcorreo)
        val etcontrasena = findViewById<EditText>(R.id.etcontraseña)
        val registrarse = findViewById<Button>(R.id.Btregistrarse)
        val inicirsesion = findViewById<Button>(R.id.Btiniciarsesion)
        registrarse.setOnClickListener{
         if (etcorreo.text.isNotEmpty() && etcontrasena.text.isNotEmpty())
             FirebaseAuth.getInstance().createUserWithEmailAndPassword(etcorreo.text.toString(),etcontrasena.text.toString()).addOnCompleteListener {
                 if (it.isSuccessful){
                     showmenu(it.result?.user?.email ?:"",ProviderType.BASIC)
                 } else{
                     showalert()

                 }
             }

         }

        inicirsesion.setOnClickListener{
            if (etcorreo.text.isNotEmpty() && etcontrasena.text.isNotEmpty())
                FirebaseAuth.getInstance().signInWithEmailAndPassword(etcorreo.text.toString(),etcontrasena.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful){
                        showmenu(it.result?.user?.email ?:"",ProviderType.BASIC)
                    } else{
                        showalert()

                    }
                }

        }

    }




private fun showalert(){
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error al autenticar el usuario")
        builder.setPositiveButton("Aceptar",null)
        val dialog:AlertDialog=builder.create()
        dialog.show()
    }

    private fun showmenu (correo:String,proveedor: ProviderType){

    val menuIntent = Intent(this@MainActivity,MenuActivity::class.java).apply {
        putExtra("correo",correo)
        putExtra("proveedor",proveedor.name)
    }
        startActivity(menuIntent)


}
}














