import { Produto } from "../estoque/produtos/produto.model";
import { Lancamento } from "./lancamento.model";

export class LancamentoImpl implements Lancamento{
    
    constructor(
        public idIntegrante: number, 
        public produto: Produto, 
        public quantidade: number){}


}