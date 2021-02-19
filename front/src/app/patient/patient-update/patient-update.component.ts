import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-patient-update',
  templateUrl: './patient-update.component.html',
  styleUrls: ['./patient-update.component.scss']
})
export class PatientUpdateComponent implements OnInit {
 sexes = [];
 groupsg = [];
  constructor() { }

  ngOnInit(): void {
  }

}
