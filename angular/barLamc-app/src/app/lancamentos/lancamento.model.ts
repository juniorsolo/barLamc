import { Produto } from "../estoque/produtos/produto.model";

export interface Lancamento{
    idIntegrante: number;
    produto: Produto; 
    quantidade: number;
}