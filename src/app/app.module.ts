import { AddNewUserComponent } from './component/AddNewUser/AddNewUser.component';
import { AddNewToDoComponent } from './component/AddNewToDo/AddNewToDo.component';
import { ShowUserListComponent } from './component/ShowUserList/ShowUserList.component';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { Route, RouterModule } from '@angular/router';
import { HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PageNotFoundComponent } from './component/PageNotFound/PageNotFound.component';
import { ShowToDoListComponent } from './component/ShowToDoList/ShowToDoList.component';
import { UpdateNoteComponent } from './component/UpdateNote/UpdateNote.component';
import { UpdateUserComponent } from './component/UpdateUser/UpdateUser.component';
import { LogoutComponent } from './component/logout/logout.component';

// const routes : Route[]= [
//   {path: 'UpdateNote', component: UpdateNoteComponent},
//   {path: 'UpdateUser', component: UpdateUserComponent},
//   {path: 'AddNewUser', component: AddNewUserComponent},
//   {path: 'AddNewToDo', component: AddNewToDoComponent},
//   {path: 'ShowUserList', component: ShowUserListComponent},
//   {path: 'ShowToDoList', component: ShowToDoListComponent},
//   {path: '',redirectTo: "/ShowToDoList",pathMatch: 'full'},
//   {path: '**', component: PageNotFoundComponent}
// ]

@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    ShowToDoListComponent,
    ShowUserListComponent,
    AddNewToDoComponent,
    AddNewUserComponent,
    UpdateNoteComponent,
    UpdateUserComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
