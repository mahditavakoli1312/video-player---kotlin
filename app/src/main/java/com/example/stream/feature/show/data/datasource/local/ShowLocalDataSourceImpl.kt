package com.example.stream.feature.show.data.datasource.local

import com.example.stream.feature.show.data.model.entity.VideoDetailsEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ShowLocalDataSourceImpl @Inject constructor(): ShowLocalDataSource {
    override fun getVideoDetail(): Flow<VideoDetailsEntity> {
        return flow {
            VideoDetailsEntity(
                url = "https://hajifirouz9.cdn.asset.aparat.com/aparat-video/49713c73d4684f173db27d1ffc5d700449416021-360p.mp4?wmsAuthSign=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbiI6IjQ5OWVmMWZiMzczNzI0NTI2YmFhZmI0OWEzNmQ0YzIwIiwiZXhwIjoxNjcxOTgxNDE1LCJpc3MiOiJTYWJhIElkZWEgR1NJRyJ9.1r6-Fy5WmvS8pzX1pGsiQVSGXJGlCSRraN10yfepWQM",
                description = "کباب ایرانی"
            )
        }
    }
}