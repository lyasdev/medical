import { NgModule } from '@angular/core';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { CardModule } from 'primeng/card';
import {MenubarModule} from 'primeng/menubar';
import {AvatarModule} from 'primeng/avatar';
import {AvatarGroupModule} from 'primeng/avatargroup';
import {InputTextareaModule} from "primeng/inputtextarea";
import {CalendarModule} from "primeng/calendar";
import {TabViewModule} from "primeng/tabview";
import {DropdownModule} from "primeng/dropdown";
import {BadgeModule} from 'primeng/badge';
const primeNgComponents = [
  InputTextModule,
  ButtonModule,
  CardModule,
  MenubarModule,
  AvatarModule,
  AvatarGroupModule,
  InputTextModule,
  InputTextareaModule,
  CalendarModule,
  TabViewModule,
  DropdownModule,
  AvatarModule,
  BadgeModule
]

@NgModule({
  imports: [...primeNgComponents],
  exports: [...primeNgComponents]
})
export class PrimeNgModule { }
