import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {MessageService} from "../services/messageService";
import {UserService} from "../services/userService";
import {ChannelService} from "../services/channelService";
import {User} from "../models/user";

@Component({
  selector: 'app-loginbar',
  templateUrl: './loginbar.component.html',
  styleUrls: ['./loginbar.component.css']
})
export class LoginbarComponent implements OnInit {

  @ViewChild("createPasswordField", {static: false}) createPasswordField: ElementRef;
  @ViewChild("createUserNameField", {static: false}) createUserNameField: ElementRef;
  @ViewChild("loginPasswordField", {static: false}) loginPasswordField: ElementRef;
  @ViewChild("loginUserNameField", {static: false}) loginUserNameField: ElementRef;



  constructor(messageService: MessageService, public userService: UserService, channelService: ChannelService) {
  }

  ngOnInit() {
  }

  async onLogin() {
    await this.userService.authenticateUser();
    if (this.userService.authenticatedUser === null) {
    }
  }

  onLogOut(){
    this.userService.logOut();
  }

  onCreateUser(){
    this.userService.createNewUser().then().catch(this.userService.updateShowErrorCreatingUser);
    this.clearCreateField();
  }

  // clearField(){
  //   this.loginPasswordField.nativeElement.value = '';
  //   this.loginUserNameField.nativeElement.value = '';
  //
  // }

  clearCreateField(){
    this.createPasswordField.nativeElement.value = '';
    this.createUserNameField.nativeElement.value = '';
  }
  //
  // addDefaultChannelsToNewUser(user:User){
  //   this.channelService.getAllStandardChannels().subscribe(data => this.channels = data);
  //   this.channels.forEach(chans => {user.subscriptions.push(new Subscription(user.id,chans.id))});
  //   this.subscriptionService.createSubscriptions(user.subscriptions);
  // }
}
