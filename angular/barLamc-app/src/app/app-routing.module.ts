import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { CobrancaDetalheComponent } from './cobrancas/cobranca-detalhe/cobranca-detalhe.component';
import { CobrancasComponent } from './cobrancas/cobrancas.component';
import { EstoqueComponent } from './estoque/estoque.component';
import { HomeComponent } from './home/home.component';
import { LancamentosComponent } from './lancamentos/lancamentos.component';
import { PagamentosComponent } from './pagamentos/pagamentos.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

const routes: Routes = [
  {path:'home', component: HomeComponent},
  { path: '',   redirectTo: '/home', pathMatch: 'full' },
  {path:'lancamentos', component: LancamentosComponent},
  {path:'pagamentos', component: PagamentosComponent},
  {path:'estoque', component: EstoqueComponent},
  {path:'cobranca', component: CobrancasComponent},
  {path:'cobranca/:id/detalhe', component: CobrancaDetalheComponent},
  {path:'about', component: AboutComponent},
  {path:'**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
