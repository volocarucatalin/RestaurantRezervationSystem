import { Component, NgModule, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { CustomerComponent } from './customer/customer.component';
import { CreateCustomerComponent} from './create-customer/create-customer.component';
import {ViewEncapsulation } from "@angular/core";
import { imageIcon, SVGIcon } from "@progress/kendo-svg-icons";
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  

  constructor() { }

  ngOnInit(): void {
    
  }
}


