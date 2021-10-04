import { Component, OnInit } from '@angular/core';
import { faCartPlus } from '@fortawesome/free-solid-svg-icons';
import { ProdutoImpl } from '../estoque/produtos/produto.Impl.modal';
import { Produto } from '../estoque/produtos/produto.model';
import { produtoService } from '../estoque/produtos/produto.service';
import { IntegranteImpl } from './integrante.impl.model';
import { Integrante } from './integrante.model';
import { LancamentoImpl } from './lancamento.impl.model';
import { Lancamento } from './lancamento.model';


@Component({
  selector: 'app-lancamentos',
  templateUrl: './lancamentos.component.html',
  styleUrls: ['./lancamentos.component.css']
})
export class LancamentosComponent implements OnInit {

  carrinhoCompra = faCartPlus;

  lancamentos: Lancamento[]= [];

  produtosLanc: Produto[] = [];

  produtoSelecionado!: Produto;

  integrantesLanc: Integrante[]= [];

  constructor(private produtoSevice : produtoService) { }

  ngOnInit() {
    this.produtosLanc = this.produtoSevice.getAllProdutos();
    this.integrantesLanc = [
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
    this.preencheLancamentos();
  }



  adicionaConsumo(lanc: Lancamento){
    console.log('integrante id:' + lanc.integrante.id + ' produto selec: ' + lanc.produtoSelecionado.nome + " qtd:" + lanc.quantidade  );
    if(lanc.quantidade == null || lanc.quantidade <=0){
        console.log('Quantidade invalida' + lanc.quantidade);
    }
    this.preencheLancamentos();
  }

  public validaPreenchimento(lanc: Lancamento) : boolean{
    if(lanc.integrante.id == null || lanc.integrante.id === 0){
      return false;
    }

    if(lanc.produtoSelecionado == null || lanc.produtoSelecionado.id === 0){
      return false;
    }

    if(lanc.quantidade == null || lanc.quantidade  <= 0){
      return false;
    }
    return true;
  }

  private preencheLancamentos(){
    this.lancamentos = [];

    for (let i of this.integrantesLanc) {
      let produtosTemp = Object.assign([], this.produtosLanc);

      this.lancamentos.push(
        {
          integrante: i,
          produtos: produtosTemp,
          produtoSelecionado: new ProdutoImpl(0 ,'',0),
          quantidade: 0
        }
      );
    }
  }

}
