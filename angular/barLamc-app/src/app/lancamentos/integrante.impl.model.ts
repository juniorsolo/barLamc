import { Integrante } from "./integrante.model";

export class IntegranteImpl implements Integrante{
    constructor(
        public id: number,
        public nome: string,
        public foto: string
    ){}

}