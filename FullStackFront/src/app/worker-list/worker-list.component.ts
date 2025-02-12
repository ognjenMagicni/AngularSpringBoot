import { Component, inject, OnInit } from '@angular/core';
import { WorkerService } from '../service/worker.service';
import { Worker } from '../model/worker.model';
import { RouterLink } from '@angular/router';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
@Component({
  selector: 'app-worker-list',
  imports: [RouterLink,ReactiveFormsModule],
  templateUrl: './worker-list.component.html',
  styleUrl: './worker-list.component.css'
})
export class WorkerListComponent implements OnInit {
  workerService = inject(WorkerService)
  insertVariable: boolean = false;
  buttonText: string = "Create new worker" 
  workerList : Worker[] = []

  workerName?: string
  workerSurname?: string
  workerAge?: number

  profileGroup = new FormGroup({
    required: new FormControl("",[Validators.required]),
  });
  
  ngOnInit(){
    this.workerService.getWorkers().subscribe(payload => {
      this.workerList = payload
    })
  }

  insertVariableFunction(): void{
    if(this.insertVariable){
      this.insertVariable = false;
      this.buttonText = "Create new worker"
    }
    else{
      this.insertVariable = true;
      this.buttonText = "Cancel"
    }
    console.log(this.insertVariable)
  }

  insertClicked(): void{
    let worker: Worker = {
      name:this.workerName,
      surname: this.workerSurname,
      age:this.workerAge,
    }
    let insertedWorker = this.workerService.insertWorker(worker).subscribe( payload => {
      console.log(insertedWorker)
    })
    
  }
}
