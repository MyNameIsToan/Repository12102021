import { ShareDataService } from './c_service/ShareData.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  title = 'FrontEnd';
  ConditionShow = 0;
  constructor(private ShareDataService: ShareDataService){
    if(localStorage.getItem('token') != null){
      this.ConditionShow = 1;
    }else{
      this.ConditionShow = 0;
    }
  }
}
