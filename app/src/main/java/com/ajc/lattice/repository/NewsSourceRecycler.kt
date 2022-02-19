package com.ajc.lattice.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ajc.lattice.model.remote.Article
import com.ajc.lattice.model.remote.ResponseDTO
import com.ajc.lattice.model.remote.api.ApiService
import retrofit2.Response

class NewsSourceRecycler(private val apiService: ApiService) : PagingSource<Int, Article>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        return try {
            val pageNumber = params.key ?: 1
            val response: Response<ResponseDTO> =
                apiService.getData("usa", "b5becfb5a3d34c7991cb1af2c22c0d57", 1)
            val data = response.body()?.articles as List<Article>
            LoadResult.Page(
                data = data,
                prevKey = null,
                nextKey = if (data.isEmpty()) null else pageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }
}