import { Component, OnInit } from '@angular/core';
import {UserService} from "../services/userService";
import {MessageService} from "../services/messageService";
import {ChannelService} from "../services/channelService";
import {User} from "../models/user";
import {Channel} from "../models/channel";

@Component({
  selector: 'app-userlist',
  templateUrl: './userlist.component.html',
  styleUrls: ['./userlist.component.css']
})
export class UserlistComponent implements OnInit {



  constructor(public userService: UserService,
              private messageService: MessageService,
              private channelService: ChannelService) { }

  ngOnInit() {
    this.userService.findAll();
  }

  async onUserSelect(user: User){
    //console.log(this.userService.selectedUser);
    this.userService.selectedUser=user;
    this.channelService.locateDirectChannel(this.userService.authenticatedUser,user).subscribe(data => this.channelService.selectedChannel = data);

    this.channelService.updateChannelsAfterLogin(this.userService.authenticatedUser);

    this.messageService.findAll(this.channelService.selectedChannel.id);
    // this.messageService.findAll() awaiting correction of user Channels
  }
}
