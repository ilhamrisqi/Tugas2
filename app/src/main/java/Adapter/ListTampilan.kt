package Adapter

import Database.GlobalVar
import Listener.CardListener
import Model.Hewan
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tugas2.Create
import com.example.tugas2.R
import com.example.tugas2.databinding.CardanimalBinding
import java.util.ArrayList

class ListTampilan(val listHewan: ArrayList<Hewan>, val cardListener: CardListener):
    RecyclerView.Adapter<ListTampilan.viewHolder>(){
    class viewHolder(val itemView: View, val cardListener1: CardListener): RecyclerView.ViewHolder(itemView) {

        val binding = CardanimalBinding.bind(itemView)

        fun setData(data: Hewan) {
            binding.NamatextView.text = data.nama
            binding.JenistextView2.text = data.type
            binding.UsiatextView.text = data.usia


            itemView.setOnClickListener {
                cardListener1.onCardClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.cardanimal, parent, false)
        return  viewHolder(view,cardListener)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.setData(listHewan[position])
        with(holder) {
            binding.EditButton.setOnClickListener(){
                val myIntent = Intent(it.context, Create::class.java)
                myIntent.putExtra("position",position)

                it.context.startActivity(myIntent)
                Toast.makeText(it.context,"Succesfully Edited", Toast.LENGTH_SHORT).show()

            }

            binding.DeleteButton.setOnClickListener(){
                GlobalVar.listDataHewan.removeAt(position)
                notifyItemRemoved(position)
                notifyItemChanged(position,itemCount)
                Toast.makeText(it.context,"Succesfully Deleted", Toast.LENGTH_SHORT).show()
            }

            binding.SuaraButton.setOnClickListener(){
                Toast.makeText(it.context,"POK",Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun getItemCount(): Int {
        return listHewan.size
    }
}
