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
import { FormsModule, NgModel } from '@angular/forms';



@NgModule({
  declarations: [						
    AppComponent,
      HeaderComponent,
      HomeComponent,
      AboutComponent,
      LancamentosComponent,
      EstoqueComponent,
      ProdutosComponent
      
   ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
