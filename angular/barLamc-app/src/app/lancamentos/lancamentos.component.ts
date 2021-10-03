import { Component, OnInit } from '@angular/core';
import { faCartArrowDown } from '@fortawesome/free-solid-svg-icons';


@Component({
  selector: 'app-lancamentos',
  templateUrl: './lancamentos.component.html',
  styleUrls: ['./lancamentos.component.css']
})
export class LancamentosComponent implements OnInit {

  faCartArrow = faCartArrowDown;

  constructor() { }

  ngOnInit() {
  }

}
