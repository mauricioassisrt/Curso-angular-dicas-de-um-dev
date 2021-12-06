import { environment } from './../../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Categoria } from './categoria.model';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  baseUrl: string = environment.baseUrl;

  constructor(private snack: MatSnackBar, private http: HttpClient) { }
  findById(id: String): Observable<Categoria> {
    const url = `${this.baseUrl}/v1/categorias/${id}`
    return this.http.get<Categoria>(url);
  }
  apagar(id:string):Observable<void>{
    const url = `${this.baseUrl}/v1/categorias/${id}`
    return this.http.delete<void>(url)
  }
  findAll(): Observable<Categoria[]> {
    const url = `${this.baseUrl}/v1/categorias`
    return this.http.get<Categoria[]>(url);
  }
  create(categoria: Categoria): Observable<Categoria> {
    const url = `${this.baseUrl}/v1/categorias`
    return this.http.post<Categoria>(url, categoria)
  }

  update(categoria:Categoria):Observable<void>{
    const url = `${this.baseUrl}/v1/categorias/${categoria.id}`
    return this.http.put<void>(url, categoria)
  }
  mensage(str: string): void {
    this.snack.open(`${str}`, 'OK', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 3000
    })
  }
}
