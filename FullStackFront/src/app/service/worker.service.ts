import { HttpClient } from '@angular/common/http';
import { Injectable,inject } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Worker } from '../model/worker.model';
import { ActivatedRoute } from '@angular/router';
@Injectable({
  providedIn: 'root'
})
export class WorkerService {

  constructor(private httpClient: HttpClient) { }
  httpOptions = {headers: new HttpHeaders({"Content-Type":"application/json"})}

  getWorkers(): Observable<Worker[]>{
    let url = "http://localhost:8080/worker"
    return this.httpClient.get<Worker[]>(url)
  }

  getWrokersId(id: string|null): Observable<Worker>{
    let url = "http://localhost:8080/worker/"+id
    return this.httpClient.get<Worker>(url)
  }

  insertWorker(worker: Worker): Observable<Worker>{
    let url = "http://localhost:8080/worker";
    console.log("Insert worker sent")
    return this.httpClient.post<Worker>(url,worker)
  }

  deleteWorker(workerId?: string) :Observable<Worker>{
    let url ="http://localhost:8080/worker/"+workerId;
    return this.httpClient.delete<Worker>(url);
  }
  updateWorker(worker:Worker): Observable<Worker>{
    let url = "http://localhost:8080/worker/update";
    return this.httpClient.put<Worker>(url,worker)
  }
}
