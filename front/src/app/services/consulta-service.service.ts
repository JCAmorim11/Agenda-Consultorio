import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ConsultaServiceService {
  constructor(private httpClient: HttpClient) {}

  findAll() {
    return this.httpClient.get<any>(`${environment.apiUrl}/consultas/all`);
  }
}
