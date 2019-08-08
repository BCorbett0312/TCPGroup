import {Component, Input, OnInit} from '@angular/core';
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

  @Input() authenticatedUser:User;
  @Input() selectedChannel:Channel;


  constructor(public userService: UserService,
              private messageService: MessageService,
              private channelService: ChannelService) { }

  ngOnInit() {
    this.userService.findAll();
  }

  async onUserSelect(user: User){
    //console.log(this.userService.selectedUser);
    this.userService.selectedUser=user;
    this.channelService.locateDirectChannel(this.authenticatedUser,user).subscribe(data => this.selectedChannel = data);

    this.channelService.updateChannelsAfterLogin(this.authenticatedUser);

    this.messageService.findAll(this.selectedChannel.id);
    // this.messageService.findAll() awaiting correction of user Channels
  }
}
