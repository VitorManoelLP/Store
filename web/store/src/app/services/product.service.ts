import { ProductModel } from './../models/product.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  resource: string = environment.main_api;

  constructor(private httpClient: HttpClient) {}

  public findAllPageable(): Observable<any[]> {
    return this.httpClient.get<any[]>(`${this.resource}/page-all`);
  }
}
