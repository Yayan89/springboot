var request = require('request');

request.get(
    'http://localhost:9090/api/something',
    function (error, response, body) {
        if(!error && response.statusCode >= 200 && response.statusCode < 400) {
            console.log(body)
        } else {
            console.log("Error - status [" + (response === undefined ? "undefined" : response.statusCode) + "]")
        }
    }
);