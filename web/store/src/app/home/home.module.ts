import { NavbarModule } from './../components/navbar/navbar.module';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  }
]

@NgModule({
  declarations: [HomeComponent],
  imports: [
    RouterModule.forChild(routes),
    NavbarModule,
    CommonModule
  ]
})
export class HomeModule { }
