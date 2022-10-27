package com.derekci.practica1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.derekci.practica1.databinding.ActivityMainBinding
import kotlin.math.sqrt

lateinit var binding: ActivityMainBinding



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val opciones = resources.getStringArray(R.array.opciones)

        var imagen = binding.imageView
        var opciona = binding.opciona
        var opcionb = binding.opcionb
        var opcionc = binding.opcionc
        var boton = binding.button

        var valor1 = binding.valor1
        var valor2 = binding.valor2
        var valor3 = binding.valor3


        val spinner = binding.spinner

        if (spinner!=null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(this@MainActivity,
                        getString(R.string.selected_item) + " " + "" + opciones[position],
                        Toast.LENGTH_SHORT).show()
                    if (position == 0) {
                        imagen.setImageResource(R.drawable.formula1)
                        opciona.setText(R.string.textA)
                        opcionb.setText(R.string.textB)
                        opcionc.setText(R.string.textC)
                        boton.setOnClickListener { view ->
                            //  (-b +-  raiz( b*b - 4ac))/2a
                            var a = valor1.text.toString().toDouble()
                            var b = valor2.text.toString().toDouble()
                            var c = valor3.text.toString().toDouble()

                            var raiz = (b * b) - 4 * (a * c)

                            var b1 = b * (-1)
                            var a1 = 2 * a
                            var resultado1 = b1 + sqrt(raiz) / a1
                            var resultado2 = b1 - sqrt(raiz) / a1

                            val intent = Intent(this@MainActivity, Activity2::class.java).apply {
                                putExtra("resultado1", resultado1)
                                putExtra("resultado2", resultado2)
                            }
                            startActivity(intent)
                        }

                    } else if (position == 1) {
                        imagen.setImageResource(R.drawable.formula2)
                        opciona.setText(R.string.textPi)
                        opcionb.setText(R.string.textr1)
                        opcionc.setText(R.string.texth)
                        boton.setOnClickListener { view ->
                            //pi x rxr x h
                            var pi = valor1.text.toString().toDouble()
                            var r = valor2.text.toString().toDouble()
                            var h = valor3.text.toString().toDouble()

                            var resultado1 = pi * (r * r) * h
                            val intent = Intent(this@MainActivity, Activity2::class.java).apply {
                                putExtra("resultado1", resultado1)
                                putExtra("resultado2", 0)
                            }
                            startActivity(intent)
                        }
                    } else if (position == 2) {
                        imagen.setImageResource(R.drawable.formula3)
                        opciona.setText(R.string.textK)
                        opcionb.setText(R.string.textQ)
                        opcionc.setText(R.string.textr2)
                        boton.setOnClickListener { view ->
                            //K * q/r
                            var k = valor1.text.toString().toDouble()
                            var q = valor2.text.toString().toDouble()
                            var r = valor3.text.toString().toDouble()

                            var resultado1 = k * (q / r)
                            val intent = Intent(this@MainActivity, Activity2::class.java).apply {
                                putExtra("resultado1", resultado1)
                                putExtra("resultado2", 0)
                            }
                            startActivity(intent)
                        }

                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }
    }
}

