import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Jobs} from './jobs';


@Injectable({
  providedIn: 'root'
})
export class JobService {

  private baseURL = "http://localhost:8080/jobs";
  constructor(private httpClient: HttpClient) { }

  getJobsList():Observable<Jobs[]>{
    return this.httpClient.get<Jobs[]>(`${this.baseURL}`);
  }

  createJob(job:Jobs):Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`,job);
  }

  getJobById(id:number):Observable<Jobs>{
    return this.httpClient.get<Jobs>(`${this.baseURL}/${id}`);
  }

  updateJob(id:number, job:Jobs):Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`,job);
  }

  deleteJob(id:number):Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }

}