package com.demo.coreservice.data.remote.network

class ServiceError {

    companion object {
        const val NETWORK_ERROR = "Unknown ServiceError"
        const val GROUP_200 = 2
        private const val GROUP_400 = 4
        private const val GROUP_500 = 5
        private const val VALUE_100 = 100
        const val SUCCESS_CODE = 200
        const val SERVER_ERROR_CODE = 500
        const val ERROR_CODE = 400
    }


    private var description: String = ""
        get() = field
    private var code: Int = 0
        get() = field

    constructor()
    constructor(description: String, code: Int) {
        this.description = description
        this.code = code
    }

}