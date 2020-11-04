import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  constructor(public productService:ProductService) { }
  addProduct(id:number,name:string,category:string,type:string,expiryDate:string)
  {
    console.log(id,name,category,type,expiryDate)
    this.productService.addProduct({id:null, name, category,type,expiryDate})
    .subscribe(res=>console.log(res))

  }
  ngOnInit(): void {
  }

}
