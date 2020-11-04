import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-view-product',
  templateUrl: './view-product.component.html',
  styleUrls: ['./view-product.component.css']
})
export class ViewProductComponent implements OnInit {

  constructor(public productService:ProductService) { }

  deleteProduct(id:number)
  {
    this.productService.deleteEmployee(id)
    .subscribe(res => console.log(res))
  }

  ngOnInit(): void {
    this.productService.fetchAllEmployees()
    .subscribe((res:any)=>
      {
        console.log(res)
        this.productService.products = res;

      })
  }

}
