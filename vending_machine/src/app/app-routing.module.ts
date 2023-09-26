import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CloseDoorComponent } from './close-door/close-door.component';
import { VendingMachineComponent } from './vending-machine/vending-machine.component';

const routes: Routes = [

    { path: '', redirectTo: '/vendingMachine', pathMatch: 'full' },
    { path: 'vendingMachine', component: VendingMachineComponent },
    { path: 'closeDoor', component: CloseDoorComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
