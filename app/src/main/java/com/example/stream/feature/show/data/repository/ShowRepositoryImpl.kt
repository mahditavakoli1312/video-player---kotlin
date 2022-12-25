package com.example.stream.feature.show.data.repository

import com.example.stream.feature.show.data.datasource.local.ShowLocalDataSource
import com.example.stream.feature.show.data.model.entity.VideoDetailsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ShowRepositoryImpl @Inject constructor(
    private var showLocalDataSource: ShowLocalDataSource
) : ShowRepository {
    override fun getVideoDetail(): Flow<VideoDetailsEntity> =
        showLocalDataSource.getVideoDetail()
}