import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-cobranca-detalhe',
  templateUrl: './cobranca-detalhe.component.html'
})
export class CobrancaDetalheComponent implements OnInit {

  constructor(private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    const heroId = this.route.snapshot.paramMap.get('id');
    console.log('id detalhe:'+ heroId);
  }

 
}
