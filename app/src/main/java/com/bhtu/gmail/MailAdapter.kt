package com.bhtu.gmail

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MailAdapter(
    private var mails: List<IncomingEmail>,
    private var context: Context
) : RecyclerView.Adapter<MailHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MailHolder {
        return MailHolder(
            LayoutInflater.from(context).inflate(R.layout.email_display, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return mails.size
    }

    override fun onBindViewHolder(holder: MailHolder, position: Int) {
        holder.nameView.text = mails[position].sender
        holder.emailView.text = mails[position].email
        holder.timeView.text = mails[position].time.toString()
        holder.contentView.text = mails[position].content
        holder.imageView.setImageResource(mails[position].image)
        holder.checkBox.isChecked = mails[position].checkbox

        holder.checkBox.setOnClickListener {
            mails[position].checkbox = holder.checkBox.isChecked
        }
    }

}