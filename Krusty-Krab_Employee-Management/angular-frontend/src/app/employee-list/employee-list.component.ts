import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeServiceService } from '../employee-service.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})

export class EmployeeListComponent implements OnInit {

  employees : Employee[];

  constructor(private employeService: EmployeeServiceService, private router:Router ){}

  ngOnInit():void{
    this.getEmployees();
  }

  private getEmployees(){
    this.employeService.getEmployeeList().subscribe(data => {
      this.employees = data;
    });
  }

  updateEmployee(id: number){
    this.router.navigate(['update-employee', id]);
  }

  deleteEmployee(id: number){
    this.employeService.deleteEmployee(id).subscribe(data => {
      console.log(data);
      this.getEmployees  
    })
  }

  viewEmployee(id:number){
    this.router.navigate(['view-employee', id]);
  }

   

}
