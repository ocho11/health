export default interface FetchWrapper {
    getByJson(url: string, options?: RequestInit): Promise<any>
}