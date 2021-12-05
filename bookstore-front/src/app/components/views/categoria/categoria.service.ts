import { environment } from './../../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Categoria } from './categoria.model';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  baseUrl:string=environment.baseUrl;

  constructor(private http:HttpClient) { }

  findAll():Observable<Categoria[]>{
    const url= `${this.baseUrl}/v1/categorias`
      return this.http.get<Categoria[]>(url);
  }

}
