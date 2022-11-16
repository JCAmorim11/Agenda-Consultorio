import { ConsultaService } from '../../services/consulta.service';

import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
  ReactiveFormsModule,
} from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { debounceTime } from 'rxjs';

@Component({
  selector: 'app-consultas',
  templateUrl: './consultas.component.html',
  styleUrls: ['./consultas.component.scss'],
})
export class ConsultasComponent implements OnInit {
  constructor(
    private service: ConsultaService,
    private form: FormBuilder,
    private formB: FormBuilder
  ) {}

  private isButtonVisible = true;
  forms!: FormGroup;
  reallocatedAssertDataSource: any;
  data_export = [{}];
  file: any;
  filenameControl = this.formB.control('', Validators.required);

  public love: boolean = false;
  filterControl = new FormControl('');

  dataTable = new MatTableDataSource();
  displayedColumns = [
    'numeroConsulta',
    'paciente',
    'medico',
    'consultorio',
    'dataHora',
    'status',
    'editar',
  ];
  consultas = null;
  consultaForm = this.form.group({
    numeroConsulta: [null, [Validators.required]],
    paciente: [null, [Validators.required]],
    medico: [null, [Validators.required]],
    consultorio: [null, [Validators.required]],
    dataHora: [null, [Validators.required]],
    status: [null],
  });

  ngOnInit(): void {
    this.service.findAll().subscribe((response) => {
      this.dataTable.data = response.conent;
    });
  }
}
