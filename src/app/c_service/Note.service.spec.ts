/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { NoteService } from './Note.service';

describe('Service: Note', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [NoteService]
    });
  });

  it('should ...', inject([NoteService], (service: NoteService) => {
    expect(service).toBeTruthy();
  }));
});
