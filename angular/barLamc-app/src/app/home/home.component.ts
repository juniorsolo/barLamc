import { Component, OnInit } from '@angular/core';
import { faDollarSign, faGlassCheers, faGlassMartiniAlt, faGlassWhiskey, faShoppingCart, faWineBottle, faWineGlassAlt } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit {

  iconeBar= faGlassCheers;
  iconeGarrafa = faWineBottle;
  iconeTacaVinho = faWineGlassAlt;
  iconeCopoMartini = faGlassMartiniAlt;
  iconeCopoWhiskey = faGlassWhiskey;
  iconeConsumir = faShoppingCart;
  iconeCobrar = faDollarSign;
  
  

  constructor() { }

  ngOnInit() {
  }

}
