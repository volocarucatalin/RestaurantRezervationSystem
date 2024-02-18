import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CreateCustomerRezevation } from './create-customer-rezevation';

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {

  baseURL="http://localhost:8080/customers/add";

  constructor(private httpClient : HttpClient) { }

  addCostumer(customer : CreateCustomerRezevation){
    console.log(customer);
    
    return this.httpClient.post(this.baseURL,customer)
  }

  
}
