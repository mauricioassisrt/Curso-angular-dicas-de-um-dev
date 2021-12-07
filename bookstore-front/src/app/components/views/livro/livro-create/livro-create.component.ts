import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Categoria } from '../../categoria/categoria.model';
import { Livro } from '../livro.model';
import { LivroService } from '../livro.service';

@Component({
  selector: 'app-livro-create',
  templateUrl: './livro-create.component.html',
  styleUrls: ['./livro-create.component.css']
})
export class LivroCreateComponent implements OnInit {
  categorias:Categoria[]=[];
  livro:Livro={
   
    titulo: '',
    nomeAutor:'',
    texto:'',
    categoria:''
  }
  selected: string="";
  constructor(
    private service:LivroService, private router:Router
  ) { }

  ngOnInit(): void {
    this.service.findAll().subscribe(resposta=>{
      this.categorias=resposta;
      console.log(this.categorias)
    })
  }
  salvar():void {
   
    this.service.create(this.livro, this.livro.categoria).subscribe((resposta)=>{
      console.log(resposta);
      this.service.mensage("Livro SAlvo  com sucesso");
      this.router.navigate(['/categorias']);
   })
  }
}
