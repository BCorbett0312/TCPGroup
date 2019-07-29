import {Injectable} from "@angular/core";
import { HttpClient} from "@angular/common/http";
import { Channel } from "../models/channel";
import {environment} from "../../environments/environment";



@Injectable()
export class ChannelService{

  channels: Channel[];
  channelsUrl: string;
  selectedChannel: Channel;
  sendto: string;



  constructor(private http: HttpClient){
    this.channelsUrl= environment.apiUrl + "/channels";
  }

  async findAll() {
    await this.http.get<Channel[]>(this.channelsUrl).subscribe(data => this.channels = data);


  }

  async findChannelsByUserId(userid:number){
    this.sendto = environment.apiUrl + "/users/"+userid+"/channels";
    await this.http.get<Channel[]>(this.sendto).subscribe(data => this.channels = data);
  }

  getChannels(){
    return this.channels;
  }

  getSelectedChannel(){
    return this.selectedChannel;
  }

}
