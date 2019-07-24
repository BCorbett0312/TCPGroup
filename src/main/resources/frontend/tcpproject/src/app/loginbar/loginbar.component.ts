import {Component, ElementRef, EventEmitter, Injectable, OnInit, Output, ViewChild} from '@angular/core';
import{ User} from "../models/user";
import {UserService} from "../services/userService";



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

  constructor(private userService: UserService) {
    this.userToAuth = new User();
    this.userIsAuthenticated = false;
    this.newUserModal = false;
    this.showNavBar = true;

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
    this.userService.createNewUser(this.userToAuth);
    this.updateNewUserModal();
    this.clearField();

  }



}
