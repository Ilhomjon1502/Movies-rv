package com.ilhomjon.homewrk434

import Kesh.MySharedPrefarance
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_avangers.*

class Avangers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avangers)

        val position = intent.getIntExtra("position", 0)

        MySharedPrefarance.init(this)
        val array = MySharedPrefarance.obektString

        val name = array[position].name
        val authors = array[position].muallif
        val about = array[position].about
        val data = array[position].sana

        txt_name.text = "${txt_name.text} $name"
        txt_about.text = "${txt_about.text} $about"
        txt_authors.text = "${txt_authors.text} $authors"
        txt_data.text = "${txt_data.text} $data"

        btn_close.setOnClickListener {
            finish()
        }
    }
}