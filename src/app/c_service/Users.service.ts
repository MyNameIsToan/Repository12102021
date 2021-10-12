import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Users } from '../common/Users';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  url = 'http://localhost:8081/User';
  SendToken !:string;
  constructor(private HttpClient : HttpClient) {

  }

  GetHeader(){
    const token = localStorage.getItem('token');
    return token? new HttpHeaders().set("Authorization",'Token '+ token) : null;
  }

  GetAll(){
    return  this.HttpClient.get(this.url);
  }

  SaveUser(users : Users){
    return this.HttpClient.post('http://localhost:8081/register', users);
  }

  UpdateUser(users: Users){
    return this.HttpClient.put(this.url, users);
  }

  RemoveUser(id : string){
    return this.HttpClient.delete(this.url+'/'+id);
  }

  LogIn(users : Users){
    return this.HttpClient.post('http://localhost:8081/login',users);
  }

  Logout(){
    let headers = this.GetHeader();
    if(headers instanceof HttpHeaders)
      return this.HttpClient.get('http://localhost:8081/signout',{headers:headers});
      return this.HttpClient.get('http://localhost:8081/signout');
  }
}
