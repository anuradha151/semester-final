import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';
import {User} from '../dto/User';
import {MAIN_URL} from '../app.module';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient, private router: Router) {
  }


  login(user: User): Observable<boolean> {
    return this.http.post<boolean>(
      MAIN_URL + URL, user)
      .pipe(
        map((result) => {
          sessionStorage.setItem('token', result + '');
          sessionStorage.setItem('user', user.username + '');
          if (result) {
            this.router.navigate(['/']);
          }
          return result;
        })
      );

  }

  isAuthenticated(): boolean {
    if (sessionStorage.getItem('token')) {
      return sessionStorage.getItem('token') == 'false' ? false : true;
    }
  }

  logout(): void {
    sessionStorage.removeItem('token');
    this.router.navigate(['/login']);

  }
}
