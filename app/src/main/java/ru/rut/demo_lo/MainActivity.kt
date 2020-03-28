package ru.rut.demo_lo

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction



class MainActivity : AppCompatActivity() {
    var fragmentManager: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ft: FragmentTransaction = fragmentManager.beginTransaction()
        ft.replace(R.id.frame, LinearLayoutFragment())
        ft.commit()

        val spinner: Spinner = findViewById(R.id.spinner)

        spinner.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                val ft: FragmentTransaction = fragmentManager.beginTransaction()

                when(position){
                    0 ->  ft.replace(R.id.frame, LinearLayoutFragment())
                    1 ->  ft.replace(R.id.frame, TableLayoutFragment())
                    2 ->  ft.replace(R.id.frame, FrameLayoutFragment())
                    3 ->  ft.replace(R.id.frame, ConstraintLayoutFragment())
                }

                ft.commit()
            }

        }


    }
}
