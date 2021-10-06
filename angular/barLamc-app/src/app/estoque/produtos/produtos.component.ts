import { Component, Input, OnInit, Output } from '@angular/core';
import { faMinus, faPlus, faStore, faWineBottle } from '@fortawesome/free-solid-svg-icons';

import { Produto } from './produto.model';

@Component({
  selector: 'app-produtos',
  templateUrl: './produtos.component.html'
})
export class ProdutosComponent implements OnInit {

  iconeProduto = faWineBottle;
  iconeMais= faPlus;
  iconeMenos= faMinus;

  @Input()
  produtos: Produto[] = [];

  @Output()
  indexSelected : any;

  constructor() { 
  }

  ngOnInit() {
  }

  selecionaIndex(index : any){
      this.indexSelected = index;
      console.log('produtos componet index selected:' + this.indexSelected );
      //this.produtos.splice(index); deleta elemendo usando index
  }

   adicionaQuantidade( quantidade: number){
     let qtdTemp: number = this.produtos[this.indexSelected].quantidade;
     this.produtos[this.indexSelected].quantidade =  qtdTemp + parseInt(quantidade.toString());
   }

}
