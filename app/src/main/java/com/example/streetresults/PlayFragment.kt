package com.example.streetresults

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random


class PlayFragment : Fragment() {
   private var playteam1:Button?=null
    private var playteam2:Button?=null
    private var textviewteam1:TextView?=null
    private var textviewteam2:TextView?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rand, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      playteam1=view.findViewById(R.id.team1button)
        playteam2=view.findViewById(R.id.team2button)
        textviewteam1=view.findViewById(R.id.textViewteam1)
        textviewteam2=view.findViewById(R.id.textViewteam2)
        var list=StartFragment.getteams()
        playteam1?.setOnClickListener {
            if(list.size!=0) {
                var num = Random.nextInt(StartFragment.getteams().size)

                textviewteam1?.text = list[num].title.toString()
            }
            else{
                textviewteam1?.text="There is no team"
            }


        }

        playteam2?.setOnClickListener {
            if(list.size!=0) {
                var num2 = Random.nextInt(StartFragment.getteams().size)

                textviewteam2?.text = list[num2].title.toString()
            }
            else{
                textviewteam2?.text="There is no team"
            }


        }
    }


}