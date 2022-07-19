package com.example.selectRemoteTest

import io.kvision.annotations.KVService
import io.kvision.remote.RemoteOption

@KVService
interface IPingService {
    suspend fun ping(message: String): String
    suspend fun country(search: String?, initial: String?, state: String?): List<RemoteOption>
}
