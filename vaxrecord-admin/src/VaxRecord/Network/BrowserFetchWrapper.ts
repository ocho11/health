import FetchWrapper from "./FetchWrapper";

class BrowserFetchWrapper implements FetchWrapper {
    getByJson(url: string, options?: RequestInit): Promise<any> {
        return fetch(url)
            .then(response => {
                switch(response.status) {
                    case 403: {
                        throw Error('Forbidden')
                    }
                    case 401: {
                        throw Error('Unauthorized')
                    }
                    case 400: {
                        throw Error('Bad Request')
                    }
                    default: {
                        return response.json()
                    }
                }
            })
    }
}

export default BrowserFetchWrapper