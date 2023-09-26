import { Component } from '@angular/core';
import { VendingMachineService } from '../vending-machine.service';
import { Router } from '@angular/router';
import { Product } from '../Product';

@Component({
  selector: 'app-close-door',
  templateUrl: './close-door.component.html',
  styleUrls: ['./close-door.component.css']
})
export class CloseDoorComponent {
  selectedQuantity: number = 1; 
  result ?: String;
  selectedProductId: number = 1; 
  public products: Product[] = [];

  constructor( public vendingMachine : VendingMachineService, private router : Router) {}

  ngOnInit(): void {
    this.products = this.vendingMachine.getSelectedProducts();
    console.log(this.products);
  }

  Buy(selectedProductId : number ,selectedQuantity : number ): void {
    if (this.selectedProductId !== null && this.selectedQuantity > 0) {
      this.vendingMachine.Buy(this.selectedProductId, this.selectedQuantity);
    } 
  }

  closeDoor() : void
  {
    this.vendingMachine.closeDoor();
    this.router.navigate(['/vendingMachine']);

  }

  getPurchaseResult(): String {
    return this.vendingMachine.purchaseResult;

  }


}
