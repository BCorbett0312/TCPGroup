import { Component, OnInit } from '@angular/core';
import {ChannelService} from "../services/channelService";
import {UserService} from "../services/userService";
import {Channel} from "../models/channel";
import {MessageService} from "../services/messageService";
import {User} from "../models/user";

@Component({
  selector: 'app-channellisttop',
  templateUrl: './channellisttop.component.html',
  styleUrls: ['./channellisttop.component.css']
})
export class ChannellisttopComponent implements OnInit {

  defaultChannels: Channel[] = [];
  selectedChannel: Channel = new Channel();
  users: User[] = [];
  authenticatedUser: User = new User();

  constructor(
    public userService: UserService,
              public channelService: ChannelService,
              private messageService: MessageService
  ) { }

  ngOnInit() {
    /*
    this.channelService.findAllStandard();
    this.userService.findAll();

     */
    this.getDefaultChannels();
    this.getSelectedChannel();
    this.getUsers();
    this.getAuthenticatedUser();
  }


  getDefaultChannels() {
    this.channelService.initDefaultChannels().subscribe(data => this.defaultChannels = data);
  }

  getSelectedChannel() {
    this.selectedChannel = this.channelService.getSelectedChannel();
  }

  getUsers(){
    this.userService.findAll();
    this.users = this.userService.getUsers();
  }

  getAuthenticatedUser(){
    this.authenticatedUser=this.userService.authenticatedUser;
  }

  onChannelSelect(channel: Channel): void{
    this.channelService.selectedChannel=channel;
    this.userService.selectedUser = null;
    this.messageService.findAll(channel.id);
  }

}
