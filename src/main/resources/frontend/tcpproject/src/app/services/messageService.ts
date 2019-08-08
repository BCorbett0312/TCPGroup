import {Injectable} from "@angular/core";
import { HttpClient} from "@angular/common/http";
import { Message } from "../models/message";
import {environment} from "../../environments/environment";
import {UserService} from "./userService";
import {ChannelService} from "./channelService";
import {__await} from "tslib";



@Injectable()
export class MessageService{
  messagesUrl: string;
  sendto: string;
  messages: Message[];
  messageToSave: Message;


  constructor(private http: HttpClient, private userService: UserService, private channelService: ChannelService){
    this.messagesUrl= environment.apiUrl + "/messages";
  }

  async save(message: Message){
    this.messageToSave = message;
    this.updateMessageData(this.messageToSave);
    const t = await this.http.post(this.messagesUrl, this.messageToSave).toPromise();
    return t;
  }


  updateMessageData(message: Message){
    message.updateChannelId(this.channelService.selectedChannel.id);
    message.updateUserId(this.userService.authenticatedUser.id);
    console.log(message);
    return message;
  }

  async findAll(channelId: number) {
    this.sendto = this.messagesUrl +"/" + channelId;
    await this.http.get<Message[]>(this.sendto).subscribe(data => this.messages = data);
  }

  getMessages(){
    return this.messages;
  }













}
