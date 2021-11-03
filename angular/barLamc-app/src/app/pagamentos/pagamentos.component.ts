import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pagamentos',
  templateUrl: './pagamentos.component.html'
})
export class PagamentosComponent implements OnInit {

  dataSelecionada : Date = new Date();
  exibirDetalhe : boolean = false;
  idIntegranteSelecionado : number = 22;
  
  constructor() { }

  ngOnInit() {
  }

  buscarDevedores(){
    console.log(this.dataSelecionada.toJSON());
  }

  goToDetail(){
    this.exibirDetalhe = true;
  }

  backToPagamentos(){
    this.exibirDetalhe = false;
  }
}
