import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AddProductComponent } from './add-product/add-product.component';
import { ViewProductComponent } from './view-product/view-product.component';
import { SearchProductPipe } from './search-product.pipe';


import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/viewproduct' },
  {path:'viewproduct', component: ViewProductComponent},
  {path:'addproduct', component: AddProductComponent}
  
]



@NgModule({
  declarations: [
    AppComponent,
    AddProductComponent,
    ViewProductComponent,
    SearchProductPipe
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
