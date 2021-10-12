import { UsersService } from 'src/app/c_service/Users.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private Router : Router, private UsersService: UsersService) { }

  ngOnInit(): void {
    this.UsersService.Logout().subscribe(data=>{});
    localStorage.removeItem('token');
    this.Router.navigate(['/AddNewUser']);
  }

}
