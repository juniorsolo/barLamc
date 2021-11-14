import { Component, OnInit, AfterViewInit, Input, ViewChild  } from '@angular/core';
import { faStore } from '@fortawesome/free-solid-svg-icons';
import { ProdutoImpl } from './produtos/produto.Impl.modal';
import { Produto } from './produtos/produto.model';
import { ProdutosComponent } from './produtos/produtos.component';


declare var $:any;
@Component({
  selector: 'app-estoque',
  templateUrl: './estoque.component.html'
})
export class EstoqueComponent implements OnInit {
  
  iconeEstoque = faStore;
  menuSelecionado : string = '';

  @ViewChild(ProdutosComponent)
  produtoChild!: ProdutosComponent;

  @Input()
  newProduto: ProdutoImpl={
    id: 0,
    nome: '',
    quantidade: 0
  };

  quantidadeNew : number = 0;

  produtosEst: Produto[] = [
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

  addNewProduto(){
    console.log('chamou!!!');
    console.log('nome:'+this.newProduto!.nome);
    this.produtosEst.push(this.newProduto);
    this.newProduto = {
      id: 0,
      nome: '',
      quantidade: 0
    };
  }

  addQuantidade(){
    console.log('chamou estoque addQtd.' + this.produtoChild.indexSelected);
     this.produtoChild.adicionaQuantidade(this.quantidadeNew);

  }

  constructor() { 

  }
  
  ngAfterViewInit(){
    window.setTimeout(function() {
      $("#alertmsg").fadeTo(500, 0).slideUp(500, function(){
          $("#alertmsg").remove(); 
      });
  }, 2000);
}

  ngOnInit() {
    this.menuSelecionado = 'PRODUTOS';
  }

}
