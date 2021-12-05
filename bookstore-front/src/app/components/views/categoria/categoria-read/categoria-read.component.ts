import { CategoriaService } from './../categoria.service';
import { Categoria } from './../categoria.model';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-categoria-read',
  templateUrl: './categoria-read.component.html',
  styleUrls: ['./categoria-read.component.css']
})

export class CategoriaReadComponent implements OnInit {
  categorias:Categoria[]=[];
  displayedColumns:string[]=['id', 'nome', 'descricao','livros', 'action']
  constructor(private service:CategoriaService, private router:Router) { }

  ngOnInit(): void {
    this.findAll();
  }
  findAll(){
    this.service.findAll().subscribe(resposta =>{
      console.log(resposta);
      this.categorias=resposta
    })
  }
  
  navegarCategoriaCreate(){
    this.router.navigate(["/categorias/create"]);
  }
}


