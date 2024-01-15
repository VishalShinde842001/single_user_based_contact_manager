import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  constructor(private httpClient:HttpClient) { }
 
  getAllContact():Observable<Contact[]>
  {

    return this.httpClient.get<Contact[]>("http://localhost:8080/getAll");
  }
  saveContact(contact:Contact){
    return this.httpClient.post<Contact>("http://localhost:8080/save",contact);
  }
  deleteById(id:number){
    return this.httpClient.delete<Contact>("http://localhost:8080/deleteById/"+id);
  }
}
export class Contact{
  id:number;
  firstName:string;
  lastName:string;
  phoneNumber:string;
  constructor( id:number,firstName:string,lastName:string,phoneNumber:string){
    this.id=id;
    this.firstName=firstName;
    this.lastName=lastName;
    this.phoneNumber=phoneNumber;
  }
 
}
