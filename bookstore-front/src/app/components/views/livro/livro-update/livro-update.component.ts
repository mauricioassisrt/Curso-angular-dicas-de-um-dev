import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categoria } from '../../categoria/categoria.model';
import { Livro } from '../livro.model';
import { LivroService } from '../livro.service';

@Component({
  selector: 'app-livro-update',
  templateUrl: './livro-update.component.html',
  styleUrls: ['./livro-update.component.css']
})
export class LivroUpdateComponent implements OnInit {
  selected: string="";
  categorias:Categoria[]=[];
  livro:Livro={
   
    titulo: '',
    nomeAutor:'',
    texto:'',
    categoria:''
  }
  constructor( private service:LivroService, private router:Router, private route:ActivatedRoute ) { }

  ngOnInit(): void {
    this.service.findAll().subscribe(resposta=>{
      this.categorias=resposta;
      console.log(this.categorias)
    })
    this.livro.id=this.route.snapshot.paramMap.get('id')!
    this.findById();

  }
  findById():void{
    this.service.findByIdLivro(this.livro.id!).subscribe((resposta)=>{
      this.livro= resposta
    });
    console.log(this.livro)
  }
}
