import { Pipe, PipeTransform } from '@angular/core';
import { Product } from './add-product/Product';

@Pipe({
  name: 'searchProduct'
})
export class SearchProductPipe implements PipeTransform {

  transform(product: Array<Product>, ...args: string[]): Array<Product> {
    let filterProduct=product.filter(product=>product.category.includes(args[0]));
    return filterProduct;
  }

}
