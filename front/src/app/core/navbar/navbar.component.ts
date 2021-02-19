import {Component, OnInit} from '@angular/core';
import {MenuItem} from "primeng/api";
import {AuthService} from "../auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  constructor(private auth: AuthService,
              private router: Router) {
  }

  items: MenuItem[];

  ngOnInit() {
    this.items = [
      {
        label: 'Patient',
        items: [

          {
            label: 'Nouveau',
            icon: 'pi pi-fw pi-plus',
            command: () => this.goTopatient()
          },
          {label: 'Liste', icon: 'pi pi-fw pi-list'},
        ]
      },
      {
        label: 'Consultation',
        items: [{
          label: 'Nouvelle',
          icon: 'pi pi-fw pi-plus'
        },
          {label: 'Liste', icon: 'pi pi-fw pi-list'},
        ]
      }
    ];
  }

  logout(): void {
    this.auth.logout();
    this.router.navigateByUrl('/');
  }
  goTopatient() : void {
    this.router.navigateByUrl('patient');
  }
}
