package com.dm.taskapp.ui.home

import java.io.Serializable

data class Task(
    var title: String,
    var desc: String
) : Serializable
