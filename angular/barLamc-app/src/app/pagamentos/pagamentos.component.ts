import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pagamentos',
  templateUrl: './pagamentos.component.html'
})
export class PagamentosComponent implements OnInit {

  dataSelecionada : Date = new Date();

  constructor() { }

  ngOnInit() {
  }

  buscarDevedores(){
    console.log(this.dataSelecionada.toJSON());
  }
}
