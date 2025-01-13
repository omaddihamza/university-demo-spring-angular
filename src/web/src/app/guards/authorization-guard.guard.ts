import { ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Injectable } from '@angular/core';
import {AuthService} from "../services/auth.service";

@Injectable({
  providedIn: 'root',
})
export class AuthorizationGuard {
  constructor(private auth:AuthService) {
  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean | UrlTree {
    // Add your authentication logic here
    if(this.auth.isAuthenticated){
      let requiredRoles = route.data['roles'];
      let userRoles = this.auth.roles;
      for(let role of userRoles){
         if(requiredRoles.includes(role)){
           return true;
         }
      }
      return false;
    }else {
      return false;
    }
  }
}
