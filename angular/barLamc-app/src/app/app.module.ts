import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { LancamentosComponent } from './lancamentos/lancamentos.component';
import { EstoqueComponent } from './estoque/estoque.component';
import { ProdutosComponent } from './estoque/produtos/produtos.component';
import { FormsModule, NgModel, ReactiveFormsModule } from '@angular/forms';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { PagamentosComponent } from './pagamentos/pagamentos.component';
import { CobrancasComponent } from './cobrancas/cobrancas.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';



@NgModule({
  declarations: [									
    AppComponent,
      HeaderComponent,
      HomeComponent,
      AboutComponent,
      LancamentosComponent,
      EstoqueComponent,
      ProdutosComponent,
      PagamentosComponent,
      CobrancasComponent,
      PageNotFoundComponent
   ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    FontAwesomeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
