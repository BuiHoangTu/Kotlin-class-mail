package com.bhtu.gmail

import java.time.LocalTime

class IncomingEmail(
    var sender: String,
    var email: String,
    var time: LocalTime,
    var content: String,
    var checkbox: Boolean,
    var image: Int
)