import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CoreRoutingModule } from './core-routing.module';
import { SharedModule } from '../shared/shared.module';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';


@NgModule({
  declarations: [LoginComponent, NavbarComponent],
  exports: [
    NavbarComponent
  ],
  imports: [
    CoreRoutingModule,
    SharedModule
  ]
})
export class CoreModule { }
