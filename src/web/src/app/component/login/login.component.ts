import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
    loginForm !: FormGroup;
   constructor(private fb:FormBuilder,
               private auth :AuthService,
               private router: Router) {
   }

    ngOnInit(): void {
       this.loginForm = this.fb.group({
         username : this.fb.control(''),
         password : this.fb.control('')
       })
    }

  login() {
    const username = this.loginForm.value.username;
    const password = this.loginForm.value.password;
    const auth  = this.auth.login(username, password);
    if(auth == true){
        this.router.navigateByUrl('/admin/dashboard');
    }
  }
}
