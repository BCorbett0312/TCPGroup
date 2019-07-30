import { Component, OnInit } from '@angular/core';
import {ChannelService} from "../services/channelService";
import {UserService} from "../services/userService";
import {Channel} from "../models/channel";
import {MessageService} from "../services/messageService";

@Component({
  selector: 'app-channellisttop',
  templateUrl: './channellisttop.component.html',
  styleUrls: ['./channellisttop.component.css']
})
export class ChannellisttopComponent implements OnInit {



  constructor(
    public userService: UserService,
              public channelService: ChannelService,
              private messageService: MessageService) { }

  ngOnInit() {
    this.channelService.findAll();
    this.userService.findAll();


  }

  onChannelSelect(channel: Channel): void{
    this.channelService.selectedChannel=channel;
    this.userService.selectedUser = null;
    this.messageService.findAll(channel.id);
  }



}
