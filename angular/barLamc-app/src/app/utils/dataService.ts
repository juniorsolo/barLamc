import { Injectable } from "@angular/core";
import { Month } from "./month.model";

@Injectable(
    {
        providedIn: "root"
    }
)
export class dataService{

    mesesDoAno: Month[] = [];
    anosBusca: number[] = [];

    getAllMonths() : Month[]{
        this.mesesDoAno = [];
        this.mesesDoAno.push(new Month(1, "Janeiro"));
        this.mesesDoAno.push(new Month(2, "Fevereiro"));
        this.mesesDoAno.push(new Month(3, "Março"));
        this.mesesDoAno.push(new Month(4, "Abril"));
        this.mesesDoAno.push(new Month(5, "Maio"));
        this.mesesDoAno.push(new Month(6, "Junho"));
        this.mesesDoAno.push(new Month(7, "Julho"));
        this.mesesDoAno.push(new Month(8, "Agosto"));
        this.mesesDoAno.push(new Month(9, "Setembro"));
        this.mesesDoAno.push(new Month(10, "Outubro"));
        this.mesesDoAno.push(new Month(11, "Novembro"));
        this.mesesDoAno.push(new Month(12, "Dezembro"));   
        return this.mesesDoAno;
    }

    getYearsForSearch() : number[] {
        let data  = new Date;
        this.anosBusca = [];
        this.anosBusca.push(data.getFullYear());
        this.anosBusca.push(data.getFullYear() - 1);
        return this.anosBusca;
    }
}