import { Produto } from "../estoque/produtos/produto.model";
import { Integrante } from "./integrante.model";

export interface Lancamento{
    integrante: Integrante;
    produtos: Produto[];
    produtoSelecionado: Produto; 
    quantidade: string;
}