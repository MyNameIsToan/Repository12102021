import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Users } from 'src/app/common/Users';
import { UsersService } from 'src/app/c_service/Users.service';

@Component({
  selector: 'app-UpdateUser',
  templateUrl: './UpdateUser.component.html',
  styleUrls: ['./UpdateUser.component.css']
})
export class UpdateUserComponent implements OnInit {

  UserForm!: FormGroup;

  constructor(private UserService : UsersService) {
    this.UserForm = new FormGroup({
      'Username': new FormControl(null,Validators.required),
      'Password': new FormControl(null,Validators.required),
      'Email': new FormControl(null,Validators.required),
      'Lastname': new FormControl(null,Validators.required),
      'Firstname': new FormControl(null,Validators.required)
    })
  }

  ngOnInit() {
  }

  OnSubmit(){
    if(this.UserForm.invalid){
      console.log('invalid');
      return;
    }
    this.UpdateUser();
  }

    UpdateUser(){
      var users = new Users();
      users.username = this.UserForm.controls['Username'].value;
      users.password = this.UserForm.controls['Password'].value;
      users.email = this.UserForm.controls['Email'].value;
      users.firstname = this.UserForm.controls['Firstname'].value;
      users.lastname = this.UserForm.controls['Lastname'].value;
      this.UserService.UpdateUser(users).subscribe(data=>{
        console.log(users);
        window.location.reload();
      });
    }
}
