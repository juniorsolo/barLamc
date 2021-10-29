import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-cobranca-detalhe',
  templateUrl: './cobranca-detalhe.component.html'
})
export class CobrancaDetalheComponent implements OnInit {


  @Input()
  idIntegrante: number = 0;

  
  constructor() { 
  }
  
  ngOnInit() {
    // const heroId = this.route.snapshot.paramMap.get('id');
    console.log('id do integrante detalhe:'+this.idIntegrante);
  }
  

}
