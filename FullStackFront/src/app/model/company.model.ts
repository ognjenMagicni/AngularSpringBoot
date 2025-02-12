import { Worker } from "./worker.model"
export interface Company{
    idCompany?: number,
    name?: string,
    location?: string,
    workers?: Worker[]
}