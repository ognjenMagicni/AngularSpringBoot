import { Component, inject, OnInit } from '@angular/core';
import { WorkerService } from '../service/worker.service';
import { ActivatedRoute } from '@angular/router';
import { Worker } from '../model/worker.model';
import { FormGroup,ReactiveFormsModule,FormControl,Validators,FormsModule } from '@angular/forms';
@Component({
  selector: 'app-worker',
  imports: [ReactiveFormsModule,FormsModule],
  templateUrl: './worker.component.html',
  styleUrl: './worker.component.css'
})
export class WorkerComponent implements OnInit{
  workerService = inject(WorkerService)
  route = inject(ActivatedRoute)
  worker : Worker = {};
  id ?:string|null=" " 

  editVariable: boolean = false;
  editVariableFunction(){
    if(this.editVariable)
      this.editVariable = false;
    else
      this.editVariable = true;
  }

  profileGroup = new FormGroup({
      required: new FormControl("",Validators.required)
    });

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get("id")
    this.workerService.getWrokersId(this.id).subscribe(payload=>{
      this.worker = payload
    })
  }

  deleteWorker():void{
    this.workerService.deleteWorker(this.id?.toString()).subscribe(payload => {
      console.log(payload)
    });
  }

  updateWorker():void{
    this.workerService.updateWorker(this.worker).subscribe(payload => {
      console.log(payload);
    })
  }
}
