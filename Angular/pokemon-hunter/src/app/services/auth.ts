import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { jwtDecode } from 'jwt-decode';

@Injectable({
  providedIn: 'root',
})
export class Auth {
  private _isAuthenticated:boolean = false;
  private key = 'your-secret-key';

  public isAuthenticated():boolean{
    return this._isAuthenticated
  }

  public authenticateUser(){
    let login_token = this.generateToken()
    this.setToken(login_token)
    this._isAuthenticated = true;
  }

  logout(){
    localStorage.removeItem('JWT_token')
    this._isAuthenticated = false;
  }

  public setToken(token:string){
    localStorage.setItem('JWT_token', token)
  }

  getToken(): string | null{
    return localStorage.getItem('JWT_token')
  }

  isLoggedIn(): boolean {
    const token = this.getToken();
    console.log(token);
    if (!token) return false;
    try {
      const decoded: any = jwtDecode(token);
      console.log(Date.now());
      console.log(decoded);
      return decoded.exp * 1000 > Date.now();
    } catch {
      return false;
    }
  }

  generateToken(): string{
    return 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjMiLCJuYW1lIjoiQnJvZHkgUm9jaGUiLCJpYXQiOjE1MTYyMzkwMjIsImV4cCI6MTc2NDE4NzgzMTYxNH0.BV8kP5KB6KmxB4mj-zPsAHqYQbhNgm7FxII7-0MZQTE'
  }
}
