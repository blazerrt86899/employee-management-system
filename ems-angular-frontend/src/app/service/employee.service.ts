import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private apiServerUrl = 'http://localhost:9002/api/v1/employee'
  constructor(private httpClient : HttpClient) { }

  public getEmployees(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.apiServerUrl}/get-list`);
  }

  public addEmployee(employee:Employee): Observable<Response>{
    return this.httpClient.post<Response>(`${this.apiServerUrl}/add`,employee);
  }

  public updateEmployee(employee:Employee, id:number): Observable<Response>{
    return this.httpClient.put<Response>(`${this.apiServerUrl}/update/${id}`,employee);
  }

  public getEmployeeById(id:number): Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.apiServerUrl}/${id}`);
  }

  public deleteEmployeeById(id:number): Observable<void>{
    return this.httpClient.delete<void>(`${this.apiServerUrl}/delete/${id}`);
  }


}
