import { Component, OnInit } from '@angular/core';
import {MessageService} from "../services/messageService";
import {ChannelService} from "../services/channelService";

@Component({
  selector: 'app-message-list',
  templateUrl: './message-list.component.html',
  styleUrls: ['./message-list.component.css']
})
export class MessageListComponent implements OnInit {


  constructor(public messageService: MessageService, private channelService: ChannelService) { }

  ngOnInit() {
    this.messageService.findAll(2);
  }

  updateMessageList() {
    this.messageService.findAll(this.channelService.selectedChannel.id);
  }




}
