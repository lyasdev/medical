import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  form:FormGroup;

  error: string;

  constructor(private fb: FormBuilder,
              private auth: AuthService,
              private router: Router) { 
    this.form = this.fb.group({
      login: ['',Validators.required],
      password: ['',Validators.required]
    });
  }

  login(): void {
    const value = this.form.value;
    this.auth.login(value.login, value.password).subscribe(
      data => this.router.navigateByUrl('/'),
      err => this.error = 'Login et/ou mot de passes incorrects'
    );
  }
}
