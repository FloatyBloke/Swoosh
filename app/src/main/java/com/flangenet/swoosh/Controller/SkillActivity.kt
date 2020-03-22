package com.flangenet.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.flangenet.swoosh.Model.Player
import com.flangenet.swoosh.R
import com.flangenet.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
        println(player.league)
    }

    fun onBallerClick(view: View){
        beginnerSkilBtn.isChecked = false
        player.skill = "baller"

    }

    fun onBeginnerClick(view: View){
        ballerSkilBtn.isChecked = false
        player.skill = "beginner"
    }

    fun onSkillFinishClick(view: View){

        if (player.skill != ""){
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)

            startActivity(finishActivity)
        } else {
            Toast.makeText(this,"Please select a skill level", Toast.LENGTH_SHORT).show()
        }


    }
}
