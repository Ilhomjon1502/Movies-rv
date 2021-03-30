package Adapter

import Models.Cinema
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ilhomjon.homewrk434.R
import kotlinx.android.synthetic.main.item_view_rv.view.*

class CinemaAdapter(val contect:Context, var cinemaList: List<Cinema>, val myItemClickListener: OnMyItemClickListener)
    :RecyclerView.Adapter<CinemaAdapter.MyHolder>(){

    inner class MyHolder(var itemView:View) : RecyclerView.ViewHolder(itemView){
        fun onBind(cinema:Cinema, position: Int){
            println(cinema)
            itemView.txt_name_item_rv.text = cinema.name
            itemView.txt_authors.text = cinema.muallif
            itemView.txt_sana_item_rv.text = cinema.sana


            itemView.btn_delete.setOnClickListener {
                myItemClickListener.onMyItemClckDelete(cinema, position)
            }

            itemView.btn_edit.setOnClickListener {
                myItemClickListener.onMyItemClckDEdit(cinema, position)
            }

            itemView.lin_rv.setOnClickListener {
                myItemClickListener.onMyLinClick(cinema, position)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_view_rv, parent, false)
        val myHolder = MyHolder(itemView)
        return myHolder
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.onBind(cinemaList[position], position)
    }

    override fun getItemCount(): Int {
        return cinemaList.size
    }

    interface OnMyItemClickListener{
        fun onMyItemClckDelete(cinema: Cinema, position: Int)
        fun onMyItemClckDEdit(cinema: Cinema, position: Int)
        fun onMyLinClick(cinema: Cinema, position: Int)
        //   fun onMyItemLongCLick(contact: Contact)
    }

}