
import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Product } from '../../services/product';

@Component({
  selector: 'app-product-list',
  imports: [FormsModule],
  templateUrl: './product-list.html',
  styleUrl: './product-list.css'
})
export class ProductList {

  productService = inject(Product);

  products = this.productService.getProducts();

  productName = '';
  productPrice: number | null = null;

  addProduct() {
    if (!this.productName || this.productPrice === null || this.productPrice <= 0) {
      return;
    }

    this.productService.addProduct(this.productName, this.productPrice);

    this.productName = '';
    this.productPrice = null;
  }

  editingProductId: number | null = null;

editProduct(product: any) {
  this.editingProductId = product.id;
  this.productName = product.name;
  this.productPrice = product.price;
}

saveProduct() {
  if (
    this.editingProductId === null ||
    !this.productName ||
    this.productPrice === null ||
    this.productPrice <= 0
  ) {
    return;
  }

  this.productService.updateProduct(
    this.editingProductId,
    this.productName,
    this.productPrice
  );

  this.editingProductId = null;
  this.productName = '';
  this.productPrice = null;
}
deleteProduct(id: number) {
  this.productService.deleteProduct(id);
}
}
