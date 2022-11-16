import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ConsultasComponent } from './components/consultas/consultas.component';
import { CadastrarComponent } from './components/cadastrar/cadastrar.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule, FormBuilder } from '@angular/forms';
@NgModule({
  declarations: [AppComponent, ConsultasComponent, CadastrarComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatFormFieldModule,
    MatInputModule,
    MatTableModule,
    MatIconModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [FormBuilder],
  bootstrap: [AppComponent],
})
export class AppModule {
  title = 'Front-AgendaMedica';
}
