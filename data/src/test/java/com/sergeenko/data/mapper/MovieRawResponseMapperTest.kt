package com.sergeenko.data.mapper

import com.google.common.truth.Truth.assertThat
import com.sergeenko.data.movies.models.MovieRawResults
import com.sergeenko.data.movies.models.PopularMovieResponse
import com.sergeenko.domain.models.Response.ResponseSuccess
import com.sergeenko.domain.models.ShowModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody
import org.junit.Test
import retrofit2.Response

class MovieRawResponseMapperTest{

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test_response_not_success() = runTest {
        val fakeResponseBody = ResponseBody.create(null, "")
        val fakeResponse = Response.error<PopularMovieResponse>(404, fakeResponseBody)

        val movieRawResponseMapper = MovieRawResponseMapper(fakeResponse)
        val result: com.sergeenko.domain.models.Response = movieRawResponseMapper.map()
        assertThat(result).isInstanceOf(com.sergeenko.domain.models.Response.ResponseError::class.java)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test_response_success_and_ids_are_the_same() = runTest {
        val list = ArrayList<MovieRawResults>(10)

        val fakeResponse = Response.success(PopularMovieResponse(results = list))
        val movieRawResponseMapper = MovieRawResponseMapper(fakeResponse)

        val result: com.sergeenko.domain.models.Response = movieRawResponseMapper.map()
        assertThat(result).isInstanceOf(ResponseSuccess::class.java)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test_map_Body() = runTest {

        val list = ArrayList<MovieRawResults>(2)
        list.add(MovieRawResults(id = 1))
        list.add(MovieRawResults(id = 2))

        val fakeResponse = Response.success(PopularMovieResponse(results = list))


        val movieRawResponseMapper = MovieRawResponseMapper(fakeResponse)

        val result = movieRawResponseMapper.mapBody(fakeResponse.body())
        assertThat(result?.map { it.id }).isEqualTo(list.map { it.id })
    }



}