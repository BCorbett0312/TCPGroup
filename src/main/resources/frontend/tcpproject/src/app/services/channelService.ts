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
    this.selectedChannel = new Channel();
  }

  async findAll() {
    await this.http.get<Channel[]>(this.channelsUrl).subscribe(data => this.channels = data);
  }

  async findAllStandard() {
    await this.http.get<Channel[]>(this.channelsUrl+"/standard").subscribe(data => this.channels = data);
  }

  async findChannelsByUserId(userid:number){
    this.sendto = environment.apiUrl + "/users/"+userid+"/channels";
    await this.http.get<Channel[]>(this.sendto).subscribe(data => this.channels = data);
  }

  getChannels(){
    return this.channels;
  }

  getDefaultChannels(){
    let defChan:Channel[]=new Array(0);
    defChan.push(this.channels[0]);
    return defChan;
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

  async locateDirectChannel(user1:User,user2:User){
    let answer = this.checkIfDirectExists(user1,user2);
    if(answer == null) answer = await this.createDirectChannel(user1,user2);
    return answer;
  }

  createDirectChannel(user1:User,user2:User){
    this.sendto = this.channelsUrl+"/"+user1.id+"/"+user2.id;
    this.http.get<Channel>(this.sendto).subscribe(data => this.selectedChannel = data);
    return this.selectedChannel;
  }

  async updateChannelsAfterLogin(user:User){
    this.sendto = environment.apiUrl + "/users/" + user.id + "/channels";
    await this.http.get<Channel[]>(this.sendto).subscribe(data => user.channels = data);

  }

  getStandardChannelsUser(user:User){
      let stdChanCount =0;
      for(let i=0;i<user.channels.length;i++) if(!user.channels[i].direct) stdChanCount++;
      let stdChans:Channel[] = new Array(stdChanCount);
      let counter=0;
      for(let i=0;i<user.channels.length;i++) if(!user.channels[i].direct) stdChans[counter++]=user.channels[i];
      console.log(stdChans);
      return stdChans;
  }
  //
  // getDirectChannelsAuthUser(){
  //   let dirChanCount =0;
  //   for(var i=0;i<this.authenticatedUser.channels.length;i++) if(this.authenticatedUser.channels[i].direct) dirChanCount++;
  //   let dirChans = new Channel[dirChanCount];
  //   let counter=0;
  //   for(i=0;i<this.authenticatedUser.channels.length;i++) if(this.authenticatedUser.channels[i].direct) dirChans[counter++]=this.authenticatedUser.channels[i];
  //   return dirChans;
  // }

  checkIfDirectExist(user1:User, user2:User){
    for(var channel in user1.channels){

    }
  }

}
