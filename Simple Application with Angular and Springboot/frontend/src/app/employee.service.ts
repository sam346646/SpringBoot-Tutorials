import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

// Angular injector injects this service
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private apiServerUrl = "http://localhost:8080"  // Better to set in enviroment.ts of enviroments folder

  //injecting HttpClient to service
  constructor(private http: HttpClient) { }

  public getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.apiServerUrl}/employee/all`)   //parameters: (url, {headers:..,params:..,etc})
  }

  public getEmployee(id : number): Observable<Employee> {
    return this.http.get<Employee>(`${this.apiServerUrl}/employee/find/${id}`)
  }

  public addEmployee(employee : Employee) : Observable<String> {
    return this.http.post<String>(`${this.apiServerUrl}/employee/add`,employee)   //parameters: (url, body, {headers:..,params:..,etc})
  }
}
