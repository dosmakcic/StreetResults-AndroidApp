package com.example.streetresults.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.streetresults.R
import com.example.streetresults.TextResults

class ResultsRecyclerViewAdapter:RecyclerView.Adapter<ResultsRecyclerViewAdapter.TextViewHolder>() {
    private var textlist: MutableList<TextResults> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.noteresults, parent,
            false
        )
        return TextViewHolder(view)
    }

    class TextViewHolder constructor(itemview: View) : RecyclerView.ViewHolder(itemview) {
        private val textteam = itemView.findViewById<TextView>(R.id.resulttext)

        fun bind(list: TextResults) {
            textteam.text = list.Text
        }
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {

                var newtext=textlist[position]
        holder.bind(newtext)

    }

    override fun getItemCount(): Int {
        return textlist.size
    }

    fun postItemsData(data: MutableList<TextResults>) {
        textlist = data
        notifyDataSetChanged()
    }

    fun addcell(name: String, position: Int) {
        var textInfo = TextResults(name)
        if (textlist.size >= position) {
            textlist.add(position, textInfo)
            notifyItemInserted(position)
        }
    }
    fun clearall(){
        textlist.clear()
        notifyDataSetChanged()

    }
     }

