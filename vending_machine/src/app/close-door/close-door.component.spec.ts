import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CloseDoorComponent } from './close-door.component';

describe('CloseDoorComponent', () => {
  let component: CloseDoorComponent;
  let fixture: ComponentFixture<CloseDoorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CloseDoorComponent]
    });
    fixture = TestBed.createComponent(CloseDoorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
