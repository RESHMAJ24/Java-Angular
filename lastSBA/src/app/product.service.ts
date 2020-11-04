import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from './add-product/Product';

const baseUrl: string = 'http://localhost:8000/api/products/'

@Injectable({
  providedIn: 'root'
})

export class ProductService {

  constructor(public httpClient: HttpClient) { }

  addProduct(product:Product ){
    return this.httpClient.post(baseUrl,product)
  }
  fetchAllEmployees()
  {
    return this.httpClient.get(baseUrl);
  }

  deleteEmployee(id:number)
  {
    return this.httpClient.delete(baseUrl + id)
  }

  public products : Array<Product> = []
} 
