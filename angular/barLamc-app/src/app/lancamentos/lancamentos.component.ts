import { Component, OnInit } from '@angular/core';
import { faCartPlus } from '@fortawesome/free-solid-svg-icons';
import { ProdutoImpl } from '../estoque/produtos/produto.Impl.modal';
import { Produto } from '../estoque/produtos/produto.model';
import { produtoService } from '../estoque/produtos/produto.service';
import { Integrante } from './integrante.model';
import { LancamentoImpl } from './lancamento.impl.model';


@Component({
  selector: 'app-lancamentos',
  templateUrl: './lancamentos.component.html',
  styleUrls: ['./lancamentos.component.css']
})
export class LancamentosComponent implements OnInit {

  carrinhoCompra = faCartPlus;
  
  lancamento: LancamentoImpl = {
        idIntegrante: 0, 
        idProduto: 0, 
        quantidade: 0
  };

  produtosLanc: Produto[] = []

  integrantesLanc: Integrante[]=[
    {
       id: 10,
       nome: 'Coveiro',
       foto: '' 
    },
    {
      id: 20,
      nome: 'Ticano',
      foto: '' 
   }
  ];

  constructor(private produtoSevice : produtoService) { }

  ngOnInit() {
    this.produtosLanc = this.produtoSevice.getAllProdutos();
  }

  adicionaConsumo(idIntegrante: number){
    console.log('integrante id:' + idIntegrante + '  qtd:' + this.lancamento.quantidade);
  }

}
