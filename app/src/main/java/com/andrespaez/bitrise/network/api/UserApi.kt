package com.andrespaez.bitrise.network.api

import com.andrespaez.bitrise.network.models.Profile
import com.andrespaez.bitrise.network.services.UserServices
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.annotations.CheckReturnValue
import javax.inject.Inject

class UserApi @Inject constructor(private val services: UserServices) : BaseApi() {

    @CheckReturnValue
    fun getProfile(scheduler: Scheduler? = null): Single<Profile> =
        subscribe(
            services.getProfile().flatMap { Single.just(it.profile) },
            scheduler
        )

}