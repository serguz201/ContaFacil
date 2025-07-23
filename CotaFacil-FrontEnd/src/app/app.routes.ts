import { Routes } from '@angular/router';
import { Bono } from './models/bono';
import { BonoComponent } from './components/bono/bono.component';
import { CreaditabonoComponent } from './components/bono/creaditabono/creaditabono.component';
import { ListarbonoComponent } from './components/bono/listarbono/listarbono.component';
import { ListarbonodetalleComponent } from './components/bono/listarbonodetalle/listarbonodetalle.component';
import { AppComponent } from './app.component';
import { ListarComponent } from './components/resultados/listarResultados/listar.component';
import { ResultadosComponent } from './components/resultados/resultados.component';
import { ManualuserComponent } from './components/home/manualuser/manualuser.component';
import { InicioComponent } from './components/home/inicio/inicio.component';
import { LoginComponent } from './components/login/login.component';
import { FlujocajaComponent } from './components/flujocaja/flujocaja.component';
import { ListacatalogoComponent } from './components/catalogo/listacatalogo/listacatalogo.component';
import { CreaditacatalogoComponent } from './components/catalogo/creaditacatalogo/creaditacatalogo.component';
import { FyqComponent } from './components/fyq/fyq.component';

export const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'inicio', component: InicioComponent },
  {
    path: 'bonos',
    component: BonoComponent,
    children: [
      {
        path: 'nuevo',
        component: CreaditabonoComponent,
      },
      { 
        path: 'ediciones/:id', 
        component: CreaditabonoComponent,
        data: { prerender: false }
      }
    ],
  },
  { path: 'resultados', component: ResultadosComponent },
  { 
    path: 'resultados/:idBono', 
    component: ResultadosComponent,
    data: { prerender: false }
  },
  { path: 'resultados-tabla', component: ListarComponent },
  { 
    path: 'resultados-tabla/:idBono', 
    component: ListarComponent,
    data: { prerender: false }
  },
  { 
    path: 'listarbonodetalle/:idBono', 
    component: ListarbonodetalleComponent,
    data: { prerender: false }
  },
  { path: 'flujo-caja', component: FlujocajaComponent },
  { 
    path: 'flujocaja/:idBono', 
    component: FlujocajaComponent,
    data: { prerender: false }
  },
  { path: 'manual', component: ManualuserComponent },
  { path: 'catalogo-monedas', component: ListacatalogoComponent },
  { path: 'creaditacatalogo', component: CreaditacatalogoComponent },
  { 
    path: 'creaditacatalogo/:id', 
    component: CreaditacatalogoComponent,
    data: { prerender: false }
  },
  { path: 'faq', component: FyqComponent }
];