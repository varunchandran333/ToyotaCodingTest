package com.training.livecodingtest

import app.cash.turbine.test
import com.training.livecodingtest.domain.UserUIModel
import com.training.livecodingtest.domain.UserDomainWrapper
import com.training.livecodingtest.ui.viewmodel.UserViewModel
import com.training.livecodingtest.utils.NetworkResult
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class UserViewModelTest {

    private val useCase = mockk<UserDomainWrapper>()
    private lateinit var viewModel: UserViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @Test
    fun `load user data from domain and provide the proper list of events in viewmodel`() =
        runTest {
            val sampleData = UserUIModel(1, "Sachin", "", "", "")
            val listOfUsers = listOf(sampleData)
            val mockResponse = NetworkResult.Success(listOfUsers)
            coEvery { useCase() } returns flow {
                emit(NetworkResult.Loading)
                emit(mockResponse)
            }
            viewModel = UserViewModel(useCase)
            viewModel.userData.test {
                assertEquals(NetworkResult.Loading, awaitItem())
                assertEquals(mockResponse, awaitItem())
            }
        }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}