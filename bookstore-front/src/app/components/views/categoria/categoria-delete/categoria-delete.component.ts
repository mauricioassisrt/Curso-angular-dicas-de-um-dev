import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Categoria } from '../categoria.model';
import { CategoriaService } from '../categoria.service';

@Component({
  selector: 'app-categoria-delete',
  templateUrl: './categoria-delete.component.html',
  styleUrls: ['./categoria-delete.component.css']
})
export class CategoriaDeleteComponent implements OnInit {
  categoria:Categoria={
    id:'', 
    nome:'',
    descricao:''
  }
  constructor(private service:CategoriaService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.categoria.id=this.route.snapshot.paramMap.get('id')!
    this.findById()
  }
  apagar():void{
    this.service.apagar(this.categoria.id!).subscribe((resposta)=>{
      this.cancelar()
      this.service.mensage("Apagado com sucesso!")
    }, err=> {
      this.service.mensage(err.error.message)
    } )
  }
  findById():void{
    this.service.findById(this.categoria.id!).subscribe((resposta)=>{
      this.categoria = resposta
    })
  }
  cancelar():void{
  this.router.navigate(['categorias'])
  }
}
