import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChannellisttopComponent } from './channellisttop.component';

describe('ChannellisttopComponent', () => {
  let component: ChannellisttopComponent;
  let fixture: ComponentFixture<ChannellisttopComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChannellisttopComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChannellisttopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
