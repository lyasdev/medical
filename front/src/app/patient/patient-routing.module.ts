import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AuthGuard} from "../core/auth.guard";
import {PatientUpdateComponent} from "./patient-update/patient-update.component";


const routes: Routes = [
  {path: 'patient', component: PatientUpdateComponent, canActivate: [AuthGuard]},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PatientRoutingModule { }
