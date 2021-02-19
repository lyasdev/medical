import { NgModule } from '@angular/core';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { CardModule } from 'primeng/card';
import {MenubarModule} from 'primeng/menubar';
import {AvatarModule} from 'primeng/avatar';
import {AvatarGroupModule} from 'primeng/avatargroup';
const primeNgComponents = [
  InputTextModule,
  ButtonModule,
  CardModule,
  MenubarModule,
  AvatarModule,
  AvatarGroupModule
]

@NgModule({
  imports: [...primeNgComponents],
  exports: [...primeNgComponents]
})
export class PrimeNgModule { }
