import {Injectable} from '@angular/core';
import {Customer} from '../dto/Customer';
import {HttpClient} from '@angular/common/http';
import {MAIN_URL} from '../app.module';


const URL = '/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) {
  }

  save(customer: Customer) {
    this.http.post(MAIN_URL + URL, customer);
  }

}
