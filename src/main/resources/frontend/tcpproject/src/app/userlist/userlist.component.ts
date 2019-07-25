import { Component, OnInit } from '@angular/core';
import {UserService} from "../services/userService";
import {MessageService} from "../services/messageService";
import {ChannelService} from "../services/channelService";
import {User} from "../models/user";

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

  onUserSelect(user: User): void{
    this.channelService.selectedChannel=null;
    this.userService.selectedUser=user;
    // this.messageService.findAll() awaiting correction of user Channels


  }

}
