import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {MessageService} from "../services/messageService";
import {Message} from "../models/message";
import {ChannelService} from "../services/channelService";
import {UserService} from "../services/userService";


@Component({
  selector: 'app-message-compose',
  templateUrl: './message-compose.component.html',
  styleUrls: ['./message-compose.component.css']
})
export class MessageComposeComponent implements OnInit {


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
    await this.messageService.save(this.message);

  }

  async onSubmit(){
    this.message.updateChannelId(this.channelService.selectedChannel.id);
    await this.saveMessage();
    this.messageService.findAll(this.channelService.selectedChannel.id);
    this.clearField();
    this.message.body = null;

  }

  clearField(){
    this.messageField.nativeElement.value = '';
  }

}
