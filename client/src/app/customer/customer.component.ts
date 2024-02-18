import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customer: any;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    let response = this.http.get("http://localhost:8080/customers/get");
    response.subscribe((data) => this.customer = data);
  }

}
