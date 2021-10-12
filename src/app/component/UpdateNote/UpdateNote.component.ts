import { ShareDataService } from './../../c_service/ShareData.service';
import { NoteService } from './../../c_service/Note.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Notes } from 'src/app/common/Notes';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-UpdateNote',
  templateUrl: './UpdateNote.component.html',
  styleUrls: ['./UpdateNote.component.css']
})
export class UpdateNoteComponent implements OnInit {

  Num!: number;
  NoteForm!: FormGroup;
  constructor(private NoteService : NoteService, private ShareDataService : ShareDataService,private Router : Router, private route: ActivatedRoute ) {
    this.NoteForm = new FormGroup({
      'ID': new FormControl({value: this.ShareDataService.SharedID, disabled: true},Validators.required),
      'Content': new FormControl(this.ShareDataService.SharedContent,Validators.required)
    })
  }

  ngOnInit() {

  }

  OnSubmit(){
    if(this.NoteForm.invalid){
      console.log('invalid');
      return;
    }
    this.UpdateNote();
  }

    UpdateNote(){
      var note = new Notes();
      note.id = this.NoteForm.controls['ID'].value;
      note.content = this.NoteForm.controls['Content'].value;
      this.NoteService.UpdateNote(note).subscribe(data=>{
        console.log(note);
        this.Router.navigate(['/ShowToDoList']);
        // window.location.reload();
      });
    }
}
