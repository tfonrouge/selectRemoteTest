package com.example.selectRemoteTest

import io.kvision.remote.RemoteOption

actual class PingService : IPingService {

    override suspend fun ping(message: String): String {
        println(message)
        return "Hello world from server!"
    }

    private val countryList = listOf(
        "MEX" to "Mexico",
        "USA" to "United States",
        "CAN" to "Canada"
    )

    override suspend fun country(search: String?, initial: String?, state: String?): List<RemoteOption> {
        if (initial != null) {
            val item = countryList.find { it.first == initial }
            return listOf(RemoteOption(value = item?.first, text = item?.second))
        }
        return countryList.mapNotNull { pair ->
            search?.let { string ->
                if (pair.second.contains(other = string, ignoreCase = true))
                    RemoteOption(value = pair.first, text = pair.second)
                else
                    null
            }
        }
    }
}
