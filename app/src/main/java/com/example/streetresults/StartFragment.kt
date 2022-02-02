package com.example.streetresults

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.streetresults.adapters.StartRecyclerViewAdapter


class StartFragment : Fragment() {

    private  val adapter= StartRecyclerViewAdapter()

    lateinit  var rv_teams: RecyclerView
    private   var add_button: Button?=null
    private  var edittext: TextView?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)

    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)




        initView(view)

        setupbuttons(view)


                add_button?.setOnClickListener {
                    val teamname=edittext?.text.toString()
                    teamlist.add(0,Team(teamname,0))
                    adapter.addnewcell(teamname,0)

                }

    }

    private fun initView(view: View) {
        rv_teams=view.findViewById(R.id.rvTeams)

        rv_teams.layoutManager = LinearLayoutManager(view.context)

            rv_teams.adapter=adapter



    }

    private fun setupbuttons(view:View){
        add_button = view.findViewById<Button>(R.id.add)
        edittext = view.findViewById<EditText>(R.id.textresults)
    }


    companion object get {
        private var teamlist: MutableList<Team> = ArrayList()

        fun getteams(): MutableList<Team> {
            return teamlist
        }
    }
}
















