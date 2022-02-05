package perez.isai.asignacion4_calculadoraimc_perezisai

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val PESO: EditText = findViewById(R.id.etPeso) as EditText
        val ESTATURA: EditText = findViewById(R.id.etEstatura) as EditText
        val btnCalcular: Button = findViewById(R.id.btnCalcular) as Button
        val IMC: TextView = findViewById(R.id.tvIMC) as TextView
        val RANGO: TextView = findViewById(R.id.tvRango) as TextView

        btnCalcular.setOnClickListener {
            var txtPeso = PESO.text
            var valorPeso: Float? = txtPeso.toString().toFloat()
            var txtEstatura = ESTATURA.text
            var valorEstatura: Float? = txtEstatura.toString().toFloat()
            var IMCTotal = valorPeso?.div(Math.pow(valorEstatura!!.toDouble(), 2.0))
            IMC.setText("IMC: " + IMCTotal)
            if (IMCTotal!! <= 18.5) {
                cambiarColor(RANGO,"Bajo peso",R.color.colorGreenish)
            } else if (IMCTotal!! <= 24.9) {
                cambiarColor(RANGO,"Normal",R.color.colorGreen)
            } else if (IMCTotal!! <= 29.9) {
                cambiarColor(RANGO,"Sobrepeso",R.color.colorYellow)
            } else if (IMCTotal!! <= 34.9) {
                cambiarColor(RANGO,"Obesidad grado 1",R.color.colorOrange)
            } else if (IMCTotal!! <= 39.9) {
                cambiarColor(RANGO,"Obesidad grado 2",R.color.colorRed)
            } else {
                cambiarColor(RANGO,"Obesidad grado 3",R.color.colorBrown)
            }
        }
    }

    fun cambiarColor(RANGO:TextView, texto: String, color: Int) {
        RANGO.setText(texto)
        RANGO.setBackgroundResource(color)
    }
}
