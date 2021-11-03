import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-pagamento-detalhe',
  templateUrl: './pagamento-detalhe.component.html'
})
export class PagamentoDetalheComponent implements OnInit {

   @Input()
   idIntegrante : number = 0; 

  constructor() { }

  ngOnInit() {

    console.log("detalhe pagamento id:" + this.idIntegrante);
  }

}
