import { Component, OnInit } from '@angular/core';
import { faCartArrowDown, faCartPlus, faExclamationTriangle, faMinus, faPlus, faShoppingCart } from '@fortawesome/free-solid-svg-icons';
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
  /** icones */
  carrinhoCompra = faCartPlus;
  iconeLancamento = faShoppingCart;
  iconeMais= faPlus;
  iconeMenos= faMinus;
  iconeAtencao= faExclamationTriangle;

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
    quantidade: 0
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
     },
     {
      id: 30,
      nome: 'Marcelino',
      foto: '' 
   }
    ];
    this.preencheLancamentos();
  }

  lancarConsumo(){
    console.log('integrante id:' + this.lancamentoSelecionado.integrante.id + ' produto: ' +
     this.lancamentoSelecionado.produtoSelecionado.nome + " qtd:" + this.lancamentoSelecionado.quantidade  );
     this.lancamentoSelecionado = this.novoLancamento();
     this.preencheLancamentos();
  }


  adicionaConsumo(lanc: Lancamento){
    console.log('chamou ++');
    lanc.quantidade ++;
  }

  subtraiConsumo(lanc: Lancamento){
    console.log('chamou --');
    if(lanc.quantidade > 0){
      lanc.quantidade --;
    }
  }

  public desabilitaSubtrair(lanc: Lancamento): boolean{
    if(lanc.quantidade === 0 || lanc.quantidade  < 0){
      return true;
    }else{
      return false;
    }
  }

  public validaPreenchimento(lanc: Lancamento) : boolean{

    if(lanc.integrante.id === null || lanc.integrante.id === 0){
      return false;
    }

    if(lanc.produtoSelecionado === null || lanc.produtoSelecionado.id === 0){
      return false;
    }

    if(lanc.quantidade === null || lanc.quantidade  === 0 || lanc.quantidade < 0){
      return false;
    }
    return true;
  }

  preparaLancamentoParaEnvio(lanc: Lancamento){
    console.log('prepara lancamento para envio.');
      if(this.validaPreenchimento(lanc)){
        this.lancamentoSelecionado = lanc;   
      }else{
        console.log('preenchimento não e valido');
      }
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

  limparLancamentoSelecionado(){
    this.lancamentoSelecionado = this.novoLancamento();
  }

  private novoLancamento() :Lancamento{
    return {
      integrante: {id:0, nome: '', foto: ''},
      produtos: [],
      produtoSelecionado: {id: 0, nome: '', quantidade: 0},
      quantidade: 0
    };
  }

}
