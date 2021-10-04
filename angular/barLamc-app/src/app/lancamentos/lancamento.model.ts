import { Produto } from "../estoque/produtos/produto.model";

export interface Lancamento{
    idIntegrante: number;
    idProduto: number; 
    quantidade: number;
}