import {Component, OnInit, Input, Output, EventEmitter, ViewChild, ElementRef, Injectable} from '@angular/core';
import { ActivatedRoute, Router} from "@angular/router";
import { MessageService} from "../../services/messageService";
import {Message} from "../../models/message";
import {User} from "../../models/user";


@Component({
  selector: 'app-message-compose',
  templateUrl: './message-compose.component.html',
  styleUrls: ['./message-compose.component.css']
})

export class MessageComposeComponent implements OnInit {

  message: Message;
  @Output() updateMessages = new EventEmitter();
  channelNumber: number;
  @ViewChild("messageField", { static: false }) messageField: ElementRef;
  isLoggedIn = false;




  constructor(private route: ActivatedRoute, private router: Router, private messageService: MessageService) {
    this.message = new Message();

  }

  async onSubmit(){

    this.message.updateChannel(this.channelNumber);
    this.saveMessage();
    await this.delay(200);
    this.sendEmit();
  }

  delay(ms: number){
    return new Promise(resolve => setTimeout(resolve, ms));
  }


  async sendEmit(){
    console.log(this.message);
    this.updateMessages.emit(this.message);
  }

  saveMessage(){
    this.messageService.save(this.message).subscribe();
  }

  updateChannelNumber(channelNumber: number){
    this.channelNumber=channelNumber;
  }

  updateUserForMessage(user: User){
    this.message.updateFrom(user);
  }

  userLoggedIn(){
    this.isLoggedIn = true;
  }

  userLoggedOut(){
    this.isLoggedIn = false;
  }

  updateUserAndLoginStatus(user: User){
    if(this.isLoggedIn == false){
      this.updateUserForMessage(user);
      this.userLoggedIn();
    } else{this.updateUserForMessage(new User);
      this.userLoggedIn();}
  }

  logOut(){
    console.log("logged Out")
    this.isLoggedIn = false;
  }

  clearField(){
    this.messageField.nativeElement.value = '';
  }

  ngOnInit() {
    this.channelNumber = 2;
  }

}
