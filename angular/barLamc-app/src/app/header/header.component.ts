import { Component, OnInit } from '@angular/core';
import { faCartArrowDown, faLaptopCode, faMoneyCheckAlt, faStore, faWarehouse, faWineBottle } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html'
})
export class HeaderComponent implements OnInit {

  iconeLancamento = faCartArrowDown;
  iconeEstoque = faStore;
  iconeHome = faWarehouse;
  iconeSobre = faLaptopCode;
  iconeCobranca = faMoneyCheckAlt;

  constructor() { }

  ngOnInit() {
  }

}
