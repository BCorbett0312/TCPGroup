import {Injectable} from "@angular/core";
import { HttpClient} from "@angular/common/http";
import { Channel } from "../models/channel";
import {environment} from "../../environments/environment";
import {User} from "../models/user";



@Injectable()
export class ChannelService{

  channels: Channel[];
  channelsUrl: string;
  selectedChannel: Channel;



  constructor(private http: HttpClient){
    this.channelsUrl= environment.apiUrl + "/channels";
    this.selectedChannel = new Channel();
  }

  async findAll() {
    await this.http.get<Channel[]>(this.channelsUrl).subscribe(data => this.channels = data);


  }

  getChannels(){
    return this.channels;
  }

  getSelectedChannel(){

    return this.selectedChannel;
  }

  checkIfDirectExist(user1:User, user2:User){
    for(var channel in user1.channels){

    }
  }

}
