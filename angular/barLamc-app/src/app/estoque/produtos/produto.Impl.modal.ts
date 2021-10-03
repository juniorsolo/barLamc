import { Produto } from "./produto.model";

export class ProdutoImpl implements Produto{

    constructor(
        public id: number,
        public nome: string,
        public quantidade: number
    ){
    }

}