import { Component, OnInit } from '@angular/core';
import { faSkull } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {
  
  iconeCoveiro = faSkull;

  constructor() { }

  ngOnInit() {
  }

}
