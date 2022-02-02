package com.example.streetresults.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.streetresults.R
import com.example.streetresults.StartFragment
import com.example.streetresults.Team

class StartRecyclerViewAdapter :RecyclerView.Adapter<StartRecyclerViewAdapter.TeamsViewHolder>(){

    private var teamlist:MutableList<Team> = ArrayList()





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):TeamsViewHolder {

           val view= LayoutInflater.from(parent.context).inflate(R.layout.addteam, parent,
                false)
           return TeamsViewHolder(view)


    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
    var newteam=teamlist[position]
                holder.bind(newteam)
                holder.delete.setOnClickListener {

                StartFragment.getteams().removeAt(position)
                    removecell(position)
                }

                holder.addpoints.setOnClickListener {
                    teamlist[position].points++
                    notifyItemChanged(position)
                    notifyDataSetChanged()
                }
                holder.resetbutton.setOnClickListener {
                  teamlist[position].points=0
                    notifyItemChanged(position)
                    notifyDataSetChanged()
                }

    }

    override fun getItemCount(): Int {
        return teamlist.size
    }
    fun postItemsData(data:MutableList<Team>){
        teamlist=data
        notifyDataSetChanged()
    }
    /* fun adddata(tlist:MutableList<Team>){
       teamlist.clear()
        teamlist.addAll(tlist)
        notifyDataSetChanged()
    } */
         fun addnewcell(name:String,position:Int){
            var teamInfo=Team(name,0)
            if (teamlist.size >= position) {
                teamlist.add(position, teamInfo)
                notifyItemInserted(position)
                notifyDataSetChanged()
            }
        }

     private   fun removecell(position: Int){
          if(teamlist.size>position){
              teamlist.removeAt(position)
              notifyItemRemoved(position)
              notifyItemRangeChanged(position,itemCount)
          }
        }
    class TeamsViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        var teamname=itemView.findViewById<TextView>(R.id.team_name)

        var points=itemView.findViewById<TextView>(R.id.pointsnumber)
        var delete=itemView.findViewById<ImageButton>(R.id.deletebutton)
        var addpoints=itemView.findViewById<ImageButton>(R.id.addpoints)
        var resetbutton=itemView.findViewById<ImageButton>(R.id.resetpoints)

        fun bind(team:Team){
            teamname?.text=team.title.toString()
            points?.text=team.points.toString()


        }

    }



}