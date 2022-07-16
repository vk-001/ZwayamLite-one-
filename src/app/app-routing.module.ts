import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateJobComponent } from './create-job/create-job.component';
import { JobDetailsComponent } from './job-details/job-details.component';
import { JobsListComponent } from './jobs-list/jobs-list.component';
import { UpdateJobComponent } from './update-job/update-job.component';

const routes: Routes = [
  {path:'jobs',component:JobsListComponent},
  {path:'create-job',component:CreateJobComponent},
  {path:'update-job/:id',component:UpdateJobComponent},
  {path:'job-details/:id',component:JobDetailsComponent},
  {path:'',redirectTo:'jobs',pathMatch:'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
