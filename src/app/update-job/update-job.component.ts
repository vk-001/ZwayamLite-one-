import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { JobService } from '../job.service';
import { Jobs } from '../jobs';

@Component({
  selector: 'app-update-job',
  templateUrl: './update-job.component.html',
  styleUrls: ['./update-job.component.css']
})
export class UpdateJobComponent implements OnInit {

  id:number;
  job:Jobs=new Jobs();


  constructor(private JobService:JobService,
    private route : ActivatedRoute,
    private router : Router) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.JobService.getJobById(this.id).subscribe(data => {
      this.job=data;
    },error=>console.log(error));
  }

  onSubmit(){
    this.JobService.updateJob(this.id, this.job).subscribe( data =>{
      this.goToJobsList();
    }
    , error => console.log(error));
  }

  goToJobsList(){
    this.router.navigate(['/jobs']);
  }

}
