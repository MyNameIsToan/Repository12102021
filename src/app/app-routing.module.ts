import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddNewToDoComponent } from './component/AddNewToDo/AddNewToDo.component';
import { AddNewUserComponent } from './component/AddNewUser/AddNewUser.component';
import { LogoutComponent } from './component/logout/logout.component';
import { PageNotFoundComponent } from './component/PageNotFound/PageNotFound.component';
import { ShowToDoListComponent } from './component/ShowToDoList/ShowToDoList.component';
import { ShowUserListComponent } from './component/ShowUserList/ShowUserList.component';
import { UpdateNoteComponent } from './component/UpdateNote/UpdateNote.component';
import { UpdateUserComponent } from './component/UpdateUser/UpdateUser.component';

const routes: Routes = [
  {path: 'Logout', component: LogoutComponent},
  {path: 'UpdateNote', component: UpdateNoteComponent},
  {path: 'UpdateNote/:id', component: UpdateNoteComponent},
  {path: 'UpdateUser', component: UpdateUserComponent},
  {path: 'AddNewUser', component: AddNewUserComponent},
  {path: 'AddNewToDo', component: AddNewToDoComponent},
  {path: 'ShowUserList', component: ShowUserListComponent},
  {path: 'ShowToDoList', component: ShowToDoListComponent},
  {path: '',redirectTo: "/AddNewUser",pathMatch: 'full'},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
