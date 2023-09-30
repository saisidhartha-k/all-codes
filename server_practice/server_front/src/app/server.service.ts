import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Server } from './serverInt';

@Injectable({
  providedIn: 'root',
})
export class ServerService {
  constructor(private http: HttpClient) {}
  url : string = 'http://localhost:8080/servers/';

  getServers(): Observable<any> {
    return this.http.get<any>(`${this.url}list`);
  }
  
}
