import {Injectable} from '@angular/core';
import {Customer} from '../dto/Customer';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {MAIN_URL} from '../app.module';



const URL = '/api/v1/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) {
  }

  save(customer: Customer): Observable<boolean> {
    return this.http.post<boolean>(
      MAIN_URL + URL, customer);
  }

}
