import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Notes } from '../common/Notes';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NoteService {
  url = 'http://localhost:8081/Note';
  constructor(private HttpClient : HttpClient) {

  }

  GetHeader(){
    const token = localStorage.getItem('token');
    return token? new HttpHeaders().set("Authorization",'Token '+ token) : null;
  }
  GetAll(){
    let headers = this.GetHeader();
    if(headers instanceof HttpHeaders)
      return this.HttpClient.get('http://localhost:8081/GetPaging?page=1&limit=20',{headers:headers});
    return this.HttpClient.get('http://localhost:8081/GetPaging?page=1&limit=20');
  }

  SaveNote(note: Notes){
    let headers = this.GetHeader();
    if(headers instanceof HttpHeaders)
      return this.HttpClient.post(this.url, note, {headers:headers});
    return this.HttpClient.post(this.url, note);
  }

  UpdateNote(note: Notes){
    let headers = this.GetHeader();
    if(headers instanceof HttpHeaders)
      return this.HttpClient.put(this.url, note, {headers:headers});
    return this.HttpClient.put(this.url, note);
  }

  RemoveNote(id : bigint){
    let headers = this.GetHeader();
    if(headers instanceof HttpHeaders)
      return this.HttpClient.delete(this.url+'/'+id.toString(), {headers:headers});
    return this.HttpClient.delete(this.url+'/'+id.toString());
  }

  Search(keyword: string){
    let headers = this.GetHeader();
    if(headers instanceof HttpHeaders)
      return this.HttpClient.get('http://localhost:8081/Search'+'/'+ keyword, {headers:headers});
    return this.HttpClient.get('http://localhost:8081/Search'+'/'+ keyword);
  }

  GetFinish(){
    let headers = this.GetHeader();
    if(headers instanceof HttpHeaders)
      return this.HttpClient.get('http://localhost:8081/GetFinish?page=1&limit=20',{headers:headers});
    return this.HttpClient.get('http://localhost:8081/GetFinish?page=1&limit=20');
  }

  UpdateFinish(id : bigint){
    let headers = this.GetHeader();
    if(headers instanceof HttpHeaders)
      return this.HttpClient.get('http://localhost:8081/Note/' + id.toString(),{headers:headers});
    return this.HttpClient.get('http://localhost:8081/Note/' + id.toString());
  }

}
function tap(arg0: () => any): import("rxjs").OperatorFunction<Object, unknown> {
  throw new Error('Function not implemented.');
}

