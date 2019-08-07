import {Injectable} from "@angular/core";
import { HttpClient} from "@angular/common/http";
import { Channel } from "../models/channel";
import {environment} from "../../environments/environment";
import {User} from "../models/user";
import {Observable} from "rxjs";


@Injectable()
export class ChannelService{

  channels: Channel[];
  stdChans: Channel[]=[];
  defaultChans: Channel[] = [];
  channelsUrl: string;
  selectedChannel: Channel;
  sendto: string;

  constructor(private http: HttpClient){
    this.channelsUrl= environment.apiUrl + "/channels";
    this.selectedChannel = new Channel();
    this.initDefaultChannels().subscribe(data => this.defaultChans = data);
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

  initDefaultChannels(): Observable <Channel[]> {
    this.sendto = this.channelsUrl+"/default";
    return this.http.get<Channel[]>(this.sendto);
  }

  getSelectedChannel(){
    return this.selectedChannel;
  }

  locateDirectChannel(user1:User,user2:User): Observable <Channel>{
    this.sendto = this.channelsUrl+"/"+user1.id+"/"+user2.id;
    return this.http.get<Channel>(this.sendto);



  }

  async updateChannelsAfterLogin(user:User){
    this.sendto = environment.apiUrl + "/users/" + user.id + "/channels";
    await this.http.get<Channel[]>(this.sendto).subscribe(data => user.channels = data);

  }

  getStandardChannelsUser(user:User){
      console.log(user.channels);
      let stdChans:Channel[]=[];
      for(let channel of user.channels) if(!channel.direct) stdChans.push(channel);
      this.stdChans=stdChans;
      return this.stdChans;
  }

}
