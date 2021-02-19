import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PatientRoutingModule } from './patient-routing.module';
import { PatientUpdateComponent } from './patient-update/patient-update.component';
import {SharedModule} from "../shared/shared.module";


// noinspection AngularInvalidImportedOrDeclaredSymbol
@NgModule({
  declarations: [PatientUpdateComponent],
  imports: [
    CommonModule,
    PatientRoutingModule,
    SharedModule
  ]
})
export class PatientModule { }
