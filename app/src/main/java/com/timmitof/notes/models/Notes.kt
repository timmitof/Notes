package com.timmitof.notes.models

import androidx.room.PrimaryKey
import java.io.Serializable

data class Notes(
    var id: Int,
    var name: String ?= null,
    var shortDescription: String ?= null,
    var detailedDescription: String ?= null,
    var startDateEvent: String ?= null,
    var endDateEvent: String ?= null,
    var userNotes: String ?= null,
) : Serializable
