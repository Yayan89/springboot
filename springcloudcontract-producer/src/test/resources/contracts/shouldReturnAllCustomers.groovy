package contracts

import org.springframework.cloud.contract.spec.Contract
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType

//import org.springframework.cloud.contract.spec.internal.HttpHeaders
//import org.springframework.cloud.contract.spec.internal.MediaTypes

Contract.make {
    description("should return all descriptions")
    request {
        url("/customers")
        method GET()
    }
    response {
        status 200
        headers {
            header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        }
        body([[id: 1L, name: "Jane"], [id: 2L, name: "Bob"]])
    }
}
