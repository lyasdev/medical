import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../core/auth.service';

@Component({
  selector: 'app-shell',
  templateUrl: './shell.component.html',
  styleUrls: ['./shell.component.scss']
})
export class ShellComponent implements OnInit {

  constructor(private auth: AuthService,
              private router: Router){}

  ngOnInit(): void {
  }

  logout(): void {
    this.auth.logout();
    this.router.navigateByUrl('');
  }

}
