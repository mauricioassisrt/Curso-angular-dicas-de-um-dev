import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Categoria } from '../categoria.model';
import { CategoriaService } from '../categoria.service';

@Component({
  selector: 'app-categoria-update',
  templateUrl: './categoria-update.component.html',
  styleUrls: ['./categoria-update.component.css']
})
export class CategoriaUpdateComponent implements OnInit {

  constructor(private router: Router, private service: CategoriaService, private route:ActivatedRoute) { }
  categoria:Categoria={
    nome:'',
    descricao:''
  }
  ngOnInit(): void {
    this.categoria.id=this.route.snapshot.paramMap.get('id')!
    this.findById();
  }
  cancelar(): void {
    this.router.navigate(['categorias'])
  }
  //update():Observable
findById():void{
  this.service.findById(this.categoria.id!).subscribe((resposta)=>{
    this.categoria= resposta
  });

  
}
update():void{
  this.service.update(this.categoria).subscribe((resposta)=>{
    this.router.navigate(["categorias"])
    this.service.mensage("Categoria Atualizada com sucesso!");
    
  }, err=>{
    this.service.mensage("Falha na comunicação com o servidor!");
    
  })
}
}
