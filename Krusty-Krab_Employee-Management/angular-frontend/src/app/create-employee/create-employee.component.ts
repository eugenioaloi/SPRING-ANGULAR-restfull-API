import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeServiceService } from '../employee-service.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})

export class CreateEmployeeComponent {

  employee: Employee = new Employee();
  constructor(private employeeService: EmployeeServiceService, 
    private router: Router){ }
 
  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe(data=>{
      console.log(data);
      this.employeeList();
    },
    error => console.error());
  }

  employeeList(){
    this.router.navigate(['/employees'])
  }

  onSubmit(){
    console.log(this.employee);
    this.saveEmployee();
  }

}
