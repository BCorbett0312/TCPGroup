import {Component, Input, OnInit} from '@angular/core';
import {MessageService} from "../services/messageService";
import {ChannelService} from "../services/channelService";
import {User} from "../models/user";
import {Channel} from "../models/channel";

@Component({
  selector: 'app-message-list',
  templateUrl: './message-list.component.html',
  styleUrls: ['./message-list.component.css']
})
export class MessageListComponent implements OnInit {

  @Input() authenticatedUser:User;
  @Input() selectedChannel:Channel;

  constructor(public messageService: MessageService, private channelService: ChannelService) { }

  ngOnInit() {
    this.messageService.findAll(2);
  }

  updateMessageList() {
    this.messageService.findAll(this.selectedChannel.id);
  }




}
