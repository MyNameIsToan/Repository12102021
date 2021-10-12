/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { ShareDataService } from './ShareData.service';

describe('Service: ShareData', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ShareDataService]
    });
  });

  it('should ...', inject([ShareDataService], (service: ShareDataService) => {
    expect(service).toBeTruthy();
  }));
});
