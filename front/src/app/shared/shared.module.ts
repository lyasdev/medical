import { NgModule } from '@angular/core';
import { PrimeNgModule } from './primeng/primeng.module';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';



@NgModule({
  declarations: [],
  imports: [
    PrimeNgModule,
    ReactiveFormsModule,
    CommonModule,
    HttpClientModule
  ],
  exports: [
    PrimeNgModule,
    ReactiveFormsModule,
    CommonModule,
    HttpClientModule
  ],
})
export class SharedModule { }
