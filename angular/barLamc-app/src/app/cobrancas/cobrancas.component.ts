import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { faHandHoldingUsd } from '@fortawesome/free-solid-svg-icons';
import { dataService } from '../utils/dataService';
import { Month } from '../utils/month.model';

@Component({
  selector: 'app-cobrancas',
  templateUrl: './cobrancas.component.html'
})
export class CobrancasComponent implements OnInit {

  /**Icones */
  iconeCobrancaTitulo = faHandHoldingUsd;

  dataAtual = new Date();


  constructor(private dataService : dataService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {

  }

  public goToDetail() {
    this.router.navigate( [1 ,'detalhe'], {relativeTo:this.route});
  }

  public getMonth() : Month[] {
    return this.dataService.getAllMonths();
  }

  public getYears() : number[] {
    return this.dataService.getYearsForSearch();
  }

}
