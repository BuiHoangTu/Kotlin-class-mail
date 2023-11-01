package com.bhtu.gmail

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MailHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var imageView: ImageView
    var nameView: TextView
    var emailView: TextView
    var timeView: TextView
    var contentView: TextView
    var checkBox: CheckBox

    init {
        imageView = itemView.findViewById(R.id.imageview)
        nameView = itemView.findViewById(R.id.name)
        emailView = itemView.findViewById(R.id.email)
        timeView = itemView.findViewById(R.id.time)
        contentView = itemView.findViewById(R.id.content)
        checkBox = itemView.findViewById(R.id.favourite)
    }
}