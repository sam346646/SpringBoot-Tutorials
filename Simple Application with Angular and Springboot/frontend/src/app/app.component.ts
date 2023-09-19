import { Component, OnInit } from '@angular/core';
import { Employee } from './employee';
import { EmployeeService } from './employee.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

   // ! since it has to be initialized else throws error so by using ! we are suggesting that employees will be initialized later 
   // or else use =[]
  public employees! : Employee[];

  // Injecting service to component
  constructor(private employeeService : EmployeeService){}

  //Initializing
  ngOnInit(): void {
    this.getEmployees();
  }

  public getEmployees() : void {
    // //Earlier version
    // this.employeeService.getEmployees().subscribe(
    //   (response : Employee[]) => { this.employees = response },
    //   (error : HttpErrorResponse) => { alert(error.message) }
    // );

    this.employeeService.getEmployees().subscribe(
      {
        next: (response) => { this.employees = response },
        error: (error) => { alert(error) }
      }
    );
  } 

}
