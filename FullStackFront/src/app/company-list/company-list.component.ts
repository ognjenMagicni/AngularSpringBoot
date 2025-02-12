import { Component, inject,OnInit } from '@angular/core';
import { CompanyService } from '../service/company.service';
import { Company } from '../model/company.model';
import { RouterLink } from '@angular/router';
import { FormControl,FormGroup,Validators,FormsModule,ReactiveFormsModule } from '@angular/forms';
import { NgModel } from '@angular/forms';
@Component({
  selector: 'app-company-list',
  imports: [RouterLink,ReactiveFormsModule,FormsModule],
  templateUrl: './company-list.component.html',
  styleUrls: ['./company-list.component.css',"../app.component.css"]
})
export class CompanyListComponent implements OnInit{
  companyService = inject(CompanyService)
  insertVariable: boolean = false
  companyList : Company[] = []
  buttonText: string = "Create new company"

  company: Company = {};
  
  profileGroup = new FormGroup({
    required: new FormControl("",[Validators.required]),
  });

  ngOnInit(){
    this.companyService.getCompany().subscribe( payload => {
      this.companyList = payload
    })
  } 

  insertVariableFunction(){
    if(this.insertVariable){
      this.insertVariable = false;
      this.buttonText = "Create new company"
    }
    else{
      this.insertVariable = true;
      this.buttonText = "Cancel"
    }
  }
  insertCompany():void{
    this.companyService.insertCompany(this.company).subscribe(payload => {
      console.log(payload);
    })
  }
}
