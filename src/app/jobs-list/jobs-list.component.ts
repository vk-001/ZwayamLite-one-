import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JobService } from '../job.service';
import { Jobs } from '../jobs'
@Component({
  selector: 'app-jobs-list',
  templateUrl: './jobs-list.component.html',
  styleUrls: ['./jobs-list.component.css']
})
export class JobsListComponent implements OnInit {

  jobs: Jobs[];

  constructor(private jobService: JobService, 
    private router:Router) { }

  ngOnInit(): void {
    this.getJobs();
  }

  private getJobs(){
    this.jobService.getJobsList().subscribe(data => {
      this.jobs = data;
    })
  }

  jobDetails(id:number){
    this.router.navigate(['job-details',id]);
  }

  updateJob(id:number){
    this.router.navigate(['update-job',id]);
  }
    
  deleteJob(id:number){
    this.jobService.deleteJob(id).subscribe(data =>{
      this.getJobs();
    })
  }

}
