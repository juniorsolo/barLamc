import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { EstoqueComponent } from './estoque/estoque.component';
import { HomeComponent } from './home/home.component';
import { LancamentosComponent } from './lancamentos/lancamentos.component';

const routes: Routes = [
  {path:'home', component: HomeComponent},
  { path: '',   redirectTo: '/home', pathMatch: 'full' },
  {path:'lancamentos', component: LancamentosComponent},
  {path:'estoque', component: EstoqueComponent},
  {path:'about', component: AboutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
