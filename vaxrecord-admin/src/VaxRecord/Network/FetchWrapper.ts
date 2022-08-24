export default interface FetchWrapper {
    fetchJson(url: string, options: {}): Promise<any>
}