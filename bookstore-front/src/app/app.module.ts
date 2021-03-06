import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from '@angular/material/toolbar';
import { HeaderComponent } from './components/template/header/header.component'; 
import {MatIconModule} from '@angular/material/icon';
import { FooterComponent } from './components/template/footer/footer.component';
import { NavComponent } from './components/template/nav/nav.component'; 
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import { HomeComponent } from './components/views/home/home.component'; 
import {MatButtonModule} from '@angular/material/button';

import {MatCardModule} from '@angular/material/card';
import { CategoriaReadComponent } from './components/views/categoria/categoria-read/categoria-read.component'; 
import { HttpClientModule } from '@angular/common/http';
import {MatTableModule} from '@angular/material/table';
import { CategoriaCreateComponent } from './components/views/categoria/categoria-create/categoria-create.component'; 
import {MatFormFieldModule} from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { CategoriaDeleteComponent } from './components/views/categoria/categoria-delete/categoria-delete.component';
import { CategoriaUpdateComponent } from './components/views/categoria/categoria-update/categoria-update.component';
import { LivroReadAllComponent } from './components/views/livro/livro-read-all/livro-read-all.component';
import { LivroCreateComponent } from './components/views/livro/livro-create/livro-create.component';
import { ReactiveFormsModule,  } from '@angular/forms';
import {MatSelectModule} from '@angular/material/select';
import { LivroUpdateComponent } from './components/views/livro/livro-update/livro-update.component';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavComponent,
    HomeComponent,
    CategoriaReadComponent,
    CategoriaCreateComponent,
    CategoriaDeleteComponent,
    CategoriaUpdateComponent,
    LivroReadAllComponent,
    LivroCreateComponent,
    LivroUpdateComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatSidenavModule,
    MatListModule,
    MatCardModule,
    MatTableModule,
    HttpClientModule,
    MatButtonModule,
   
    FormsModule,
    MatInputModule,
    MatFormFieldModule,
    MatSnackBarModule,
    ReactiveFormsModule,
    MatSelectModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
