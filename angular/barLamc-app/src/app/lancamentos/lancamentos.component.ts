import { Component, OnInit } from '@angular/core';
import { faCartArrowDown, faCartPlus, faShoppingCart } from '@fortawesome/free-solid-svg-icons';
import { ProdutoImpl } from '../estoque/produtos/produto.Impl.modal';
import { Produto } from '../estoque/produtos/produto.model';
import { produtoService } from '../estoque/produtos/produto.service';
import { Integrante } from './integrante.model';
import { Lancamento } from './lancamento.model';


@Component({
  selector: 'app-lancamentos',
  templateUrl: './lancamentos.component.html',
  styleUrls: ['./lancamentos.component.css']
})
export class LancamentosComponent implements OnInit {
  /** icone do carrinho */
  carrinhoCompra = faCartPlus;
  iconeLancamento = faShoppingCart;
  /**
   * Faz parte da tabela de integrantes e produtos para lançamento...
   */
  lancamentos: Lancamento[]= [];
  
  /**
   * Representa os produtos 
   */
  produtosLanc: Produto[] = [];

  lancamentoSelecionado: Lancamento = {
    integrante: {id:0, nome: '', foto: ''},
    produtos: [],
    produtoSelecionado: {id: 0, nome: '', quantidade: 0},
    quantidade: ''
};

  integrantesLanc: Integrante[]= [];

  constructor(private produtoSevice : produtoService) { }

  ngOnInit() {
    console.log('chamou init');
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

  lancarConsumo(){
    console.log('integrante id:' + this.lancamentoSelecionado.integrante.id + ' produto: ' +
     this.lancamentoSelecionado.produtoSelecionado.nome + " qtd:" + this.lancamentoSelecionado.quantidade  );
  }


  adicionaConsumo(lanc: Lancamento){
    
    if(lanc.quantidade == null || lanc.quantidade <= '0'){
        console.log("Quantidade invalida" + lanc.quantidade);
    }
    this.lancamentoSelecionado = lanc;
    this.preencheLancamentos();
  }

  public validaPreenchimento(lanc: Lancamento) : boolean{
    if(lanc.integrante.id === null || lanc.integrante.id === 0){
      return false;
    }

    if(lanc.produtoSelecionado === null || lanc.produtoSelecionado.id === 0){
      return false;
    }

    if(lanc.quantidade === null || lanc.quantidade  === "0" || lanc.quantidade.toString()  === ""){
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
          quantidade: ''
        }
      );
    }
  }

}
