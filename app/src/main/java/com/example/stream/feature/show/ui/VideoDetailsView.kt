package com.example.stream.feature.show.ui

import com.example.stream.feature.show.data.model.entity.VideoDetailsEntity

data class VideoDetailsView(
    val url: String,
    val description: String
)

fun VideoDetailsEntity.toVideoDetailsView() =
    VideoDetailsView(
        url = url,
        description = description
    )
