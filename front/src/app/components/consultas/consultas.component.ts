import { ConsultaService } from './../../services/consulta-service.service';

import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-consultas',
  templateUrl: './consultas.component.html',
  styleUrls: ['./consultas.component.scss'],
})
export class ConsultasComponent implements OnInit {
  constructor(private service: ConsultaService) {}

  ngOnInit(): void {}
}
