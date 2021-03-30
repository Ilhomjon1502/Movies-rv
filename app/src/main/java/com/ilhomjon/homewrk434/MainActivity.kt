package com.ilhomjon.homewrk434

import Adapter.CinemaAdapter
import Kesh.MySharedPrefarance
import Models.Cinema
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var cineList:ArrayList<Cinema> = ArrayList()
    lateinit var cinemaAdapter:CinemaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()

        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rv.addItemDecoration(dividerItemDecoration)
    }

    private fun loadData() {
        MySharedPrefarance.init(this)
        cineList = MySharedPrefarance.obektString
        cinemaAdapter = CinemaAdapter(this, cineList, object : CinemaAdapter.OnMyItemClickListener {
            override fun onMyItemClckDelete(cinema: Cinema, position: Int) {
                cineList = MySharedPrefarance.obektString
                cineList.removeAt(position)
                MySharedPrefarance.obektString = cineList
                println(position)
                loadData()
                cinemaAdapter.notifyDataSetChanged()
                Toast.makeText(this@MainActivity, "Removed", Toast.LENGTH_SHORT).show()
            }

            override fun onMyItemClckDEdit(cinema: Cinema, position: Int) {
                val intent = Intent(this@MainActivity, Edit::class.java)
                intent.putExtra("position", position)
                startActivity(intent)
            }

            override fun onMyLinClick(cinema: Cinema, position: Int) {
                val intent = Intent(this@MainActivity, Avangers::class.java)
                intent.putExtra("position", position)
                startActivity(intent)
            }

        })
        rv.adapter = cinemaAdapter
    }

    override fun onStart() {
        super.onStart()
        loadData()
        cinemaAdapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu):Boolean {
        val inflater = getMenuInflater()
        inflater.inflate(R.menu.my_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem):Boolean {
        // Handle item selection
        Log.i("menu", "menuItem")
        println("Funksiyga kirdi")
        when (item.getItemId()) {
            R.id.add_menu -> {
                val intent = Intent(this, addMovie::class.java)
                startActivity(intent)
                Toast.makeText(this, "Add menu", Toast.LENGTH_SHORT).show()
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}