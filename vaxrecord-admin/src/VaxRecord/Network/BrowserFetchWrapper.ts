import FetchWrapper from "./FetchWrapper";

class BrowserFetchWrapper implements FetchWrapper {
    fetchJson(url: string, options: {}): Promise<any> {
        return fetch(url, options)
            .then(response => {
                switch (response.status) {
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