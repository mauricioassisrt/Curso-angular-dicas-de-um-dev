import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Categoria } from '../categoria/categoria.model';
import { Livro } from './livro.model';

@Injectable({
  providedIn: 'root'
})
export class LivroService {

   baseUrl:string =environment.baseUrl;
  constructor(private http:HttpClient, private snack:MatSnackBar) { }

  findAllByCategoria(id_cat:string):Observable<Livro[]>{
    
    const url = `${this.baseUrl}/v1/livros?categoria=${id_cat}`
    return this.http.get<Livro[]>(url);
  }

  findAll(): Observable<Categoria[]> {
    const url = `${this.baseUrl}/v1/categorias`
    return this.http.get<Categoria[]>(url);
  }
  create(livro: Livro, string:String): Observable<Livro> {
    const url = `${this.baseUrl}/v1/livros?categoria=${string}`
    return this.http.post<Livro>(url, livro)
  }
  mensage(str: string): void {
    this.snack.open(`${str}`, 'OK', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 3000
    })
  }
}
