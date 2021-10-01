import { Component, Input, OnInit } from '@angular/core';
import { Produto } from './produto.model';

@Component({
  selector: 'app-produtos',
  templateUrl: './produtos.component.html'
})
export class ProdutosComponent implements OnInit {

  @Input()
  produtos: Produto[] = [];

  constructor() { 
  }

  ngOnInit() {
  }

}
