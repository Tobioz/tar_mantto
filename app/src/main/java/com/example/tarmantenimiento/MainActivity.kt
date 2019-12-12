package com.example.tarmantenimiento

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import kotlinx.android.synthetic.main.activity_main.*
import java.text.FieldPosition
import java.util.*
import android.view.ViewGroup
import android.widget.*




class MainActivity : AppCompatActivity() {
    var x: Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var url: String = ""

        val spinner: Spinner = findViewById(R.id.spinner)
        ArrayAdapter.createFromResource(
            this, R.array.matriculas, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource((android.R.layout.simple_spinner_dropdown_item))
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    x = position
                    Toast.makeText(parent?.getContext(), parent?.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();

                    when (position) {
                        0 -> url ="https://docs.google.com/forms/d/e/1FAIpQLSczZrxlH-Km1ipYGu_pJmNGMAz43LUtaXFmHOWGJHDhfONUkA/viewform?usp=sf_link"
                        1 -> url = "https://docs.google.com/forms/d/e/1FAIpQLSfzAPxxl3M9Fprj6bNemcaP4DKhbmdBEGIG7zFH0d0CdbEkuQ/viewform?usp=sf_link"
                        2 -> url = "https://docs.google.com/forms/d/e/1FAIpQLSf-TEgdp0uzbj08V0Z8NL6sYCdSweR3wHMEIPMRe69zhOL9_w/viewform?usp=sf_link"
                        3 -> url = "https://docs.google.com/forms/d/e/1FAIpQLScz10WJSIcv-6U7NHq6dmwo2X0XDFKwzahLZxwtHC77C6jvHg/viewform?usp=sf_link"
                        4 -> url = "https://docs.google.com/forms/d/e/1FAIpQLSf9HCrAQs6g8Ib99rngKTgjgik1AF48j109oe_de8jPE-jKKw/viewform?usp=sf_link"
                        5 -> url = "https://docs.google.com/forms/d/e/1FAIpQLSdL6gZhHPZaYPUuMA3o9RKeR4kXP2daziyceLwnpnVJNIs-xw/viewform?usp=sf_link"
                        6 -> url = "https://docs.google.com/forms/d/e/1FAIpQLSfZzu5SIt5r17-UMiPbNh8xzedu2nsIondVZYYa_PHQ3dLUew/viewform?usp=sf_link"
                        7 -> url = "https://docs.google.com/forms/d/e/1FAIpQLSf2SP3M_SJb4lCYcY4m1LZ0DRBTsHXF__Kzhe-y-OGP-40Upw/viewform?usp=sf_link"
                        8 -> url = "https://docs.google.com/forms/d/e/1FAIpQLScpeRdPAfMcW4qV-3CyAeZ4vtVidVkcnE3HAHhjGkBJJSUJ1w/viewform?usp=sf_link"
                        9 -> url = "https://docs.google.com/forms/d/e/1FAIpQLSejlAGKLHkd6OE6ZHvVcpwon4Kp1VUmekrOKHLhHzKRnN5ptg/viewform?usp=sf_link"
                        10 -> url = "https://docs.google.com/forms/d/e/1FAIpQLSeE0FyV-5DWN2N2_9v6HlaORT_DR9jYG1xTpgJI1wn2VBYkOw/viewform?usp=sf_link"
                    }
                }


                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            }
        }
        button.setOnClickListener {
            val openUrl = Intent(Intent.ACTION_VIEW)
            openUrl.data = Uri.parse (url)
            startActivity(openUrl)
        }
        updt.setOnClickListener {
            val openUrl = Intent(Intent.ACTION_VIEW)
            openUrl.data = Uri.parse ("https://drive.google.com/file/d/1GFNA_opkYn05a3xO8hy6PgBeYaFk0LsA/view?usp=sharing")
            startActivity(openUrl)
        }
        fdbk.setOnClickListener {
            val openUrl = Intent(Intent.ACTION_VIEW)
            openUrl.data = Uri.parse ("https://docs.google.com/forms/d/e/1FAIpQLSdMWNbgfWdCKdp0tghZhF9zWovQz7kqTX05wuV_GaS59rFYSA/viewform?usp=sf_link")
            startActivity(openUrl)
        }



        FirebaseMessaging.getInstance().subscribeToTopic("TAR").addOnCompleteListener { task ->
            var msg = getString(R.string.msg_subscribed)
            if (!task.isSuccessful) {
                msg = getString(R.string.msg_subscribe_failed)
            }
        }
        FirebaseMessaging.getInstance().subscribeToTopic("MANTTO").addOnCompleteListener { task ->
            var msg = getString(R.string.msg_subscribed)
            if (!task.isSuccessful) {
                msg = getString(R.string.msg_subscribe_failed)
            }
        }
    }
}







