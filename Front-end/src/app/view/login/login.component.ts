import {Component, OnInit} from '@angular/core';
import {User} from '../../dto/User';
import {AuthService} from '../../service/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = new User();
  failed: boolean;

  constructor(private authService: AuthService, private router: Router) {
  }

  ngOnInit() {

  }

  loginin(): void {

    this.authService.login(this.user).subscribe(
      (result) => {
        this.failed = !result;
      });
  }

  logout(): void {
    alert('logout');
    this.authService.logout();

  }

}
