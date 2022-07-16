import { Component, OnInit } from '@angular/core';
import { Jobs } from '../jobs';
import { JobService } from '../job.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-job',
  templateUrl: './create-job.component.html',
  styleUrls: ['./create-job.component.css']
})
export class CreateJobComponent implements OnInit {

  job:Jobs=new Jobs();

  constructor(private jobService:JobService,
    private router : Router) { }

  ngOnInit(): void {
  }
  

  saveJob(){
    this.jobService.createJob(this.job).subscribe(data => {
      this.goToJobList();
    },
    error => console.log(error));
  }

  goToJobList(){
    this.router.navigate(['/jobs']);
  }

  onSubmit(){
    console.log(this.job);
    this.saveJob();
  }

}
