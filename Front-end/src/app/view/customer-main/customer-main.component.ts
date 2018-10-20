import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../../service/customer.service';
import {Customer} from '../../dto/Customer';

@Component({
  selector: 'app-customer-main',
  templateUrl: './customer-main.component.html',
  styleUrls: ['./customer-main.component.css']
})
export class CustomerMainComponent implements OnInit {
  customer: Customer = new Customer();

  constructor(private customerService: CustomerService) {
  }

  ngOnInit() {
  }

  saveCustomer() {
   this.customerService.save(this.customer);
  }
}
