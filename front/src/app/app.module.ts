import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CoreModule } from './core/core.module';
import { CoreRoutingModule } from './core/core-routing.module';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { FakeBackEndService } from './fake-back-end.service';
import { CONFIG } from './app.config';
import { ShellComponent } from './shell/shell.component';

@NgModule({
  declarations: [
    AppComponent,
    ShellComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    CoreModule, 
    CoreRoutingModule,
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: FakeBackEndService, multi: true},
              ...CONFIG],
  bootstrap: [AppComponent]
})
export class AppModule { }
