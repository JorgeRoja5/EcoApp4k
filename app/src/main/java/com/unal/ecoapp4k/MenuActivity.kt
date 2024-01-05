package com.unal.ecoapp4k

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

enum class ProviderType{
    BASIC
}

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val bundle: Bundle? = intent.extras
        val correo: String? = bundle?.getString("correo")
        val proveedor: String? = bundle?.getString("proveedor")

        setup(correo?:"",proveedor?:"")


        val calcularBotellasButton: Button = findViewById(R.id.button7)


        calcularBotellasButton.setOnClickListener {

        val intent = Intent(this@MenuActivity,BottleActivity::class.java)

        startActivity(intent)
    }

}
    private fun setup(correo: String, proveedor: String){
        title ="inicio"
        val btcerrar = findViewById<Button>(R.id.btcerrar)
        val tvcorreo = findViewById<TextView>(R.id.correotextview)
        val tvproveedor = findViewById<TextView>(R.id.proveedortextview)
        tvcorreo.text = correo
        tvproveedor.text = proveedor

        btcerrar.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }



    }
}