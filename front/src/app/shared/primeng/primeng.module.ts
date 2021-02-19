import { NgModule } from '@angular/core';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { CardModule } from 'primeng/card';



const primeNgComponents = [
  InputTextModule,
  ButtonModule,
  CardModule,
] 

@NgModule({
  imports: [...primeNgComponents],
  exports: [...primeNgComponents]
})
export class PrimeNgModule { }
