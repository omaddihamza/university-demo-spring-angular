import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  users:any = {
    admin:{password:'1234', roles:['STUDENT','ADMIN']},
    user1:{password:'1234', roles:['STUDENT']}
  }
  username :any;
  isAuthenticated : boolean=false;
  roles : string[] = [];
  constructor(private Http:HttpClient) { }

  login(username:string, password:string):boolean{
    if(this.users[username] && this.users[username]['password']== password){
      this.username = username;
      this.isAuthenticated = true;
      this.roles = this.users[username]['roles'];
      return true;
    }else {
      return false;
    }
  }

  logout() {
    this.username = undefined;
     this.isAuthenticated = false;
      this.roles = [];
  }
}

