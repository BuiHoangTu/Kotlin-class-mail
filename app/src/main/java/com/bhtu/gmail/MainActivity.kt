package com.bhtu.gmail

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalTime
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private val senders = setOf(
        "John Wick",
        "Robert J",
        "James Gunn",
        "Ricky Tales",
        "Micky Mouse",
        "Pick War").toList()
    private val charPool = ('a'..'z') + ('A'..'Z') + ('0'..'9')

    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)



        val incomingEmails = ArrayList<IncomingEmail>()

        repeat(20) {
            val random = Random(it)
            val sender = senders[random.nextInt(0, senders.size)]
            val delimiter = sender.indexOf(' ')
            val firstName = sender.lowercase().subSequence(0, delimiter)
            val restName = sender.lowercase().subSequence(delimiter + 1, sender.length)

            val avatar = this.resources.getIdentifier("user_${firstName}_${restName}", "drawable", this.packageName)
            Log.v("TAG", "avatar_id of user_${firstName}_${restName} = $avatar")

            incomingEmails.add(IncomingEmail(
                sender,
                "$firstName.$restName@mail.com",
                LocalTime.of(random.nextInt(0, 23), random.nextInt(0, 59)),
                List(random.nextInt(20, 200)) {charPool.random()}.joinToString(""),
                false,
                avatar))
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MailAdapter(incomingEmails, applicationContext)


    }
}

