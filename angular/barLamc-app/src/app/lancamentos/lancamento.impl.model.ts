import { Lancamento } from "./lancamento.model";

export class LancamentoImpl implements Lancamento{
    
    constructor(
        public idIntegrante: number, 
        public idProduto: number, 
        public quantidade: number){}


}