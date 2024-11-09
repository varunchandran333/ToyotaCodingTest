package com.training.livecodingtest.di

import com.training.livecodingtest.domain.Repository
import com.training.livecodingtest.data.repository.UserRepository
import com.training.livecodingtest.domain.GetUserDataUseCase
import com.training.livecodingtest.domain.UserDomainWrapper
import org.koin.dsl.module

val repositoryModule = module {
    factory<Repository> { UserRepository(get()) }
    factory { GetUserDataUseCase(get()) }
    factory { UserDomainWrapper(get()) }
}