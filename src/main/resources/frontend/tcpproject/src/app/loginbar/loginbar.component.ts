import {Component, ElementRef, EventEmitter, Injectable, OnInit, Output, ViewChild} from '@angular/core';
import{ User} from "../user";
import {UserService} from "../channellist/userService";
import {ChannelService} from "../channellist/channelService";
import {Channel} from "../channel";
import {Subscription} from "../subscription";



@Component({
  selector: 'app-loginbar',
  templateUrl: './loginbar.component.html',
  styleUrls: ['./loginbar.component.css']
})

export class LoginbarComponent implements OnInit {

  userToAuth: User;
  userIsAuthenticated: boolean;
  userReturned: User;
  @ViewChild("passwordField", { static: false }) passwordField: ElementRef;
  @ViewChild("userNameField", { static: false }) userNameField: ElementRef;
  @Output() updateMessageComponents = new EventEmitter();
  @Output() userLogOut = new EventEmitter();
  newUserModal: boolean;
  showNavBar: boolean;
  channels:Channel[];

  constructor(private userService: UserService, private channelService: ChannelService) {
    this.userToAuth = new User();
    this.userIsAuthenticated = false;
    this.newUserModal = false;
    this.showNavBar = true;
    this.channels=null;

  }

  ngOnInit() {
  }


  async onLogin() {
    await this.userService.authenticateUser(this.userToAuth).then(data => this.userReturned = data);
    if(this.userReturned === null){
    }else {this.userIsAuthenticated = true;}
    this.clearField();

    this.updateMessageComponents.emit();

  }

  async onLogOut(){
    this.userToAuth = new User;
    this.userReturned = null;
    this.userIsAuthenticated = false;
    this.userLogOut.emit();
    // this.clearField();

  }

  clearField(){
    this.clearPassword();
    this.clearUserName();

  }

  clearPassword(){
    this.passwordField.nativeElement.value = '';
  }

  clearUserName(){
    this.userNameField.nativeElement.value = '';
  }

  updateNewUserModal(){
    if(this.newUserModal === false){
      this.newUserModal = true;
      this.showNavBar = false;
    }else{this.newUserModal = false;
      this.showNavBar=true;}
  }

  async createNewUser(){
    console.log(this.userToAuth);
    this.channelService.getAllStandardChannels().subscribe(data => this.channels = data)
    this.channels.forEach((chans) => {this.userToAuth.subscriptions.push(new Subscription(this.userToAuth.id,chans.id))});
    this.userService.createNewUser(this.userToAuth);
    this.updateNewUserModal();
    this.clearField();
  }




}
