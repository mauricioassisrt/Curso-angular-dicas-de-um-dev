import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Livro } from '../livro.model';
import { LivroService } from '../livro.service';

@Component({
  selector: 'app-livro-read-all',
  templateUrl: './livro-read-all.component.html',
  styleUrls: ['./livro-read-all.component.css']
})
export class LivroReadAllComponent implements OnInit {
  displayedColumns:string[]=['id', 'titulo', 'livros', 'action']
  livros:Livro[]=[]
  id_cat: string=''
  
  constructor(private service:LivroService, private route:ActivatedRoute) { }

  ngOnInit(): void {
   this.findAllLivro()
    this.id_cat=this.route.snapshot.paramMap.get('id_cat')!
    console.log(this.id_cat)
    this.findAll()
  }
findAll():void{
  
  this.service.findAllByCategoria(this.id_cat).subscribe((resposta)=>{
 
    this.livros= resposta
    
  })
  
}
findAllLivro(){
  this.service.findAllLivro().subscribe(resposta =>{
    console.log(resposta);
    this.livros=resposta
  })
}

}
