import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastrarComponent } from './components/cadastrar/cadastrar.component';
import { ConsultasComponent } from './components/consultas/consultas.component';

const routes: Routes = [
  { path: 'consultas', component: ConsultasComponent },
  { path: 'cadastrar', component: CadastrarComponent },
  { path: '**', redirectTo: '/cadastrar' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
