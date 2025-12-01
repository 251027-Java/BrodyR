import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Auth } from '../../services/auth';

@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {
  constructor(private router:Router, private authService:Auth){}

  username:string=""
  password:string=""

  login(){
    if(this.username === "user" && this.password === "password"){
      this.authService.authenticateUser()
      this.router.navigateByUrl("dashboard")
    }
  }
}
