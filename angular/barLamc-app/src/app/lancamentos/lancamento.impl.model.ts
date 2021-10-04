import { Produto } from "../estoque/produtos/produto.model";
import { Integrante } from "./integrante.model";
import { Lancamento } from "./lancamento.model";

export class LancamentoImpl implements Lancamento{
    
    constructor(
        public integrante: Integrante, 
        public produtos: Produto[],
        public produtoSelecionado: Produto, 
        public quantidade: number){}


}