import { Token } from './../../common/Token';
import { Router } from '@angular/router';
import { UsersService } from './../../c_service/Users.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Users } from 'src/app/common/Users';

@Component({
  selector: 'app-AddNewUser',
  templateUrl: './AddNewUser.component.html',
  styleUrls: ['./AddNewUser.component.css']
})
export class AddNewUserComponent implements OnInit {
  UserForm!: FormGroup;
  LoginForm!: FormGroup;
  IsHidden = true;
  TypeProcess = 'Sign Up';
  constructor(private UserService : UsersService, private router: Router) {
    this.UserForm = new FormGroup({
      'Username': new FormControl(null,Validators.required),
      'Password': new FormControl(null,Validators.required),
      'Email': new FormControl(null,Validators.required),
      'Lastname': new FormControl(null,Validators.required),
      'Firstname': new FormControl(null,Validators.required)
    })
    this.LoginForm = new FormGroup({
      'Username': new FormControl(null,Validators.required),
      'Password': new FormControl(null,Validators.required)
    })
  }

  ngOnInit() {
  }

  OnSubmit(){
    if(this.UserForm.invalid){
      console.log('invalid');
      return;
    }
    this.SaveUser();
  }

    SaveUser(){
      var users = new Users();
      users.username = this.UserForm.controls['Username'].value;
      users.password = this.UserForm.controls['Password'].value;
      users.email = this.UserForm.controls['Email'].value;
      users.firstname = this.UserForm.controls['Firstname'].value;
      users.lastname = this.UserForm.controls['Lastname'].value;
      this.UserService.SaveUser(users).subscribe(data=>{
        console.log(users);
        window.location.reload();
      });
    }

    OpenRegister(){
      this.IsHidden = !this.IsHidden;
      if(this.IsHidden === false){
        this.TypeProcess = 'Sign In';
      }else{
        this.TypeProcess = 'Sign Up';
      }

    }

    Login(){
      var users = new Users();
      users.username = this.LoginForm.controls['Username'].value;
      users.password = this.LoginForm.controls['Password'].value;
      console.log(users);
      this.UserService.LogIn(users).subscribe(data=>{
        let value = data as Token;
        localStorage.setItem('token',value.token);
        this.router.navigate(['/AddNewToDo']);
      });
    }
  }

