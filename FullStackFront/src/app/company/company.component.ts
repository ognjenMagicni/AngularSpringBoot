import { Component, inject, OnInit } from '@angular/core';
import { CompanyService } from '../service/company.service';
import { ActivatedRoute } from '@angular/router';
import { Company } from '../model/company.model';
import { RouterLink } from '@angular/router';
import { FormControl, FormGroup, Validators,ReactiveFormsModule } from '@angular/forms';
import { WorkerService } from '../service/worker.service';
import { Worker } from '../model/worker.model';
@Component({
  selector: 'app-company',
  imports: [RouterLink,ReactiveFormsModule],
  templateUrl: './company.component.html',
  styleUrl: './company.component.css'
})
export class CompanyComponent implements OnInit{
  companyService = inject(CompanyService)
  workerService = inject(WorkerService)
  route = inject(ActivatedRoute)
  company : Company = {};
  id: string|null = " ";
  workerList : Worker[] = []

  profileGroup = new FormGroup({
    required: new FormControl("",Validators.required)
  });

  

  editVariable: boolean = false;
  addVariable: boolean = false;

  ngOnInit(){
    this.id = this.route.snapshot.paramMap.get("id");
    this.companyService.getCompanyId(this.id).subscribe(payload => {
      this.company = payload;
    })
    this.workerService.getWorkers().subscribe(payload => {
      this.workerList = payload;
    })

  }
  editVariableFunction(){
    if(this.editVariable)
      this.editVariable = false;
    else
      this.editVariable = true;
  }
  addVariableFunction(){
    if(this.addVariable)
      this.addVariable = false;
    else
      this.addVariable = true;
  }
  deleteCompany(): void{
    this.companyService.deleteCompany(this.id).subscribe(payload=>{
      console.log()
    }); 
  }
  insertCompany():void{
    this.company.idCompany = Number(this.id);
    this.companyService.insertCompany(this.company).subscribe(payload => {
      console.log(payload);
    })
  }
  removeWorker(workerId?: number): void{
    this.companyService.removeWorker(Number(this.id),workerId).subscribe(payload=>{});
  }
  addWorker(workerId?: number): void{
    this.companyService.addWorker(Number(this.id),workerId).subscribe(payload=>{
      console.log(payload)
    })
  }
}
