import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Company } from '../model/company.model';
@Injectable({
  providedIn: 'root'
})
export class CompanyService {
  constructor( private httpClient:HttpClient){}
  httpOptions = {headers:new HttpHeaders({"Content-Type":"application/json"})}

  getCompany(): Observable<Company[]>{
    let url = "http://localhost:8080/company";
    return this.httpClient.get<Company[]>(url)
  }
  getCompanyId(id : string|null): Observable<Company>{
    let url = "http://localhost:8080/company/"+id
    console.log(url)
    return this.httpClient.get<Company>(url)
  }
  insertCompany(company:Company): Observable<Company>{
    let url = "http://localhost:8080/company";
    console.log("insertCompany executed, in body below, http next "+url )
    console.log(company)
    return this.httpClient.post<Company>(url,company)
  }
  deleteCompany(id: string|null): Observable<Company>{
    let url = "http://localhost:8080/company/"+id;
    return this.httpClient.delete(url)
  }
  removeWorker(idCompany: number, idWorker?: number ): Observable<Company>{
    let workerCompany = {"idCompany":idCompany,"idWorker":idWorker}
    let url = "http://localhost:8080/company/addworker"
    console.log("company.service started with body below, and url next to this "+url);
    console.log(idCompany,idWorker)
    return this.httpClient.delete<Company>(url, {body:workerCompany})
  }
  addWorker(idCompany: number, idWorker?: number ){
    let workerCompany = {"idCompany":idCompany,"idWorker":idWorker}
    let url = "http://localhost:8080/company/addworker"
    console.log("company.service started with body below, and url next to this "+url);
    console.log(idCompany,idWorker)
    return this.httpClient.post<Company>(url, workerCompany)
  }
} 
