package com.example.streetresults

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.streetresults.adapters.ResultsRecyclerViewAdapter


/*import com.example.streetresults.adapters.RecycleView2Adapter */


class ResultsFragment : Fragment() {

    private val adapter = ResultsRecyclerViewAdapter()
    lateinit var rv:RecyclerView
    private var add_button:Button?=null
    private var edit_text: TextView?=null
    private var clear_button:Button?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_results, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setrv(view)
        setbuttons(view)
        add_button?.setOnClickListener {
            val textname=edit_text?.text.toString()
            textlist.add(0,TextResults(textname))
            adapter.addcell(textname,0)

        }
        clear_button?.setOnClickListener {
            textlist.clear()
            adapter.clearall()
        }
    }

    private fun setbuttons(view: View){
        add_button=view.findViewById(R.id.plus)
        edit_text=view.findViewById(R.id.textresults)
        clear_button=view.findViewById(R.id.clearbutton)
    }
    private fun setrv(view:View){
        rv=view.findViewById(R.id.resutsview)
        rv.layoutManager=LinearLayoutManager(view.context)
        rv.adapter=adapter
    }
    companion object get {
        private var textlist: MutableList<TextResults> = ArrayList()

        fun getteams(): MutableList<TextResults> {
            return textlist
        }
    }

}