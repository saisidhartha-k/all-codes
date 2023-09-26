import { Component } from '@angular/core';
import { VendingMachineService } from '../vending-machine.service';
import { Product } from '../Product';
import { Router } from '@angular/router'; 

@Component({
  selector: 'app-vending-machine',
  templateUrl: './vending-machine.component.html',
  styleUrls: ['./vending-machine.component.css'],
})
export class VendingMachineComponent {
  public products: Product[] = [];
  purchaseResult: string = '';
  selectedSectionId: number | null = null; 
  selectedProduct: Product | null = null; 

  constructor( public vendingMachine : VendingMachineService, private router: Router) {}

  ngOnInit(): void {
    this.products = this.vendingMachine.getProducts();
  }


  purchaseProduct(): void {
    if (this.selectedSectionId !== null) {
      this.vendingMachine.purchaseProduct(this.selectedSectionId);
    }
    this.router.navigate(['/closeDoor']);

  }

 

}
