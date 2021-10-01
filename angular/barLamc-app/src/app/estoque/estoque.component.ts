import { Component, OnInit, AfterViewInit, Input  } from '@angular/core';
import { Produto } from './produtos/produto.model';


declare var $:any;
@Component({
  selector: 'app-estoque',
  templateUrl: './estoque.component.html',
  styleUrls: ['./estoque.component.css']
})
export class EstoqueComponent implements OnInit {


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
  }

}
