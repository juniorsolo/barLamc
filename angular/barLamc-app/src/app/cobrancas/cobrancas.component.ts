import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { faHandHoldingUsd } from '@fortawesome/free-solid-svg-icons';
import { dataService } from '../utils/dataService';
import { Month } from '../utils/month.model';
import { CobrancaDetalheComponent } from './cobranca-detalhe/cobranca-detalhe.component';

@Component({
  selector: 'app-cobrancas',
  templateUrl: './cobrancas.component.html'
})
export class CobrancasComponent implements OnInit {

  /**Icones */
  iconeCobrancaTitulo = faHandHoldingUsd;

  dataAtual = new Date();

  id : number =111;

  anoSelecionado : number = 0;
  mesSelecionado : string = "undefined";
  exibirDetalhe : boolean = false;


  constructor(private dataService : dataService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
 
  }

  public goToDetail() {
    console.log("go detail:" + this.anoSelecionado + " - " + this.mesSelecionado);
    this.exibirDetalhe = true;
    //this.router.navigate( ['detalhe'], {relativeTo:this.route});
    
  }

  public backToCobranca(){
    this.exibirDetalhe = false;
  }

  public desabilitaBuscar() : boolean{
    return this.anoSelecionado === 0 || this.mesSelecionado == '' || this.mesSelecionado == 'undefined' ? true : false;
    
  }

  public getMonth() : Month[] {
    return this.dataService.getAllMonths();
  }

  public getYears() : number[] {
    return this.dataService.getYearsForSearch();
  }

}
