import { Component, OnInit } from '@angular/core';
import { CreateCustomerRezevation } from '../create-customer-rezevation';
import { CustomerServiceService } from '../customer-service.service';

@Component({
  selector: 'app-create-costumer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css'],
  
  
})
export class CreateCustomerComponent implements OnInit {

  customer:CreateCustomerRezevation = new CreateCustomerRezevation()
  
  constructor(private customerService : CustomerServiceService) { }

  ngOnInit(): void {

  }

  addCostumerData(){
    this.customerService.addCostumer(this.customer).subscribe(data =>{
      alert("Customer data insert succesfuly");
    },error => alert("Sorry unbae to insert rezervation"))
    
  }

}
