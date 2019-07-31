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

  checkIfDirectExists(user1:User,user2:User){
    for(var i=0;i<user1.channels.length;i++){
      if(user1.channels[i].direct &&
        (user2.id==user1.channels[i].subscriptions[0].userId ||
          user2.id==user1.channels[i].subscriptions[1].userId)) {
        this.selectedChannel=user1.channels[i];
        return this.selectedChannel;
      }
    }
    return null;
  }

  locateDirectChannel(user1:User,user2:User){
    let answer = this.checkIfDirectExists(user1,user2);
    if(answer == null) return this.createDirectChannel(user1,user2);
    return answer;
  }

  async createDirectChannel(user1:User,user2:User){
    this.sendto = this.channelsUrl+"/"+user1.id+"/"+user2.id;
    this.selectedChannel = await this.http.post<Channel>(this.sendto,"").toPromise();
    return this.selectedChannel;
  }

}
