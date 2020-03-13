package com.demo.coreservice.data.remote.network

class ServiceResponse {
     var code = 0
    get() = field
     var data: Any? = null
        get() = field
     var ServiceError: ServiceError? = null
        get() = field

    constructor(code: Int, data: Any?) {
        this.code = code
        this.data = data
    }

    constructor(ServiceError: ServiceError?) {
        this.ServiceError = ServiceError
    }


}