package com.dm.taskapp.ui.onBoard

import java.io.Serializable

data class OnBoard(
    var img: Int? = null,
    var title: String? = null,
    var desc: String? = null,
    var isLast: Boolean? = null
) : Serializable
