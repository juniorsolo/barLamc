import { Component, OnInit } from '@angular/core';
import { faHandHoldingUsd } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-cobrancas',
  templateUrl: './cobrancas.component.html'
})
export class CobrancasComponent implements OnInit {

  /**Icones */
  iconeCobrancaTitulo = faHandHoldingUsd;

  dataAtual = new Date();


  constructor() { }

  ngOnInit() {
    console.log(this.dataAtual.getMonth()+1 );
  }

}
