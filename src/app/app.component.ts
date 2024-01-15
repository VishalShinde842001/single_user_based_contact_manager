import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { Contact, ContactService } from './contact.service';
import { identity } from 'rxjs';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet,FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'contact_manager';
  newContact: Contact=new Contact(0,'','','');
  constructor(private contactService:ContactService){


  }
  ngOnInit(): void {
    this.getAllContact();
  }
  contacts:Contact[]=[];
  getAllContact(){
     this.contactService.getAllContact().subscribe(observableObj=>this.contacts=observableObj);
  }
  saveContact(newContact: Contact) {
    this.contactService.saveContact(newContact).subscribe(
      (savedContact) => {
        console.log('Contact saved successfully:', savedContact);
        this.getAllContact(); // Call getAllContact after successful save
      },
      (error) => {
        console.error('Error saving contact:', error);
       
      }
    );}
    deleteById(id:number) {
      this.contactService.deleteById(id).subscribe(
        () => {
          console.log('Contact deleted successfully');
          this.getAllContact(); // Refresh the contact list after successful delete
        },
        (error) => {
          console.error('Error deleting contact:', error);
        }
      );
      }
}
  
    

  



