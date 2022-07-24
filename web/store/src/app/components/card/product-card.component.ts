import { ProductModel } from './../../models/product.model';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'product-card',
  templateUrl: 'product-card.component.html',
  styleUrls: ['product-card.component.css'],
})
export class ProductCardComponent implements OnInit {
  @Input() products: ProductModel[] = [];

  constructor() {}

  ngOnInit() {}
}
