import {Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {MessageService} from "../services/messageService";
import {Message} from "../models/message";
import {ChannelService} from "../services/channelService";
import {UserService} from "../services/userService";
import {User} from "../models/user";
import {Channel} from "../models/channel";


@Component({
  selector: 'app-message-compose',
  templateUrl: './message-compose.component.html',
  styleUrls: ['./message-compose.component.css']
})
export class MessageComposeComponent implements OnInit {

  @Input() authenticatedUser:User;
  @Input() selectedChannel:Channel;

  message: Message;
  @ViewChild("messageField", { static: false }) messageField: ElementRef;


  constructor(private route: ActivatedRoute, private router: Router,
              public messageService: MessageService,
              private channelService: ChannelService,
              public userService: UserService) {
    this.message = new Message();
  }

  ngOnInit() {
  }


  async saveMessage(){
    await this.messageService.save(this.message, this.selectedChannel, this.authenticatedUser);
  }

  async onSubmit(){
    await this.saveMessage();
    this.messageService.findAll(this.selectedChannel.id);
    this.clearField();
    this.message.body = null;

  }

  clearField(){
    this.messageField.nativeElement.value = '';
  }

}
