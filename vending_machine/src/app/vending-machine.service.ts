import { Injectable } from '@angular/core';
import { Product } from './Product';

@Injectable({
  providedIn: 'root'
})
export class VendingMachineService {
  public products: Product[] = [];
  purchaseResult: string = '';
  selectedProductId: number | null = null; 
  selectedProduct: Product | null = null; 
  selectedQuantity: number = 1; 
  selectedSectionid: number | null = null; 

  
  constructor() {
    this.products.push({ Sectionid: 17, id : 1, name: "Soda", price: 100, quantity: 10 });
    this.products.push({ Sectionid: 17, id : 2, name: "Chips", price: 150, quantity: 20 });
    this.products.push({ Sectionid: 17, id : 3, name: "Candy", price: 50, quantity: 15 });
    this.products.push({ Sectionid: 13, id : 5, name: "coke", price: 50, quantity: 15 });

  }

  getProducts()
  {
    return this.products;
  }
  
  getSelectedProducts()
  {
    return this.products.filter((product) => product.Sectionid === this.selectedSectionid);
    
  }

  purchaseProduct(Sectionid: number): void {

    this.selectedSectionid = Sectionid;
    
  }

  Buy(id: number, quantity: number): void {
    const product = this.findProduct(id);
    console.log(id);
    console.log(this.selectedSectionid);
    console.log(product?.Sectionid);
  
    if (!product) {
      this.purchaseResult = "Product not found.";
      return;
    }
   
    if(product && product.Sectionid != this.selectedSectionid)
    {
      this.purchaseResult = "wrong section";
      return;
    }
    if (quantity <= 0) {
      this.purchaseResult = "Invalid quantity.";
      return;
    }
  
    if (product.quantity < quantity) {
      this.purchaseResult = "Out of stock.";
      return;
    }
  
    this.selectedProduct = product;
    this.selectedQuantity = quantity;
  
    const totalPrice = this.selectedProduct.price * this.selectedQuantity;
  
    this.selectedProduct.quantity -= this.selectedQuantity;
    this.purchaseResult = `You have purchased ${this.selectedQuantity} ${this.selectedProduct.name}(s) for ₹${totalPrice}.`;
  
    this.selectedProduct = null;
    this.selectedQuantity = 1;
  }
  
  closeDoor()
  {
    this.selectedSectionid = null;

  }
  getUserBalance(): number {
    return 1000; 
  }


  findProduct(productId: number): Product | undefined {
    
    const foundProduct = this.products.find((product) => product.id === productId);
      
        return foundProduct;
  

    }
}
