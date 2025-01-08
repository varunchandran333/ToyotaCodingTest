package com.training.livecodingtest.data.di

import com.training.livecodingtest.domain.usecase.Repository
import com.training.livecodingtest.data.repository.UserRepository
import com.training.livecodingtest.domain.usecase.GetUserDataUseCase
import com.training.livecodingtest.domain.wrapper.UserDomainWrapper
import org.koin.dsl.module

val repositoryModule = module {
    factory<Repository> { UserRepository(get()) }
    factory { GetUserDataUseCase(get()) }
    factory { UserDomainWrapper(get()) }
}