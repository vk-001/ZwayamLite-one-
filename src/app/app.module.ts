import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { JobsListComponent } from './jobs-list/jobs-list.component';
import { CreateJobComponent } from './create-job/create-job.component';

import { FormsModule } from '@angular/forms';
import { UpdateJobComponent } from './update-job/update-job.component';
import { JobDetailsComponent } from './job-details/job-details.component';

@NgModule({
  declarations: [
    AppComponent,
    JobsListComponent,
    CreateJobComponent,
    UpdateJobComponent,
    JobDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
