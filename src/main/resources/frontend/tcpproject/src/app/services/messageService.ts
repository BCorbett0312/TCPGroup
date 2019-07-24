import {Injectable} from "@angular/core";
import { HttpClient} from "@angular/common/http";
import { Message } from "../models/message";
import {environment} from "../../environments/environment";
import {UserService} from "./userService";
import {ChannelService} from "./channelService";



@Injectable()
export class MessageService{
  messagesUrl: string;
  sendto: string;
  messages: Message[];


  constructor(private http: HttpClient, private userService: UserService, private channelService: ChannelService){
    this.messagesUrl= environment.apiUrl + "/messages";
  }

  async save(message: Message){
    message.id = this.userService.authenticatedUser.id;
    const t = await this.http.post(this.messagesUrl, message).toPromise();
    return t;
  }

  async findAll(channelId: number) {
    this.sendto = this.messagesUrl +"/" + channelId;
    await this.http.get<Message[]>(this.sendto).subscribe(data => this.messages = data);
  }

  getMessages(){
    return this.messages;
  }













}
