
import { Service } from '@angular/core';

@Service()
export class Product {

  products = [
    { id: 1, name: 'Laptop', price: 1000 },
    { id: 2, name: 'Phone', price: 500 },
    { id: 3, name: 'Keyboard', price: 100 }
  ];

  getProducts() {
    return this.products;
  }

  addProduct(name: string, price: number) {
    const newProduct = {
      id: this.products.length + 1,
      name: name,
      price: price
    };

    this.products.push(newProduct);
  }

  updateProduct(id: number, name: string, price: number) {
    const product = this.products.find(p => p.id === id);

    if (product) {
      product.name = name;
      product.price = price;
    }
  }

deleteProduct(id: number) {
  this.products = this.products.filter(product => product.id !== id);
}

}
