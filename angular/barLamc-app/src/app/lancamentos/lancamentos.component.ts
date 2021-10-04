import { Component, OnInit } from '@angular/core';
import { faCartPlus } from '@fortawesome/free-solid-svg-icons';
import { ProdutoImpl } from '../estoque/produtos/produto.Impl.modal';
import { Produto } from '../estoque/produtos/produto.model';
import { LancamentoImpl } from './lancamento.impl.model';


@Component({
  selector: 'app-lancamentos',
  templateUrl: './lancamentos.component.html',
  styleUrls: ['./lancamentos.component.css']
})
export class LancamentosComponent implements OnInit {

  carrinhoCompra = faCartPlus;
  seletedProduto!: ProdutoImpl;
  lancamento: LancamentoImpl = {
        idIntegrante: 0, 
        produto: { id: 0 , nome: '', quantidade:0}, 
        quantidade: 0
  };

  produtosLanc: Produto[] = [
    {
      id: 1,
      nome: 'Heineken',
      quantidade: 220
    },
    {
      id: 2,
      nome: 'Duplo Malte',
      quantidade: 180
    },
    {
      id: 3,
      nome: 'Coca Cola',
      quantidade: 26
    }

  ];

  constructor() { }

  ngOnInit() {
  }

  adicionaConsumo(){
    console.log('produto id:' + this.lancamento.produto.id + '  qtd:' + this.lancamento.quantidade);
  }

}
