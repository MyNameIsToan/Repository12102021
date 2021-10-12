import { UsersService } from './../../c_service/Users.service';
import { Component, OnInit } from '@angular/core';
import { Users } from 'src/app/common/Users';

@Component({
  selector: 'app-ShowUserList',
  templateUrl: './ShowUserList.component.html',
  styleUrls: ['./ShowUserList.component.css']
})
export class ShowUserListComponent implements OnInit {
  ListOfUser !: Users[];
  constructor(private UserService : UsersService) { }

  ngOnInit() {
    this.GetAll();
  }

  GetAll(){
    this.UserService.GetAll().subscribe(data=>{
      this.ListOfUser = data as Users[];
    });
  }

  RemoveUser(Username : string){
    this.UserService.RemoveUser(Username).subscribe();
    window.location.reload();
  }
}
