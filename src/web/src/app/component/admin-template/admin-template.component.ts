import { Component } from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-admin-template',
  templateUrl: './admin-template.component.html',
  styleUrls: ['./admin-template.component.css']
})
export class AdminTemplateComponent {
constructor(public auth:AuthService, private router : Router) {
}

  logout() {
     this.auth.logout()
     this.router.navigateByUrl("/");
  }
}
