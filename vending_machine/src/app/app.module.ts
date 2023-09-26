import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { VendingMachineComponent } from './vending-machine/vending-machine.component';
import { FormsModule } from '@angular/forms';
import { CloseDoorComponent } from './close-door/close-door.component';

@NgModule({
  declarations: [
    AppComponent,
    VendingMachineComponent,
    CloseDoorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
