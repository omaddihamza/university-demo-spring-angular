import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./component/home/home.component";
import {ProfileComponent} from "./component/profile/profile.component";
import {LoadStudentsComponent} from "./component/load-students/load-students.component";
import {LoadPaymentsComponent} from "./component/load-payments/load-payments.component";
import {DashboardComponent} from "./component/dashboard/dashboard.component";
import {LoginComponent} from "./component/login/login.component";
import {StudentsComponent} from "./component/students/students.component";
import {PaymentsComponent} from "./component/payments/payments.component";
import {NotFoundComponent} from "./component/not-found/not-found.component";
import {AdminTemplateComponent} from "./component/admin-template/admin-template.component";
import {AuthGuard} from "./guards/auth.guard";
import {AuthorizationGuard} from "./guards/authorization-guard.guard";

const routes: Routes = [
  {path:'', component:LoginComponent},
  {path:'login', component:LoginComponent},
  {path:'admin', component:AdminTemplateComponent, canActivate: [AuthGuard], children:[
      {path:'home', component:HomeComponent},
      {path:'profile', component:ProfileComponent},
      {
        path:'load-students',
        component:LoadStudentsComponent,
        data: { roles: ['ADMIN'] }, // Static data including required roles
        canActivate: [AuthorizationGuard],
      },
      {
        path:'load-payments',
        component:LoadPaymentsComponent,
        data: { roles: ['ADMIN'] }, // Static data including required roles
        canActivate: [AuthorizationGuard],
      },
      {path:'dashboard', component:DashboardComponent},
      {path:'students' ,component:StudentsComponent},
      {path:'payments',component:PaymentsComponent }
    ]},
  {path:'**' ,component:NotFoundComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
