import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-cobranca-detalhe',
  templateUrl: './cobranca-detalhe.component.html'
})
export class CobrancaDetalheComponent implements OnInit {


  @Output() newItemEvent = new EventEmitter<boolean>();

  
  constructor(private route: ActivatedRoute, private router: Router) { }
  
  ngOnInit() {
    const heroId = this.route.snapshot.paramMap.get('id');
  }
  
  addNewItem(value: boolean) {
    this.newItemEvent.emit(value);
  }
}
