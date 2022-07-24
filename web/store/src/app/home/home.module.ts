import { ProductService } from './../services/product.service';
import { ProductCardComponent } from './../components/card/product-card.component';
import { NavbarModule } from './../components/navbar/navbar.module';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductCardModule } from '../components/card/product-card.module';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
];

@NgModule({
  declarations: [HomeComponent],
  imports: [
    RouterModule.forChild(routes),
    NavbarModule,
    CommonModule,
    ProductCardModule,
  ],
  providers: [ProductService],
})
export class HomeModule {}
