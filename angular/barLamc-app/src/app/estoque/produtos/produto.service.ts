import { Injectable } from "@angular/core";
import { Produto } from "./produto.model";

@Injectable(
    {
        providedIn:'root'
    }
)
export class produtoService {
    
    produtosList: Produto[] = [];

    constructor(){}

    getAllProdutos() : Produto[] {
        this.produtosList = [
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
        return this.produtosList;
    }
}